package com.job.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author keith
 * @version 1.0
 * @date 2019/11/14
 */
@Data
public class UserCashOut {

    @ApiModelProperty(value = "主键id")
    private Integer cashOutId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "提现类型（1.保证金；2.任务余额；3.充值余额；4.奖金余额）")
    private Integer cashOutType;

    @ApiModelProperty(value = "交易方式（1.支付宝。2.微信）")
    private Integer tradeType;

    @ApiModelProperty(value = "提现金额")
    private BigDecimal cashOutMoney;

    @ApiModelProperty(value = "打款金额")
    private BigDecimal makeMoney;

    @ApiModelProperty(value = "审核状态（1.审核中；2.审核拒绝；3.审核通过）")
    private Integer auditStatus;

    @ApiModelProperty(value = "申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date applyTime;

    @ApiModelProperty(value = "审核时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date auditTime;

    @ApiModelProperty(value = "拒绝原因")
    private String refuseReason;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "姓名")
    private String zfbName;

    @ApiModelProperty(value = "支付宝账户")
    private String zfbAccount;
}