package cn.oneseek.dp.mapper;

import cn.oneseek.dp.model.Data;

import java.util.List;

public interface DataMapper {
    int insert(Data record);

    int insertSelective(Data record);
    Data byDate(Integer id);

    List<Data> getAllData();

    List<Data> byDate2(Integer id1,Integer id2);
}