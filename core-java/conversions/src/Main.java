import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) throws Exception {

        // string to int conversion
        String str = "1050";

        int inum = Integer.parseInt(str);   //return primitive
        System.out.println(inum);

        Integer onum = Integer.valueOf(str); //return object
        System.out.println(onum);

        // string to long conversion
        String longStr = "1456755";

        long ilong = Long.parseLong(longStr); //return primitive
        System.out.println(ilong);

        Long olong = Long.valueOf(longStr); //return object
        System.out.println(olong);

        // string to float conversion
        String floatStr = "49.78";

        float ifloat = Float.parseFloat(floatStr); //return primitive
        System.out.println(ifloat);

        Float ofloat = Float.valueOf(floatStr); //return object
        System.out.println(ofloat);

        // string to double conversion
        String doubleStr = "99.378";

        double idouble = Double.parseDouble(doubleStr); //return primitive
        System.out.println(idouble);

        Double odouble = Double.valueOf(doubleStr); //return object
        System.out.println(odouble);

        // NumberFormatException example
        try {
            String exeStr = "14c";
            int exeInt = Integer.parseInt(exeStr);
            System.out.println(exeInt);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

        //string to boolean conversion
        String trueStr = "true";
        String falseStr = "false";
        String randomStr = "java";

        System.out.println(Boolean.parseBoolean(trueStr)); //true
        System.out.println(Boolean.valueOf(falseStr)); //false
        System.out.println(Boolean.parseBoolean(randomStr)); //false

        // string to date conversion
        String dateStr = "10/03/2019";

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObj = format.parse(dateStr);
        System.out.println(dateObj);

        // date to string conversion
        Date date = Calendar.getInstance().getTime(); // OR new Date()

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy HH:mm:ss.SSS Z");

        String formatStr = dateFormat.format(date);
        System.out.println(formatStr);

        //date to ISO 8601 string
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        isoFormat.setTimeZone(timeZone);
        String isoFormatStr = isoFormat.format(new Date());
        System.out.println(isoFormatStr);

    }
}
