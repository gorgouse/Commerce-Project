package xmt.item.webapp.service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmt.item.config.alipay.AlipayConfig;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.Alipayinfo;

import java.io.IOException;

@Service
public class PaymentService {

    public String toAliPay(Alipayinfo alipayinfo) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.gatewayUrl,
                AlipayConfig.app_id,
                AlipayConfig.merchant_private_key,
                "json",
                AlipayConfig.charset,
                AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type
        );
        AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayTradePagePayRequest.setNotifyUrl(AlipayConfig.notify_url);
        alipayTradePagePayRequest.setBizContent(JSON.toJSONString(alipayinfo));
        String result = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
        System.out.println(result);
        return result;
    }
}
