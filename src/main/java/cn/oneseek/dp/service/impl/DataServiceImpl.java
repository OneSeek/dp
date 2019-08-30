package cn.oneseek.dp.service.impl;

import cn.oneseek.dp.mapper.DataMapper;
import cn.oneseek.dp.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.oneseek.dp.service.IDataService;
import java.util.List;

@Service
public class DataServiceImpl implements IDataService {

    @Autowired(required = false)
    private DataMapper dataMapper;

    @Override
    public List<Data> getAllData() {
        return dataMapper.getAllData();
    }

    @Override
    public int add(Data dpData) {
        System.out.println(dpData);
        return dataMapper.insert(dpData);
    }




    @Override
    public Data byDate(int id) {
        return dataMapper.byDate(id);
    }

    @Override
    public List<Data> byDate2(int id1, int id2) {
        return dataMapper.byDate2(id1,id2);
    }


}
