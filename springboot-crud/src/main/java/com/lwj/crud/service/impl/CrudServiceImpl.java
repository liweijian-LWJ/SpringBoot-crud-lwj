package com.lwj.crud.service.impl;

import com.lwj.crud.entity.Crud;
import com.lwj.crud.mapper.CrudMapper;
import com.lwj.crud.service.CrudService;
import com.lwj.crud.util.ReqPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CrudServiceImpl implements CrudService {


    @Autowired
    CrudMapper crudMapper;

    @Override
    public List<Crud> selectRedis(ReqPageUtil pageUtil) {
        return crudMapper.selectRedis(pageUtil);
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class, Error.class})
    @Override
    public int insert(Crud crud) {
        return crudMapper.insertSelective(crud);
    }

    @Override
    public Crud selectById(int id) {
        return crudMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Crud crud) {
        return crudMapper.updateByPrimaryKey(crud);
    }

    @Override
    public int delete(int id) {
        return crudMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map<String, Object>> selectWhere(Crud crud, ReqPageUtil pageUtil) {
        return crudMapper.selectWhere(crud, pageUtil);
    }

    @Override
    public Long selectWhereCount(Crud crud) {
        return crudMapper.selectWhereCount(crud);
    }

    @Override
    public int insertList(List<Crud> list) {
        return crudMapper.insertList(list);
    }

    @Override
    public int updateList(List<Crud> list) {
        return crudMapper.updateList(list);
    }

    @Override
    public int deleteList(List<Integer> list) {
        return crudMapper.deleteList(list);
    }
}
