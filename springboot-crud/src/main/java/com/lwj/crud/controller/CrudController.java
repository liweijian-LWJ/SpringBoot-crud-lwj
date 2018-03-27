package com.lwj.crud.controller;


import com.lwj.crud.config.BaseController;
import com.lwj.crud.entity.Crud;
import com.lwj.crud.service.CrudService;
import com.lwj.crud.util.RedisUtil;
import com.lwj.crud.util.ReqPageUtil;
import com.lwj.crud.util.ResPageUtil;
import com.lwj.crud.util.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Api
@RestController
@RequestMapping("/crud")
public class CrudController extends BaseController {
    protected final Logger logger = LoggerFactory.getLogger(CrudController.class);
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private CrudService crudServiceImpl;
    @Value("${redis.cache.key}")
    private String key;

    @ApiOperation("查询数据库缓存")
    @RequestMapping(value = "/selectRedis", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto selectRedis(ReqPageUtil pageUtil) {
        ResponseDto res = new ResponseDto();
        int start = pageUtil.getOffset();
        if (null != redisUtil.getCacheList(start + key) && redisUtil.getCacheList(start + key).size() > 0) {
            res.setData(redisUtil.getCacheList(start + key));
            logger.info("--查询Redis数据库数据--");
            return res;
        }
        List<Crud> list = crudServiceImpl.selectRedis(pageUtil);
        logger.info("--查询MySQL数据库数据--");
        if (!list.isEmpty()) {
            redisUtil.setCacheList(start + key, list);
        }
        res.setData(list);
        return res;
    }

    @ApiOperation("单条新增")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto insert(@RequestBody Crud crud) {
        ResponseDto res = new ResponseDto();
        res.setData(crudServiceImpl.insert(crud));
        redisUtil.delKey("*" + key);
        return res;
    }

    @ApiOperation("单条查询")
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    @ResponseBody
    public Crud selectById(@RequestParam(required = true) int id) {
        return crudServiceImpl.selectById(id);
    }

    @ApiOperation("单条修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto update(@RequestBody Crud crud) {
        ResponseDto res = new ResponseDto();
        res.setData(crudServiceImpl.update(crud));
        redisUtil.delKey("*" + key);
        return res;
    }

    @ApiOperation("单条删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto delete(@RequestParam(required = true) int id) {
        ResponseDto res = new ResponseDto();
        res.setData(crudServiceImpl.delete(id));
        redisUtil.delKey("*" + key);
        return res;
    }

    @ApiOperation("条件查询分页")
    @RequestMapping(value = "selectWhere", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto selectWhere(@RequestBody Crud crud, ReqPageUtil reqPageUtil) {
        ResponseDto res = new ResponseDto();
        List<Map<String, Object>> maps = crudServiceImpl.selectWhere(crud, reqPageUtil);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("page", new ResPageUtil(reqPageUtil, crudServiceImpl.selectWhereCount(crud)));
        maps.add(map);
        res.setData(maps);
        return res;
    }

    @ApiOperation("批量新增")
    @RequestMapping(value = "insertList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto insertList(@RequestBody List<Crud> list) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(crudServiceImpl.insertList(list));
        return responseDto;
    }

    @ApiOperation("批量修改")
    @RequestMapping(value = "updateList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto updateList(@RequestBody List<Crud> list) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(crudServiceImpl.updateList(list));
        return responseDto;
    }

    @ApiOperation("批量删除")
    @RequestMapping(value = "deleteList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto deleteList(@RequestBody List<Integer> list) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(crudServiceImpl.deleteList(list));
        return responseDto;
    }
}
