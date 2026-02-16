package com.sayel.bookmyshow_backend.controller;

import com.sayel.bookmyshow_backend.entity.Payment;
import com.sayel.bookmyshow_backend.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/{bookingId}")
    public Payment makePayment(@PathVariable Long bookingId,
                               @RequestParam boolean success){
        return paymentService.processPayment(bookingId,success);
    }
}
