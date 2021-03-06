package com.job.controller;

import cn.hutool.core.date.DateUtil;
import com.job.common.statuscode.ServerResponse;
import com.job.common.utils.MD5Util;
import com.job.entity.UserInfo;
import com.job.entity.UserMoney;
import com.job.service.UserInfoService;
import com.job.task.TimerTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author keith
 * @version 1.0
 * @date 2019/10/28
 */
@Slf4j
@RestController
@Api(tags = "后台用户管理")
@RequestMapping(value = "/user/admin")
public class AdminUserInfoController {

    private final UserInfoService userInfoService;

    private final TimerTask timerTask;

    public AdminUserInfoController(UserInfoService userInfoService, TimerTask timerTask) {
        this.userInfoService = userInfoService;
        this.timerTask = timerTask;
    }


    @PutMapping("/info")
    @ApiOperation(value = "修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "int", required = true),
            @ApiImplicitParam(name = "phone", value = "用户id", dataType = "手机号"),
            @ApiImplicitParam(name = "nickname", value = "昵称", dataType = "string"),
            @ApiImplicitParam(name = "sex", value = "性别1.男，2女，0未知", dataType = "int"),
            @ApiImplicitParam(name = "province", value = "省份", dataType = "string"),
            @ApiImplicitParam(name = "city", value = "城市", dataType = "string"),
            @ApiImplicitParam(name = "country", value = "国家", dataType = "string"),
            @ApiImplicitParam(name = "headimgurl", value = "头像路径", dataType = "string"),
            @ApiImplicitParam(name = "UID", value = "用户推广码", dataType = "string"),
            @ApiImplicitParam(name = "upUID", value = "上级用户推广码", dataType = "string"),
            @ApiImplicitParam(name = "memberDate", value = "会员有效期（用户必须是会员才能选择时间）", dataType = "string"),
            @ApiImplicitParam(name = "isMember", value = "是否是会员（1.不是；2是）", dataType = "int"),
            @ApiImplicitParam(name = "adminId", value = "管理员账户主键id", dataType = "int"),
            @ApiImplicitParam(name = "status", value = "用户状态（0，正常，1正常）", dataType = "int"),
    })
    public ServerResponse updateUserInfo(Integer status,Integer userId, String phone, String nickname, Integer sex, String province, String city,
                                         String country, String headimgurl, String UID, String upUID, String memberDate, Integer isMember,Integer adminId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        if (phone != null && !"".equals(phone)) {
            userInfo.setPhone(phone);
        }
        if (nickname != null && !"".equals(nickname)) {
            userInfo.setNickname(nickname);
        }
        if (province != null && !"".equals(province)) {
            userInfo.setProvince(province);
        }
        if (city != null && !"".equals(city)) {
            userInfo.setCity(city);
        }
        if (country != null && !"".equals(country)) {
            userInfo.setCountry(country);
        }
        if (headimgurl != null && !"".equals(headimgurl)) {
            userInfo.setHeadimgurl(headimgurl);
        }
        if (UID != null && !"".equals(UID)) {
            userInfo.setUID(UID);
        }
        if (upUID != null && !"".equals(upUID)) {
            userInfo.setUpUID(upUID);
        }
        if (memberDate != null && !"".equals(memberDate)) {
            userInfo.setWeekMemberTime(DateUtil.parse(memberDate, "yyyy-MM-dd HH:mm:ss"));
        }
        if (isMember != null) {
            userInfo.setIsMember(isMember);
        }
        if (sex != null) {
            userInfo.setSex(sex);
        }
        userInfo.setStatus(status);
        return userInfoService.updateUserInfo(userInfo,adminId);
    }

    @GetMapping("/all")
    @ApiOperation(value = "获取所有用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "第几页", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条", dataType = "int", defaultValue = "10"),
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "string"),
            @ApiImplicitParam(name = "status", value = "状态（0正常，1黑名单）", dataType = "nt"),
    })
    public ServerResponse findAll(Integer pageNo, Integer pageSize, String phone, Integer status) {
        return userInfoService.findAll(pageNo, pageSize, phone, status);
    }

    @PutMapping("/money")
    @ApiOperation(value = "更改用户账户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "int", required = true),
            @ApiImplicitParam(name = "balance", value = "任务余额", dataType = "int"),
            @ApiImplicitParam(name = "repaidBalance", value = "充值余额", dataType = "int"),
            @ApiImplicitParam(name = "bonus", value = "奖金余额", dataType = "int")
    })
    public ServerResponse updateUserMoney(Integer userId, BigDecimal balance, BigDecimal repaidBalance, BigDecimal bonus) {
        UserMoney userMoney = new UserMoney();
        userMoney.setUserId(userId);
        if (balance != null) {
            userMoney.setBalance(balance);
        }
        if (repaidBalance != null) {
            userMoney.setRepaidBalance(repaidBalance);
        }
        if (bonus != null) {
            userMoney.setBonus(bonus);
        }
        return userInfoService.updateMoney(userMoney);
    }

    @PutMapping
    @ApiOperation(value = "修改管理员账户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账户", dataType = "string", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string"),
            @ApiImplicitParam(name = "adminId", value = "主键id", dataType = "int", required = true),
    })
    public ServerResponse modifyAdminInfo(String account, String password,Integer adminId) {
        String md5Password;
        if(password!=null){
            md5Password=MD5Util.md5EncodeUtf8(password);
        }else{
            md5Password= null;
        }
        return userInfoService.modifyAdminInfo(account, md5Password,adminId);
    }

    @GetMapping("/allInfo")
    @ApiOperation(value = "查询所有后台账号")
    public ServerResponse selectAllAdmin(){
        return userInfoService.selectAll();
    }

    @PostMapping
    @ApiOperation(value = "插入管理员账户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账户", dataType = "string", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string", required = true),
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "string", required = true),
    })
    public ServerResponse insertInfo(String account, String password,String phone){
        return userInfoService.insertInfo(account, MD5Util.md5EncodeUtf8(password),phone);
    }

    @DeleteMapping
    @ApiOperation(value = "删除管理员账户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "adminId", value = "主键id", dataType = "int", required = true),
    })
    public ServerResponse deleteInfo(Integer adminId){
        return userInfoService.deleteInfo(adminId);
    }


    @GetMapping
    @ApiOperation(value = "后台登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账户", dataType = "string", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string", required = true),
    })
    public ServerResponse loginAdminInfo(String account, String password) {
        return userInfoService.loginAdminInfo(account, MD5Util.md5EncodeUtf8(password));
    }

    @PutMapping("/blacklist")
    @ApiOperation(value = "用户加入黑名单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "int", required = true),
            @ApiImplicitParam(name = "reason", value = "原因", dataType = "string", required = true),
            @ApiImplicitParam(name = "adminId", value = "管理员账户主键id", dataType = "int"),
    })
    public ServerResponse updateUserInfo(Integer userId, String reason,Integer adminId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setReason(reason);
        return userInfoService.updateBlack(userInfo,adminId);
    }

    @GetMapping("/testMember")
    @ApiOperation(value = "测试会员")
    public void testMember(){
        timerTask.member();
    }

    @GetMapping("/foot")
    @ApiOperation(value = "后台用户足迹")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "第几页", dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条", dataType = "int", defaultValue = "10"),
            @ApiImplicitParam(name = "account", value = "管理员账号", dataType = "string"),
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "string"),
            @ApiImplicitParam(name = "nickName", value = "昵称", dataType = "string"),
    })
    public ServerResponse selectFoot(Integer pageNo,Integer pageSize,String account,String phone,String nickName){
        return userInfoService.selectFoot(pageNo, pageSize, account, phone, nickName);
    }

}
