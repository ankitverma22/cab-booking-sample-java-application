package com.test.cabBooking.model.response;

import java.math.BigDecimal;
import java.util.Map;

public class TotalEarningResponse {
    private Map<String, BigDecimal> driverVsEarning;

    public Map<String, BigDecimal> getDriverVsEarning() {
        return driverVsEarning;
    }

    public void setDriverVsEarning(Map<String, BigDecimal> driverVsEarning) {
        this.driverVsEarning = driverVsEarning;
    }

    @Override
    public String toString() {
        return "TotalEarningResponse{" +
                "driverVsEarning=" + driverVsEarning +
                '}';
    }
}
