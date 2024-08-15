package com.neueda.payments.control;

import com.neueda.payments.model.Payment;
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

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class CountryControllerTest {

    @Autowired
    private CountryController countryController;

    @MockBean
    PaymentsRepository paymentsRepository;

    @MockBean
    UserRepository userRepository;


    @BeforeEach
    public void setUp() {
        Payment p1 = new Payment();
        p1.setCountry("irl");

        Payment p2 = new Payment();
        p2.setCountry("can");

        Payment p3 = new Payment();
        p3.setCountry("fra");

        Payment p4 = new Payment();
        p4.setCountry("irl");

        Payment p5 = new Payment();
        p5.setCountry("can");

        Mockito.when(paymentsRepository.findAll()).thenReturn(List.of(p1, p2, p3, p4, p5));
    }
    @Test
    public void testGetAllUniqueCountriesSorted() {
        Assertions.assertEquals(countryController.getAllUniqueCountries(), List.of("can", "fra", "irl"));
    }
}
