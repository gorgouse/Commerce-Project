package xmt.item.upload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xmt.item.upload.service.CosService;
import xmt.item.util.AppResponse;

import javax.annotation.Resource;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/upload")
public class CosController {
    private static final Logger logger = LoggerFactory.getLogger(CosController.class);

    @Resource
    private CosService cosService;

    /**
     * 图片上传
     * @param imageFile
     * @return
     * @time 2020-4-13
     */
    @PostMapping("/image")
    public AppResponse uploadImage(List<MultipartFile> imageFile) {
        try{
            return cosService.uploadImage(imageFile);
        }catch (Exception e){
            logger.error("图片上传失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
