package xmt.item.webmanage.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import xmt.item.webmanage.entity.*;

@Mapper
public interface ShoppingCityDao {
    /**
     *查询一级分类
     * @return
     */
    List<FirstClassifyInfo>getFirstSort();

    /**
     *查询二级分类
     * @param
     * @return
     */
    List<SecondClassifyInfo>getSecondSort(Integer id);

    /**
     * 新增分类
     * @param classifyInfo
     * @return
     */
    int addClassify(ClassifyInfo classifyInfo);

    /**
     * 修改分类
     * @param classifyInfo
     * @return
     */
    int updateClassify(ClassifyInfo classifyInfo);

    /**
     * 判断是否有子分类
     * @param id
     * @return
     */
    List<ClassifyInfo> hasSubClassify(String id);

    /**
     * 删除分类
     * @param id
     * @return
     */
    int deleteClassify(String id);

    /**
     * 查询订单
     * @param orderManageInfo
     * @return
     */
    List<OrderManageInfo> selectOrder(OrderManageInfo orderManageInfo);

    /**
     *
     * @param clientInfo
     * @return
     */
    List<ClientInfo>selectClient(ClientInfo clientInfo);

}
