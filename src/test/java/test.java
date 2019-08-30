import cn.oneseek.dp.DpApplication;
import cn.oneseek.dp.model.Data;
import cn.oneseek.dp.service.IDataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DpApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class test {

    @Autowired(required = false)   //= =new UserDao();
    private IDataService dataService;  // =new UserDao();

    @Test
    public void list() {
        System.out.println(dataService.getAllData());
    }

   @Test
    public void H(){
        System.out.println(dataService.byDate(2018010101));
    }

    @Test
    public void dd(){
        System.out.println(dataService.byDate2(2018010101,2018010105));
    }

    @Test
    public void getTotalPage(){

        String pageNum1 = "01/28/2019 15";
        String pageNum2 = "01/29/2019 15";
        String[] strArr = pageNum1.split("/| ");

        System.out.println(strArr[2]+strArr[0]+strArr[1]+strArr[3]);

        PageHelper.startPage(1,5);

//        List<Data> dataList = dataService.byDate2(pageNum1,pageNum2);

//        PageInfo<Data> pageInfo = new PageInfo<>(dataList);

    }

}
