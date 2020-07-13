package com.erikszalmanis.hw.service;

import com.erikszalmanis.hw.domain.objects.PaymentOrder;

public interface EmailService {

    void sendEmailToClerk(PaymentOrder order);
}
