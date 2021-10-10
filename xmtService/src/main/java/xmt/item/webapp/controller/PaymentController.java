package xmt.item.webapp.controller;

import com.alipay.api.AlipayApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;
import xmt.item.webapp.entity.Alipayinfo;
import xmt.item.webapp.service.PaymentService;

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/pay")
    String toAliPay(Alipayinfo alipayinfo) throws AlipayApiException {
        return paymentService.toAliPay(alipayinfo);
    }
}
