package xmt.item.webapp.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import xmt.item.webapp.entity.AddressInfo;

@Mapper
public interface AddressDao {
    /**
     * 是不是第一次
     * @param userId
     * @return
     */
    Integer isFirst(String userId);
    /**
     * 新增收货地址
     * @param addressInfo
     * @return
     */
    int addAddress(AddressInfo addressInfo);

    /**
     * 收货地址列表
     * @param addressInfo
     * @return
     */
    List<AddressInfo> addressList(AddressInfo addressInfo);

    /**
     * 修改收货地址
     * @param addressInfo
     * @return
     */
    int updateAddress(AddressInfo addressInfo);

    /**
     * 设置所有默认为空
     * @return
     */
    int selectDefaultAsFault(String userId);

    /**
     * 查询默认
     * @param userId
     * @return
     */
    AddressInfo selectDefault(String userId);

    /**
     * 根据id查询地址详情
     * @param id
     * @return
     */
    AddressInfo selectAddressById(String id);
}
