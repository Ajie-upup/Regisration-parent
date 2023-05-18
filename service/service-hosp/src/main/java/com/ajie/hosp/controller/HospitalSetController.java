package com.ajie.hosp.controller;

import com.ajie.hosp.service.HospitalSetService;
import com.ajie.model.hosp.HospitalSet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ajie
 * @date 2023/5/18
 * @description:
 */
@Api(description = "医院设置接口")
@RestController
@CrossOrigin // 设置跨域
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation(value = "医院设置列表")
    @GetMapping("/findAll")
    public List<HospitalSet> findAll() {
        return hospitalSetService.list();
    }
    @ApiOperation(value = "医院设置删除")
    @DeleteMapping("{id}")
    public boolean removeById(@PathVariable String id) {
        return hospitalSetService.removeById(id);
    }

}
