package xmt.item.test.merge;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class TestBiz {

    public JsonObject business(JsonObject jsonObject){
        List<Stock> stockList = new ArrayList<>();
        for(Stock stock :jsonObject.stock){
            Stock stock1 = new Stock();
            stock1.setGoodsId(stock.getGoodsId());
            stock1.setName(stock.getName());
            BigDecimal storage = new BigDecimal("0");
            //遍历计订单中的数量
            for(Order order:jsonObject.order){
                if(stock.goodsId.equals(order.goodsId)){
                    storage.add(new BigDecimal(order.getNumber()));
                }
            }
            //减去库存
            stock.setNumber(new BigDecimal(stock.getNumber()).subtract(storage).toString());
            stockList.add(stock);
        }


    }
}
