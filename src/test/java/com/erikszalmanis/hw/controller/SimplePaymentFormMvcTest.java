package com.erikszalmanis.hw.controller;

import com.erikszalmanis.hw.domain.enums.PaymentStatus;
import com.erikszalmanis.hw.domain.objects.PaymentOrder;
import com.erikszalmanis.hw.service.PaymentOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static com.erikszalmanis.hw.PaymentDomainTestUtil.getCorrectPaymentOrder;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(SpringExtension.class)
public class SimplePaymentFormMvcTest {

    private final String URL_TEMPLATE = "/payment";
    private final ObjectMapper mapper = new ObjectMapper();

    private MockMvc mockMvc;
    @Mock
    private PaymentOrderService service;


    @BeforeEach
    public void init() {
        initMocks(this);
        mapper.registerModule(new JavaTimeModule());
        final SimplePaymentFormRestController controller = new SimplePaymentFormRestController(service);
        mockMvc = standaloneSetup(controller).build();

    }


    @Test
    public void shouldSaveTask() throws Exception {
        final PaymentOrder expectedEntity = getCorrectPaymentOrder(1);
        final Long expectedDocumentId = expectedEntity.getDocumentId();
        Mockito.when(service.savePaymentOrder(any(PaymentOrder.class))).thenReturn(expectedEntity);
        final PaymentOrder order = getCorrectPaymentOrder(1);
        final String paymentJson = mapper.writeValueAsString(order);

        final String result = mockMvc.perform(post(URL_TEMPLATE)
                .content(paymentJson).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();

        Assertions.assertEquals(expectedDocumentId, Long.valueOf(result));

    }

    @Test
    public void validationShouldFail() throws Exception {

        final PaymentOrder order = getCorrectPaymentOrder(1);
        order.setClientId(null);
        final String paymentJson = mapper.writeValueAsString(order);

        final Exception result = mockMvc.perform(post(URL_TEMPLATE)
                .content(paymentJson).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn().getResolvedException();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(MethodArgumentNotValidException.class, result.getClass());

    }


    @Test
    public void shouldSetStatus() throws Exception {
        Mockito.doNothing().when(service).updatePaymentStatus(isA(Long.class), isA(PaymentStatus.class));

        mockMvc.perform(post(URL_TEMPLATE + "/1/PENDING").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void shouldNotValidateOnSetStatus() throws Exception {

        mockMvc.perform(post(URL_TEMPLATE + "/1/XAXA").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());


    }
}
