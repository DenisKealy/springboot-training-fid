package com.neueda.payments.service;

import com.neueda.payments.exceptions.PaymentNotFoundException;
import com.neueda.payments.repositories.PaymentsRepository;
import com.neueda.payments.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ServiceTests {

    @Autowired
    PaymentsService paymentsService;

    @MockBean
    private PaymentsRepository paymentsRepository;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setup(){
        Mockito.when(paymentsRepository.findById(123L)).thenReturn(Optional.empty());
    }

    @Test
    public void testPaymentThrowsNotFound() {
        Assertions.assertThrows(PaymentNotFoundException.class, () -> {
           paymentsService.findById(123L);
        });
    }
}
