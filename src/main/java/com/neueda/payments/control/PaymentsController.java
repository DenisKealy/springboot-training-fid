package com.neueda.payments.control;

import com.neueda.payments.exceptions.PaymentNotFoundException;
import com.neueda.payments.model.Payment;
import com.neueda.payments.service.PaymentsService;
import org.springframework.http.MediaType;
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

    @GetMapping("payment/{id}")
    public Payment getPaymentById(@PathVariable Long id) throws PaymentNotFoundException {
        return paymentsService.findById(id);
    }

    @PostMapping(value = "payment/", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentsService.save(payment);
    }

    @GetMapping(value = "payment/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Payment> getPaymentById(@RequestParam(required = false) String country,
                                        @RequestParam(required = false) String orderId) {
        if(orderId != null) {
            return paymentsService.getByOrderId(orderId);
        } else if (country != null) {
            return paymentsService.findByCountry(country);
        } else {
            return paymentsService.getAllPayments();
        }
    }
}
