package com.ajie.hosp.controller;

import com.ajie.hosp.service.HospitalSetService;
import com.ajie.model.hosp.HospitalSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ajie
 * @date 2023/5/18
 * @description:
 */
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
@CrossOrigin // 设置跨域
public class HospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;

    @GetMapping("/findAll")
    public List<HospitalSet> findAll() {
        return hospitalSetService.list();
    }

    @DeleteMapping("{id}")
    public boolean removeById(@PathVariable String id) {
        return hospitalSetService.removeById(id);
    }

}
