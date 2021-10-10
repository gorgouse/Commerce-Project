package xmt.item.webapp.dao;

import org.apache.ibatis.annotations.Mapper;
import xmt.item.webapp.entity.UserInfo;

import java.util.List;

@Mapper
public interface UserDao {
    //新增访问量
    int addPageView();
    //是否已有账号
    int hasAlreadyAcctAndPhone(UserInfo userInfo);

    //注册
    int register(UserInfo userInfo);

    //登录
    UserInfo clientLogin(UserInfo userInfo);

    //查询用户详情
    UserInfo getDetail(UserInfo userInfo);

}
