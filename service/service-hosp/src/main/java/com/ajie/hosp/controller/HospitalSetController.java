package com.ajie.hosp.controller;

import com.ajie.common.AjieResult;
import com.ajie.hosp.service.HospitalSetService;
import com.ajie.model.hosp.HospitalSet;
import com.ajie.vo.hosp.HospitalSetQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
    public AjieResult findAll() {
        List<HospitalSet> list = hospitalSetService.list();
        return AjieResult.okResult().data("List<HospitalSet>", list);
    }

    @ApiOperation(value = "医院设置删除")
    @DeleteMapping("{id}")
    public AjieResult removeById(@ApiParam(name = "id", value = "讲师 id", required = true)
                                 @PathVariable String id) {
        hospitalSetService.removeById(id);
        return AjieResult.okResult();
    }

    @ApiOperation(value = "分页医院设置列表")
    @GetMapping("{page}/{limit}")
    public AjieResult pageList(@ApiParam(name = "page", value = "当前页码", required = true)
                               @PathVariable Long page,
                               @ApiParam(name = "limit", value = "每页记录数", required = true)
                               @PathVariable Long limit) {
        Page<HospitalSet> pageParam = new Page<>(page, limit);
        hospitalSetService.page(pageParam, null);
        List<HospitalSet> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return AjieResult.okResult()
                .data("total", total)
                .data("rows", records);
    }


    @ApiOperation(value = "分页条件医院设置列表")
    @PostMapping("{page}/{limit}")
    public AjieResult pageQuery(@ApiParam(name = "page", value = "当前页码", required = true)
                                @PathVariable Long page,
                                @ApiParam(name = "limit", value = "每页记录数", required = true)
                                @PathVariable Long limit,
                                @ApiParam(name = "hospitalSetQueryVo", value = "查询对象", required = false)
                                @RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo) {
        Page<HospitalSet> pageParam = new Page<>(page, limit);
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        if (hospitalSetQueryVo != null) {
            String hosname = hospitalSetQueryVo.getHosname();
            String hoscode = hospitalSetQueryVo.getHoscode();
            if (!StringUtils.isEmpty(hosname)) {
                queryWrapper.like("hosname", hosname);
            }
            if (!StringUtils.isEmpty(hoscode)) {
                queryWrapper.like("hoscode", hoscode);
            }
        }
        hospitalSetService.page(pageParam, queryWrapper);
        List<HospitalSet> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return AjieResult.okResult()
                .data("total", total)
                .data("rows", records);
    }

}
