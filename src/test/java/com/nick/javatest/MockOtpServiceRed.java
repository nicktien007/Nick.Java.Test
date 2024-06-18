package com.nick.javatest;

public class MockOtpServiceRed implements IOtpService {

    @Override
    public OtpEntity sendOTP(String mobile) {
        OtpEntity otpEntity = new OtpEntity();
        otpEntity.setTxId("COTAG010");

        return otpEntity;
    }
}
