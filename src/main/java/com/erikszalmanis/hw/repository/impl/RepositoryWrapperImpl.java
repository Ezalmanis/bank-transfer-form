package com.erikszalmanis.hw.repository.impl;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.entities.PaymentOrderEntity;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.mapper.SimplePaymentMapper;
import com.erikszalmanis.hw.repository.PaymentRepository;
import com.erikszalmanis.hw.repository.RepositoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class RepositoryWrapperImpl implements RepositoryFacade {

    private final PaymentRepository repository;
    private final SimplePaymentMapper paymentMapper;


    @Autowired
    public RepositoryWrapperImpl(final PaymentRepository repository, final SimplePaymentMapper paymentMapper) {
        this.repository = repository;
        this.paymentMapper = paymentMapper;
    }


    @Override
    public List<PaymentOrder> getAllPayments() {
        final List<PaymentOrderEntity> entities = repository.findAllByStatusNotNull();
        final List<PaymentOrder> paymentOrders = new ArrayList<>();
        entities.forEach(entity -> paymentOrders.add(paymentMapper.entityToPaymentOrder(entity)));
        return paymentOrders;

    }

    public List<PaymentOrder> getAllPaymentsByStatus(final PaymentStatus status) {
        final List<PaymentOrderEntity> entities = repository.findAllByStatus(status);
        final List<PaymentOrder> paymentOrders = new ArrayList<>();
        entities.forEach(entity -> paymentOrders.add(paymentMapper.entityToPaymentOrder(entity)));
        return paymentOrders;
    }

    @Override
    public PaymentOrderEntity getPaymentOrderByDocumentId(final Long documentId) {
        return repository.findByDocumentId(documentId);
    }

    @Override
    public PaymentOrder savePaymentOrder(final PaymentOrder order) throws EntityNotFoundException {
        final PaymentOrderEntity entity = repository.save(paymentMapper.paymentOrderToEntity(order));
        if (entity.getDocumentId() == null) {
            throw new EntityNotFoundException();
        }
        return paymentMapper.entityToPaymentOrder(entity);
    }

    @Override
    public PaymentOrder updatePaymentOrder(final PaymentOrder order, final Long documentId) {
        final PaymentOrderEntity entityToUpdate = repository.findByDocumentId(documentId);
        entityToUpdate.updatePaymentOrder(order);
        return paymentMapper.entityToPaymentOrder(repository.save(entityToUpdate));
    }

    @Override
    public PaymentStatus updatePaymentStatus(final Long documentId, final PaymentStatus status) {
        final PaymentOrderEntity entityToUpdate = repository.findByDocumentId(documentId);
        entityToUpdate.setStatus(status);
        repository.save(entityToUpdate);
        return entityToUpdate.getStatus();
    }
}
