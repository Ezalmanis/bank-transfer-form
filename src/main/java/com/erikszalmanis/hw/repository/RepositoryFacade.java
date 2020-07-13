package com.erikszalmanis.hw.repository;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.entities.PaymentOrderEntity;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public interface RepositoryFacade {

    //TODO, make into optionals
    List<PaymentOrder> getAllPayments();

    List<PaymentOrder> getAllPaymentsByStatus(PaymentStatus status);

    PaymentOrderEntity getPaymentOrderByDocumentId(Long documentId);

    PaymentOrder savePaymentOrder(PaymentOrder order) throws EntityNotFoundException;

    PaymentOrder updatePaymentOrder(PaymentOrder order, Long documentId);

    PaymentStatus updatePaymentStatus(Long documentId, PaymentStatus status);
}
