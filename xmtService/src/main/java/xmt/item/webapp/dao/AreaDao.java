package xmt.item.webapp.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import xmt.item.webapp.entity.AreaInfo;

@Mapper
public interface AreaDao {
    /**
     * 查询省
     * @return
     */
   List<AreaInfo>getProvinceList();

    /**
     * 查询城市
     * @return
     */
    List<AreaInfo>getCityList();

    /**
     * 查询区域
     * @return
     */
    List<AreaInfo>getAreaList();

    /**
     * 查询子区域
     * @param areaInfo
     * @return
     */
    List<AreaInfo>getSubDomain(AreaInfo areaInfo);

    /**
     * 查询同名字的id
     * @param name
     * @return
     */
    String getId(String name);

}
