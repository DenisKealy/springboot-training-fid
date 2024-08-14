package com.neueda.payments.service;

import com.neueda.payments.model.Payment;
import com.neueda.payments.repositories.PaymentsRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    private PaymentsRepository paymentsRepository;

    public PaymentsServiceImpl(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();
    }


    @Override
    public Payment findById(Long id) {
        Optional <Payment> payment =  paymentsRepository.findById(id);
        return payment.orElse(null);
    }

    @Override
    public Payment save(Payment payment) {
        return paymentsRepository.save(payment);
    }

}
