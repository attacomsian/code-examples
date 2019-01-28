package app.ses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SESProcessor extends Thread {

    private static final Logger LOG = Logger.getLogger(SESProcessor.class.getName());

    private boolean iCanContinue = true;

    private static SESProcessor sInstance = null;

    private SESWorker[] workers;

    private final Queue<AmazonEmail> queue = new LinkedList<>();

    private final int MAX_SLEEP_TIME = 3 * 60 * 60 * 1000; //3 hours

    private final int MAX_WORKERS = 1;

    private int current = 0;

    public SESProcessor() {
        super("SESProcessor");
        setDaemon(true);
    }

    @Override
    public void run() {
        LOG.log(Level.INFO, "Amazon SES processor is up and running.");
        //initialize workers
        initializeWorkers();
        //start processing
        while (iCanContinue) {
            synchronized (queue) {
                // Check for a new item from the queue
                if (queue.isEmpty()) {
                    // Sleep for it, if there is nothing to do
                    LOG.log(Level.INFO, "Waiting for Amazon SES email to send...{0}", getTime());
                    try {
                        queue.wait(MAX_SLEEP_TIME);
                    } catch (InterruptedException e) {
                        LOG.log(Level.INFO, "Interrupted...{0}", getTime());
                    }
                }
                //distribute tasks among workers
                while (!queue.isEmpty()) {
                    workers[current++].add(queue.poll());
                    current = current % MAX_WORKERS;
                }
            }
        }
    }

    public static synchronized SESProcessor getInstance() {
        if (sInstance == null) {
            sInstance = new SESProcessor();
            sInstance.start();
        }
        return sInstance;
    }

    private void initializeWorkers() {
        LOG.info("Amazon SES workers are initializing ....");
        workers = new SESWorker[MAX_WORKERS];
        for (int i = 0; i < MAX_WORKERS; i++) {
            workers[i] = new SESWorker(i + 1);
            workers[i].start();
        }
    }

    private void stopWorkers() {
        LOG.info("Amazon SES workers are stopping...");
        for (int i = 0; i < MAX_WORKERS; i++) {
            workers[i].stopWorker();
        }
    }

    public void add(AmazonEmail item) {
        synchronized (queue) {
            queue.add(item);
            queue.notify();
            LOG.info("New Amazon SES email added into queue...");
        }
    }

    public static void stopProcessor() {
        if (sInstance == null) {
            return;
        }
        LOG.info("Stopping Amazon SES file processor...");
        try {
            //stop workers first
            sInstance.stopWorkers();
            sInstance.iCanContinue = false;
            sInstance.interrupt();
            sInstance.join();
        } catch (InterruptedException | NullPointerException e) {
            LOG.log(Level.SEVERE, "Exception while stop Amazon SES processor...{0}",
                            e.getMessage());
        }
    }

    /*
     * Get current server date & time
    */
    public String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        return format.format(new Date());
    }
}
