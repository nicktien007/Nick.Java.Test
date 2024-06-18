package com.nick.javatest;

public class MockOtpServiceGreen implements IOtpService {

    @Override
    public OtpEntity sendOTP(String mobile) {
        OtpEntity otpEntity = new OtpEntity();
        otpEntity.setTxId("COTAG008");

        return otpEntity;
    }
}
