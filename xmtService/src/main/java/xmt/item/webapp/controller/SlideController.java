package xmt.item.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;
import xmt.item.webapp.service.SlideService;

import javax.annotation.Resource;
@CrossOrigin
@RestController
@RequestMapping("/appslide")
public class SlideController {

    @Resource
    private SlideService slideService;

    /**
     * 首页轮播图列表
     * @return
     */
    @GetMapping("/list")
    public AppResponse slideList(){
        return slideService.slideList();
    }
}
