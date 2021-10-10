package xmt.item.webmanage.dao;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import xmt.item.webmanage.entity.AdminInfo;
import xmt.item.webmanage.entity.NumberInfo;

@Mapper
public interface AdminDao {
    /**
     * 新增访问量
     * @return
     */
    int addPageView();
    /**
     * 访问量
     * @return
     */
    NumberInfo countPageViewNumber();
    /**
     * 客户数量
     * @return
     */
    NumberInfo countClientNumber();

    /**
     * 订单数量
     * @return
     */
    NumberInfo countOrderNumber();
    /**
     * 店长登录
     * @param adminInfo
     * @return
     */
    AdminInfo loginStore(AdminInfo adminInfo);
    /**
     * 管理员登录
     * @param adminInfo
     * @return
     */
    AdminInfo loginAdmin(AdminInfo adminInfo);

    /**
     * 查询管理员
     * @param adminInfo
     * @return
     */
    List<AdminInfo> selectAdmin(AdminInfo adminInfo);

    /**
     * 查询店长/分页查询
     * @param adminInfo
     * @return
     */
    List<AdminInfo> selectStoreManage(AdminInfo adminInfo);

    /**
     * 查询账号是否存在,存在查出来密码
     * @param username
     * @return
     */
    List<AdminInfo> exitAccount(String username);

    /**
     * 新增管理员
     */
    int addAdmin(AdminInfo adminInfo);

    /**
     * 修改管理员
     * @param adminInfo
     * @return
     */
    int updateAdmin(AdminInfo adminInfo);

    /**
     * 删除管理员
     * @param adminId
     * @return
     */
    int deleteAdmin(String adminId);
}
