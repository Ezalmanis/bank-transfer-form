package com.erikszalmanis.hw.mapper;

import com.erikszalmanis.hw.domain.entities.PaymentOrderEntity;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.mapper.impl.SimplePaymentMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.erikszalmanis.hw.PaymentDomainTestUtil.getCorrectPaymentOrder;
import static com.erikszalmanis.hw.PaymentDomainTestUtil.getEntityCorrectPaymentOrder;

@SpringBootTest
public class PaymentOrderMapperTest {

    @Autowired
    SimplePaymentMapperImpl mapper;

    private static List<PaymentOrder> returnListOfPayments() {
        final List<PaymentOrder> paymentList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            paymentList.add(getCorrectPaymentOrder(i));
        }
        return paymentList;
    }

    private static List<PaymentOrderEntity> returnListOfEntities() {
        final List<PaymentOrderEntity> paymentEntityList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            paymentEntityList.add(getEntityCorrectPaymentOrder(i));
        }
        return paymentEntityList;
    }

    ///
    ///Auxiliary
    ///

    @Test
    public void dtoToEntityListMapsCorrectly() {
        final List<PaymentOrderEntity> expectedEntities = returnListOfEntities();
        expectedEntities.forEach(paymentEntity -> paymentEntity.setDocumentId(null));
        final List<PaymentOrder> paymentOrdersToMap = returnListOfPayments();
        final List<PaymentOrderEntity> actualEntities = new ArrayList<>();
        paymentOrdersToMap.forEach(paymentOrder -> actualEntities.add(mapper.paymentOrderToEntity(paymentOrder)));
        Assertions.assertEquals(expectedEntities, actualEntities);
    }

    @Test
    public void entityToDtoMapsCorrectly() {
        final List<PaymentOrder> expectedEntities = returnListOfPayments();
        final List<PaymentOrderEntity> paymentOrdersToMap = returnListOfEntities();
        final List<PaymentOrder> actualEntities = new ArrayList<>();
        paymentOrdersToMap.forEach(paymentOrder -> actualEntities.add(mapper.entityToPaymentOrder(paymentOrder)));
        //Todo, refactor to streams prolly wont have time lol, AND prolly would be overkill, prio - low
        Assertions.assertEquals(expectedEntities, actualEntities);
    }

}