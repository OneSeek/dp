import cn.oneseek.dp.DpApplication;
import cn.oneseek.dp.model.Data;
import cn.oneseek.dp.service.IDataService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DpApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class predect {

    @Autowired(required = false)   //= =new UserDao();
    private IDataService dataService;  // =new UserDao();

    @Test
    public void predictData(){
        Data data = dataService.byDate(2017010101);
        System.out.println(data);
    }

    @Test
    public void pre(){
        String strDate = "2017010101";


        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHH");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH"); //加上时间
        //必须捕获异常
        try {
            Date date=simpleDateFormat.parse(strDate);
            System.out.println(date);
        } catch(ParseException px) {
            px.printStackTrace();
        }
    }
}
