package xmt.item.webapp.entity;
import java.util.List;
import java.util.Map;

public class AreaList {
    private Map<String,Object> province_list;

    private Map<String,Object> city_list;

    private Map<String,Object> county_list;

    public Map<String, Object> getProvince_list() {
        return province_list;
    }

    public void setProvince_list(Map<String, Object> province_list) {
        this.province_list = province_list;
    }

    public Map<String, Object> getCity_list() {
        return city_list;
    }

    public void setCity_list(Map<String, Object> city_list) {
        this.city_list = city_list;
    }

    public Map<String, Object> getCounty_list() {
        return county_list;
    }

    public void setCounty_list(Map<String, Object> county_list) {
        this.county_list = county_list;
    }
}
