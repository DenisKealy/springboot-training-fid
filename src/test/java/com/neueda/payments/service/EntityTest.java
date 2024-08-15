package com.neueda.payments.service;

import com.neueda.payments.model.Payment;
import com.neueda.payments.repositories.PaymentsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityTest {

    private PaymentsRepository paymentsRepository;

    @Test
    public void testEqualityOfPaymentsUsingIdOnly() {
        Payment p1 = new Payment();
        p1.setId(17L);
        Payment p2 = new Payment();
        p2.setId(17L);
        Assertions.assertEquals(p1, p2);

    }
}
