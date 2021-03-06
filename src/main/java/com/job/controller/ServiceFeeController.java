package com.job.controller;

import com.job.common.statuscode.ServerResponse;
import com.job.entity.ServiceFee;
import com.job.service.ServiceFeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author keith
 * @version 1.0
 * @date 2019/11/8
 */
@Slf4j
@RestController
@Api(tags = "后台付费设置接口")
@RequestMapping(value = "/fee")
public class ServiceFeeController {

    @Autowired
    private ServiceFeeService serviceFeeService;

    @GetMapping("/all")
    @ApiOperation(value = "查询所有服务费信息")
    public ServerResponse findAll(){
        return serviceFeeService.findAll();
    }

    @PutMapping
    @ApiOperation(value = "更新服务费信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceId", value = "主键id", dataType = "int",required = true),
            @ApiImplicitParam(name = "commonRate", value = "普通用户服务费比例", dataType = "string",required = true),
            @ApiImplicitParam(name = "weekRate", value = "周会员用户服务费比例", dataType = "string",required = true),
            @ApiImplicitParam(name = "monthRate", value = "月会员用户服务费比例", dataType = "string",required = true),
            @ApiImplicitParam(name = "seasonRate", value = "季会员用户服务费比例", dataType = "string",required = true),
            @ApiImplicitParam(name = "yearRate", value = "年会员用户服务费比例", dataType = "string",required = true),
            @ApiImplicitParam(name = "remarks", value = "备注", dataType = "string"),
    })
    public ServerResponse updateServiceFee(Integer serviceId, BigDecimal commonRate,BigDecimal weekRate,BigDecimal monthRate,BigDecimal seasonRate,BigDecimal yearRate,String remarks){
        ServiceFee serviceFee=new ServiceFee();
        serviceFee.setServiceId(serviceId);
        serviceFee.setCommonRate(commonRate);
        serviceFee.setWeekRate(weekRate);
        serviceFee.setMonthRate(monthRate);
        serviceFee.setSeasonRate(seasonRate);
        serviceFee.setYearRate(yearRate);
        if(remarks!=null){
            serviceFee.setRemarks(remarks);
        }
        return serviceFeeService.updateServiceFee(serviceFee);
    }
}
