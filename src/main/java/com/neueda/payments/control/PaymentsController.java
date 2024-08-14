package com.neueda.payments.control;

import com.neueda.payments.model.Payment;
import com.neueda.payments.service.PaymentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin
@RestController
public class PaymentsController {

    private final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @GetMapping(path = "/payment")
    public List<Payment> getPayments() {
        return paymentsService.getAllPayments();
    }

    @GetMapping("payment/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentsService.findById(id);
    }
}
