package cn.oneseek.dp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Util {
    public static List<String> pre3(String strDate){
        List<String> dateList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHH");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH"); //加上时间
        //必须捕获异常
        try {
            Date date=simpleDateFormat.parse(strDate);

            date.setHours(date.getHours()-1);
            dateList.add(simpleDateFormat.format(date));

            date.setHours(date.getHours()-1);
            dateList.add(simpleDateFormat.format(date));

            date.setHours(date.getHours()-1);
            dateList.add(simpleDateFormat.format(date));

        } catch(ParseException px) {
            px.printStackTrace();
        }

        return dateList;
    }
}
