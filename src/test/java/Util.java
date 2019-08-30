import java.text.SimpleDateFormat;
import java.util.Date;

public class Util
{
    public static String getPreHour(String format)
    {
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        Date d=new Date();
        d.setHours(d.getHours()-1);
        return sdf.format(d);
    }

    public static void main(String[] args)
    {
        System.out.println(Util.getPreHour("yyyyMMddHH"));
    }
}