package cn.oneseek.dp.service;

import cn.oneseek.dp.model.Data;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface IDataService{
    List<Data> getAllData();
    int add(Data dpData);
    Data byDate(int id);
    List<Data> byDate2(int id1, int id2);
}