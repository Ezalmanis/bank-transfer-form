package com.erikszalmanis.hw.domain.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;
import java.util.HashMap;

public class ExchangeRate {

    private String base;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;
    private HashMap<String, Double> rates;

    public ExchangeRate(final String base, final LocalDate date, final HashMap<String, Double> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public ExchangeRate() {
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(final String base) {
        this.base = base;
    }

    @JsonProperty("date")
    public LocalDate getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(final LocalDate date) {
        this.date = date;
    }

    @JsonProperty("rates")
    public HashMap<String, Double> getRates() {
        return rates;
    }

    @JsonProperty("rates")
    public void setRates(final HashMap<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final ExchangeRate that = (ExchangeRate) o;

        return new EqualsBuilder()
                .append(getBase(), that.getBase())
                .append(getDate(), that.getDate())
                .append(getRates(), that.getRates())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getBase())
                .append(getDate())
                .append(getRates())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("base", base)
                .append("date", date)
                .append("rates", rates)
                .toString();
    }
}
