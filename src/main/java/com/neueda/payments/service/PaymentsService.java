package com.neueda.payments.service;

import com.neueda.payments.exceptions.PaymentNotFoundException;
import com.neueda.payments.model.Payment;

import java.util.*;

public interface PaymentsService {

    List<Payment> getAllPayments();

    Payment save(Payment payment);

    Payment findById(Long id) throws PaymentNotFoundException;

    List<Payment> findByCountry(String country);

    List<Payment> getByOrderId(String orderId);
}
