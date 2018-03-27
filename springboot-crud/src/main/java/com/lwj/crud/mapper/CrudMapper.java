package com.lwj.crud.mapper;

import com.lwj.crud.entity.Crud;
import com.lwj.crud.entity.CrudExample;
import com.lwj.crud.util.ReqPageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CrudMapper {
    long countByExample(CrudExample example);

    int deleteByExample(CrudExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Crud record);

    int insertSelective(Crud record);

    List<Crud> selectByExample(CrudExample example);

    Crud selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Crud record, @Param("example") CrudExample example);

    int updateByExample(@Param("record") Crud record, @Param("example") CrudExample example);

    int updateByPrimaryKeySelective(Crud record);

    int updateByPrimaryKey(Crud record);

    List<Crud> selectRedis(@Param("page") ReqPageUtil pageUtil);

    List<Map<String, Object>> selectWhere(@Param("crud") Crud crud, @Param("page") ReqPageUtil pageUtil);

    Long selectWhereCount(@Param("crud") Crud crud);

    int insertList(@Param("list") List<Crud> list);

    int updateList(@Param("list") List<Crud> list);

    int deleteList(@Param("list") List<Integer> list);
}