package com.erikszalmanis.hw.service;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.exceptions.OutdatedRatesException;
import com.erikszalmanis.hw.domain.exceptions.TransferAmountDiscrepancyException;
import com.erikszalmanis.hw.domain.objects.ExchangeRate;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;

import java.util.List;


public interface PaymentOrderService {

    void saveAndSubmitOrderToClerk(final PaymentOrder paymentOrder) throws OutdatedRatesException, TransferAmountDiscrepancyException;

    PaymentOrder savePaymentOrder(final PaymentOrder paymentOrder) throws OutdatedRatesException, TransferAmountDiscrepancyException;

    void updatePaymentOrder(final PaymentOrder paymentOrder);

    void updatePaymentStatus(final Long id, final PaymentStatus status);

    ExchangeRate getExchangeRate();

    List<PaymentOrder> getPaymentOrders();

}
