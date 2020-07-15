package com.erikszalmanis.hw.repository;

import com.erikszalmanis.hw.domain.entities.PaymentOrderEntity;
import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentOrderEntity, Long> {

    List<PaymentOrderEntity> findAllByStatusNotNull();

    List<PaymentOrderEntity> findAllByStatus(PaymentStatus status);

    Optional<PaymentOrderEntity> findByDocumentId(Long documentId);

}
