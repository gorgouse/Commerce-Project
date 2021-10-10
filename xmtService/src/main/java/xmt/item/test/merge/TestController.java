package xmt.item.test.merge;

import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/query")
public class TestController {

    private TestBiz testBiz;
    @RequestMapping("/stock/{goodsId}")
    public JsonObject getStock(JsonObject jsonObject){
        return testBiz.business(jsonObject);
    }
}
