package xmt.item.webmanage.service;

import org.springframework.stereotype.Service;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.StoreInfo;
import xmt.item.webmanage.dao.ShoppingCityDao;
import xmt.item.webmanage.entity.*;

import java.util.List;

import javax.annotation.Resource;

@Service
public class ShoppingCityService {

    @Resource
    private ShoppingCityDao shoppingCityDao;

    /**
     * 获取一二级分类
     * @return
     */
    public AppResponse getAllSort(){
        List<FirstClassifyInfo> firstFirstClassifyInfoList = shoppingCityDao.getFirstSort();//获取一级分类
        for(FirstClassifyInfo firstClassifyInfo:firstFirstClassifyInfoList){
            List<SecondClassifyInfo> secondFirstClassifyInfoList = shoppingCityDao.getSecondSort(Integer.valueOf(firstClassifyInfo.getId()));//获取二级分类
            firstClassifyInfo.setChildren(secondFirstClassifyInfoList);
        }
        return AppResponse.success("成功",firstFirstClassifyInfoList);
    }

    /**
     * 新增分类
     * @param classifyInfo
     * @return
     */
    public AppResponse addClassify(ClassifyInfo classifyInfo){
        int resultOfAdd = shoppingCityDao.addClassify(classifyInfo);
        return AppResponse.success("新增成功",resultOfAdd);
    }

    /**
     * 修改分类
     * @param classifyInfo
     * @return
     */
    public AppResponse updateClassify(ClassifyInfo classifyInfo){
        int resultOfUpdate = shoppingCityDao.updateClassify(classifyInfo);
        return AppResponse.success("修改成功",resultOfUpdate);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    public AppResponse deleteClassify(String id){
        List<ClassifyInfo> classifyInfoList = shoppingCityDao.hasSubClassify(id);
        if(classifyInfoList.size() != 0){
            return AppResponse.versionError("该分类下还存在子类","couldn't delete");
        }
        int resultOfDelete = shoppingCityDao.deleteClassify(id);
        return AppResponse.success("删除成功",resultOfDelete);
    }

    /**
     * 查询订单
     * @param orderManageInfo
     * @return
     */
    public AppResponse selectOrder(OrderManageInfo orderManageInfo){
        List<OrderManageInfo> orderManageInfoList = shoppingCityDao.selectOrder(orderManageInfo);
        return AppResponse.success("成功",orderManageInfoList);
    }

    /**
     *客户查询
     * @param clientInfo
     * @return
     */
    public AppResponse selectClient(ClientInfo clientInfo){
        List<ClientInfo> clientInfoList = shoppingCityDao.selectClient(clientInfo);
        for(ClientInfo obj:clientInfoList){
            if(obj.getSex() == null){
                obj.setSex("未知");
            }
            if(obj.getSex().equals("1")){
                obj.setSex("男");
            }
            if(obj.getSex().equals("2")){
                obj.setSex("女");
            }
        }
        return AppResponse.success("成功",clientInfoList);
    }

}
