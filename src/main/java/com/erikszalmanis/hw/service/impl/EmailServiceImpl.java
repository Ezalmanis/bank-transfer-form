package com.erikszalmanis.hw.service.impl;

import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendEmailToClerk(final PaymentOrder paymentOrder) {
        //todo, stub, fill me out :)
    }
}
