package com.erikszalmanis.hw.controller;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.objects.ExchangeRate;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.exceptions.NoDefaultExchangeRateException;
import com.erikszalmanis.hw.exceptions.OutdatedRatesException;
import com.erikszalmanis.hw.exceptions.TransferAmountDiscrepancyException;
import com.erikszalmanis.hw.service.PaymentOrderService;
import com.erikszalmanis.hw.validator.ValueOfEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.List;

//TODO, make restControllerAdvice
//TODO, make devmode setting for cors

@RestController
public class SimplePaymentFormRestController {

    private final Logger logger = LoggerFactory.getLogger(SimplePaymentFormRestController.class);
    private final PaymentOrderService paymentService;

    @Autowired
    public SimplePaymentFormRestController(final PaymentOrderService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/payment", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public Long createNewPaymentRequest(@Validated @RequestBody final PaymentOrder paymentOrder) throws OutdatedRatesException, TransferAmountDiscrepancyException, NoDefaultExchangeRateException {
        final PaymentOrder savedOrder = paymentService.savePaymentOrder(paymentOrder);
        logger.info(("PaymentOrder created successfully: {}"), savedOrder);
        return savedOrder.getDocumentId();
    }

    //TODO, encrypt ids
    @PostMapping(value = "/payment/{id}/{status}")
    @CrossOrigin
    public void processPayment(@NotNull @PathVariable final Long id, @ValueOfEnum(enumClass = PaymentStatus.class) @PathVariable final PaymentStatus status) throws EntityNotFoundException {
        paymentService.updatePaymentStatus(id, status);
        logger.info(("PaymentOrder status updated successfully: {}"), status);
    }

    @GetMapping(value = "/payment/rates")
    @CrossOrigin
    public ExchangeRate getExchangeRate() throws NoDefaultExchangeRateException {
        return paymentService.getExchangeRate();
    }

    @GetMapping(value = "/payments")
    @CrossOrigin
    public List<PaymentOrder> getPaymentOrders() {
        final List<PaymentOrder> paymentOrders = paymentService.getPaymentOrders();
        logger.info(("Payment orders retrieved successfully: {}"), paymentOrders);
        return paymentOrders;
    }

    @PostMapping(value = "/payment/{id}", consumes = "application/json")
    @CrossOrigin
    public void updatePayment(@NotNull @PathVariable final Long id, @Validated @RequestBody final PaymentOrder paymentOrder) throws OutdatedRatesException, TransferAmountDiscrepancyException, NoDefaultExchangeRateException, EntityNotFoundException {
        final PaymentOrder updatedOrder = paymentService.updatePaymentOrder(id, paymentOrder);
        logger.info(("PaymentOrder updated successfully: {}"), updatedOrder);
    }

}
