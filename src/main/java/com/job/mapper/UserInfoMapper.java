package com.job.mapper;

import com.job.entity.AdminFoot;
import com.job.entity.ServiceFee;
import com.job.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户信息数据持久层
 * @author keith
 * @version 1.0
 * @date 2019-10-28
 */
@Repository
public interface UserInfoMapper {

    /**
     * 查询手机号是否存在
     *
     * @param phone 手机号码
     * @return 0没有
     */
    UserInfo findByPhone(String phone);

    /**
     * 查询账户通过密码
     * @param phone
     * @param password
     * @return
     */
    UserInfo findPassword(@Param("phone") String phone,@Param("password") String password);

    /**
     * 通过openId查询是否存在
     *
     * @param openId openId
     * @return 0没有
     */
    UserInfo findByOpenId(String openId);

    /**
     * 查询用户信息
     *
     * @param userId 主键id
     * @return 0没有
     */
    UserInfo findByUserId(Integer userId);

    /**
     * 查询有没有正在进行中的任务
     * @param userId
     * @param jobId
     * @return
     */
    int findJob(@Param("userId") Integer userId,@Param("jobId") Integer jobId);

    /**
     * 查询用户信息
     *
     * @param UID UID
     * @return 0没有
     */
    UserInfo findByUId(String UID);

    /**
     * 插入用户信息
     *
     * @param userInfo 用户信息
     * @return 0失败
     */
    int insertPhone(UserInfo userInfo);

    /**
     * 插入验证码到数据库中去
     *
     * @param phone 手机号
     * @param code  验证码
     * @return 0
     */
    int insertCode(@Param("phone") String phone, @Param("code") String code);

    /**
     * 通过手机号查询验证码
     *
     * @param phone 手机号码
     * @return 验证码
     */
    String findCodeByPhone(String phone);

    /**
     * 更新验证码为已使用
     *
     * @param phone 手机号
     * @return 0失败，1成功
     */
    int updateCode(String phone);

    /**
     * uid是否存在
     *
     * @param UID uid
     * @return 0不存在
     */
    int UidIsExist(String UID);

    /**
     * 查询所有用户信息
     *
     * @param phone
     * @param status
     * @return
     */
    List<UserInfo> findAll(@Param("phone") String phone, @Param("status") Integer status);

    /**
     * 发现客服列表
     * @return
     */
    List<UserInfo> findCustomer();

    /**
     * 更新用户信息
     *
     * @param userInfo 用户信息
     * @return
     */
    int updateByPrimaryKeySelective(UserInfo userInfo);

    /**
     * 修改管理员账号密码
     *
     * @param account
     * @param password
     * @return
     */
    int modifyAdminInfo(@Param("account") String account, @Param("password") String password);

    /**
     * 后台登录
     *
     * @param account
     * @param password
     * @return
     */
    Map<String, Object> loginAdminInfo(@Param("account") String account, @Param("password") String password);

    /**
     * 后台让他添加账户
     * @param account
     * @param password
     * @return
     */
    int insertInfo(@Param("account") String account, @Param("password") String password);

    /**
     * 后台账户是否存在
     * @param account
     * @param adminId
     * @return
     */
    int selectInfo(@Param("account") String account,@Param("adminId") Integer adminId);

    /**
     * 删除账户
     * @param adminId
     * @return
     */
    int deleteInfo(@Param("adminId") Integer adminId);

    /**
     * 更新账户密码
     * @param account
     * @param password
     * @param adminId
     * @return
     */
    int updateInfo(@Param("account") String account, @Param("password") String password,@Param("adminId") Integer adminId);

    /**
     * 查询所有
     * @return
     */
    List<Map<String,Object>> selectAll();

    /**
     * 插入用户信息
     *
     * @param record
     * @return
     */
    int insertSelective(UserInfo record);

    /**
     * 插入用户足迹
     * @param adminId
     * @param userId
     * @param content
     * @return
     */
    int insertFoot(@Param("adminId") Integer adminId,@Param("userId") Integer userId,@Param("content") String content);

    /**
     * 查询用户足迹
     * @param account
     * @param phone
     * @param nickName
     * @return
     */
    List<AdminFoot> selectFoot(@Param("account") String account,@Param("phone") String phone,@Param("nickName") String nickName);

    /**
     * 根据主键查询账户信息
     * @param adminId
     * @return
     */
    Map<String,Object> selectById(Integer adminId);
}