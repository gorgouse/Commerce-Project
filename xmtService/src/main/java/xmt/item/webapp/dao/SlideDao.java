package xmt.item.webapp.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import xmt.item.webapp.entity.SlideInfo;

@Mapper
public interface SlideDao {
    List<SlideInfo> slideList();
}
