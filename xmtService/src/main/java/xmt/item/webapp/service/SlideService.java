package xmt.item.webapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xmt.item.util.AppResponse;
import xmt.item.webapp.dao.SlideDao;
import xmt.item.webapp.entity.SlideInfo;
import java.util.List;
import javax.annotation.Resource;

@Service
@Transactional
public class SlideService {
    @Resource
    private SlideDao slideDao;

    public AppResponse slideList(){
        List<SlideInfo> slideInfoList = slideDao.slideList();
        return AppResponse.success("slideshow",slideInfoList);
    }
}
