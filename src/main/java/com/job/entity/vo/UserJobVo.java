package com.job.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author keith
 * @version 1.0
 * @date 2019/11/11
 */
@Data
public class UserJobVo {

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "任务id")
    private Integer jobId;

    @ApiModelProperty(value = "主键id")
    private Integer taskId;

    @ApiModelProperty(value = "项目名称")
    private String jobSource;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "头像")
    private String headimgurl;

    @ApiModelProperty(value = "任务标题")
    private String jobTitle;

    @ApiModelProperty(value = "提交时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Data commitTime;

    @ApiModelProperty(value = "拒绝原因")
    private String refuseReason;

    @ApiModelProperty(value = "提交信息")
    private String commitInfo;

    @ApiModelProperty(value = "图片")
    private List<String> imgList;
}
