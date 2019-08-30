package cn.oneseek.dp.controller;

import cn.oneseek.dp.model.Data;
import cn.oneseek.dp.service.IDataService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired   //= =new UserDao();
    private IDataService dataService;  // =new UserDao();

    @RequestMapping("/list")
    @ResponseBody
    public List<Data>  list() {
        List<Data> dataList = dataService.getAllData();
        return dataList;
    }

    @RequestMapping("/getAllDataListPage")
    @ResponseBody
    public List<Data> getAllData(@RequestParam(value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Data> list = dataService.getAllData();
        PageInfo<Data> pageInfo = new PageInfo<>(list);

        List<Data> five = pageInfo.getList();
        System.out.println("-----getAllDataListPage---getAllData---获取数据----");
        return five;
    }


    @RequestMapping("/getTotalPage")
    @ResponseBody
    public long getTotalPage(){
        PageHelper.startPage(1,10);

        List<Data> list = dataService.getAllData();
        PageInfo<Data> pageInfo = new PageInfo<>(list);
        System.out.println("----getTotalPage-----");
        return pageInfo.getTotal();
    }

    @RequestMapping("/getSelectPage")
    @ResponseBody
    public long getSelectPage(@RequestParam(defaultValue = "01/28/2019 15:31:11",value = "pageNum1") String pageNum1,@RequestParam(defaultValue = "01/28/2019 20:31:11",value = "pageNum2") String pageNum2){

        String[] strArr = pageNum1.substring(0,13).split("/| ");
        String[] strArr2 = pageNum2.substring(0,13).split("/| ");

        int page1 = Integer.parseInt(strArr[2]+strArr[0]+strArr[1]+strArr[3]);
        int page2 = Integer.parseInt(strArr2[2]+strArr2[0]+strArr2[1]+strArr2[3]);


        List<Data> dataList = dataService.byDate2(page1,page2);

        PageInfo<Data> pageInfo = new PageInfo<>(dataList);

        System.out.println("---getSelectPage---");
        return pageInfo.getTotal();
    }


    @RequestMapping("/byDateGetData")
    @ResponseBody
    public Data byDateGetData(@RequestParam(defaultValue = "2017010101",value = "date") Integer date){
        return dataService.byDate(date);
    }

    @RequestMapping("/predict")
    public float predict(@RequestParam(defaultValue = "2017010101",value = "date") Integer date){
        float result = 0;
        return result;
    }

    @RequestMapping("date1ToDate2")
    @ResponseBody
    public List<Data> date1ToDate2(@RequestParam(defaultValue = "01/28/2019 15",value = "pageNum1") String pageNum1,@RequestParam(defaultValue = "01/28/2019 15",value = "pageNum2") String pageNum2,@RequestParam(defaultValue = "1",value = "pageNum") int pageNum){
        String[] strArr = pageNum1.substring(0,13).split("/| ");
        String[] strArr2 = pageNum2.substring(0,13).split("/| ");

        int page1 = Integer.parseInt(strArr[2]+strArr[0]+strArr[1]+strArr[3]);
        int page2 = Integer.parseInt(strArr2[2]+strArr2[0]+strArr2[1]+strArr2[3]);

        System.out.println("---page1--"+page1+"----");
        System.out.println("---page2--"+page2+"----");
        PageHelper.startPage(pageNum,10);
        List<Data> list = dataService.byDate2(page1,page2);
        PageInfo<Data> pageInfo = new PageInfo<>(list);

        List<Data> five = pageInfo.getList();

        System.out.println("--five--");
        return five;
    }

}
