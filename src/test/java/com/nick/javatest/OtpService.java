package com.nick.javatest;

import java.util.Date;

public class OtpService  implements IOtpService{

    @Override
    public OtpEntity sendOTP(String mobile){
        //模擬調用電文...

//        Notification client = Notification.getInstance();
//        SMSNotify sms = new SMSNotify();
//        sms.setTxID("COTAG010"); // 交易key(Optional)
//        sms.setPhoneNumber(mobile);
//        sms.setMessage(smsMsg);
//        client.send(sms);

        return new OtpEntity();
    }
}
