package com.test.cabBooking.model.response;

import com.test.cabBooking.entity.CabBookingDetails;

import java.math.BigDecimal;

public class CalculateBillResponse {
    private CabBookingDetails cabBookingDetails;
    private BigDecimal billAmount;

    public CabBookingDetails getCabBookingDetails() {
        return cabBookingDetails;
    }

    public void setCabBookingDetails(CabBookingDetails cabBookingDetails) {
        this.cabBookingDetails = cabBookingDetails;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        return "CalculateBillResponse{" +
                "cabBookingDetails=" + cabBookingDetails +
                ", billAmount=" + billAmount +
                '}';
    }
}
