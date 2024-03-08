package chiragtailor.tech.paymentservice.controllers;

import chiragtailor.tech.paymentservice.dtos.CreatePaymentLinkRequestDto;
import chiragtailor.tech.paymentservice.services.PaymentService;
import com.razorpay.RazorpayException;
import com.razorpay.Webhook;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/order")
    public String createPaymentLink(@RequestBody CreatePaymentLinkRequestDto request) throws RazorpayException {

        String link = paymentService.createPaymentLink(request.getOrderId());

        return link;

    }

    @PostMapping("/webhook")
    public void createWebhookEvent(@RequestBody JSONObject webhook){
        System.out.println(webhook);
    }
}
