package com.erikszalmanis.hw.repository;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.entities.PaymentOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentOrderEntity, Long> {

    List<PaymentOrderEntity> findAllByStatusNotNull();

    List<PaymentOrderEntity> findAllByStatus(PaymentStatus status);

    PaymentOrderEntity findByDocumentId(Long documentId);

//        List<Task> findAllByDeletedIsFalse();
//
//    List<Task> findAllByDeletedIsNotNull();
//
//    Optional<List<Task>> findAllByDeletedIsFalseAndCompletedIsTrue();
//
//    Optional<Task> findById(Long id);
    ///
    //
    //    List<PaymentOrderEntity> getAllPayments();
    //
    //    List<PaymentOrderEntity> getAllPendingPayments();
    //
    //    PaymentOrderEntity getPaymentOrderByDocumentId();
    //
    //    Long savePaymentOrder();
    //
    //    PaymentOrderEntity updatePaymentOrder();
    //
    //    PaymentStatus updatePaymentStatus();
    ///
    ///
    //
    //
    //
    ///
    //
    //
    //
    ///
    //
    //
//

}
