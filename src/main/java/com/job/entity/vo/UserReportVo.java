package com.job.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author keith
 * @version 1.0
 * @date 2019/12/4
 */
@Data
public class UserReportVo {

    @ApiModelProperty(value = "主键id")
    private Integer reportId;

    @ApiModelProperty(value = "用户提交任务主键id")
    private Integer taskId;

    @ApiModelProperty(value = "状态（1.举报中；2.已回复；3.已提交；4.审核通过；5.审核拒绝;6.已结束）")
    private Integer reportStatus;

    @ApiModelProperty(value = "举报原因")
    private String reportReason;

    @ApiModelProperty(value = "举报图片")
    private String reportImg;

    @ApiModelProperty(value = "回复原因（商家回复）")
    private String replyReason;

    @ApiModelProperty(value = "回复图片")
    private String replyImg;

    @ApiModelProperty(value = "提交原因（提交至系统）")
    private String refuteReason;

    @ApiModelProperty(value = "审核原因")
    private String auditReason;

    @ApiModelProperty(value = "举报时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date reportTime;

    @ApiModelProperty(value = "回复时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date replyTime;

    @ApiModelProperty(value = "提交时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date refuteTime;

    @ApiModelProperty(value = "审核时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date auditTime;

    @ApiModelProperty(value = "任务标题")
    private String jobTitle;

    @ApiModelProperty(value = "任务来源")
    private String jobSource;
}

