package com.attacomsian.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void scheduleTaskWithFixedRate() {
        logger.info("Fixed Rate Task: Current Time - {}", formatter.format(LocalDateTime.now()));
    }

    @Scheduled(fixedDelay = 2000)
    public void scheduleTaskWithFixedDelay() throws InterruptedException {
        logger.info("Fixed Delay Task: Start Time - {}", formatter.format(LocalDateTime.now()));

        // add some virtual processing time
        TimeUnit.SECONDS.sleep(3);

        logger.info("Fixed Delay Task: End Time - {}", formatter.format(LocalDateTime.now()));
    }

    @Scheduled(fixedRate = 2000, initialDelay = 5000)
    public void scheduleTaskWithFixedRateAndInitialDelay() {
        logger.info("Fixed Rate Task with Initial Delay: Current Time - {}", formatter.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "0 * * * * ?")
    public void scheduleTaskWithCronExpression() {
        logger.info("Cron Task: Current Time - {}", formatter.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "0 45 4 10 * ?")
    public void scheduleTaskWithCronExpression2() {
        logger.info("Cron Task: Current Time - {}", formatter.format(LocalDateTime.now()));
    }

    @Scheduled(fixedRateString = "${fixed-rate.in.milliseconds}")
    public void scheduleDynamicTaskWithFixedRate() {
        logger.info("Fixed Rate Dynamic Task: Current Time - {}", formatter.format(LocalDateTime.now()));
    }

    @Scheduled(fixedDelayString = "${fixed-delay.in.milliseconds}")
    public void scheduleDynamicTaskWithFixedDelay() {
        logger.info("Fixed Delay Dynamic Task: Current Time - {}", formatter.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "${cron.expression}")
    public void scheduleDynamicTaskWithCronExpression() {
        logger.info("Cron Dynamic Task: Current Time - {}", formatter.format(LocalDateTime.now()));
    }
}
