package com.lwj.crud.service;

import com.lwj.crud.entity.Crud;
import com.lwj.crud.util.ReqPageUtil;

import java.util.List;
import java.util.Map;

public interface CrudService {

    List<Crud> selectRedis(ReqPageUtil pageUtil);

    int insert(Crud crud);

    Crud selectById(int id);

    int update(Crud crud);

    int delete(int id);

    List<Map<String, Object>> selectWhere(Crud crud, ReqPageUtil pageUtil);

    Long selectWhereCount(Crud crud);

    int insertList(List<Crud> list);

    int updateList(List<Crud> list);

    int deleteList(List<Integer> list);
}
