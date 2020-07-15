package com.erikszalmanis.hw.repository;

import com.erikszalmanis.hw.domain.entities.PaymentOrderEntity;
import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public interface RepositoryFacade {

    List<PaymentOrder> getAllPayments();

    List<PaymentOrder> getAllPaymentsByStatus(PaymentStatus status);

    PaymentOrderEntity getPaymentOrderByDocumentId(Long documentId) throws EntityNotFoundException;

    PaymentOrder savePaymentOrder(PaymentOrder order);

    PaymentOrder updatePaymentOrder(PaymentOrder order, Long documentId) throws EntityNotFoundException;

    PaymentStatus updatePaymentStatus(Long documentId, PaymentStatus status) throws EntityNotFoundException;
}
