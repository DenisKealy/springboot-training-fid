package com.neueda.payments.service;

import com.neueda.payments.exceptions.PaymentNotFoundException;
import com.neueda.payments.model.Payment;
import com.neueda.payments.repositories.PaymentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.LocalDate;
import java.util.*;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    private Logger logger = LoggerFactory.getLogger(PaymentsServiceImpl.class);
    private PaymentsRepository paymentsRepository;

    public PaymentsServiceImpl(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();
    }


    @Override
    public Payment findById(Long id) throws PaymentNotFoundException {
        Optional <Payment> payment =  paymentsRepository.findById(id);
        return payment.orElseThrow(() -> new PaymentNotFoundException("Payment not found"));
    }

    @Override
    public List<Payment> findByCountry(String country) {
        logger.info("Getting all payments for country: {}", country.toUpperCase());
        return paymentsRepository.findByCountry(country);
    }

    @Override
    public List<Payment> getByOrderId(String orderId) {
        return paymentsRepository.findAllByOrderId(orderId);
    }

    @Override
    public Payment save(Payment payment) {
        return paymentsRepository.save(payment);
    }

}
