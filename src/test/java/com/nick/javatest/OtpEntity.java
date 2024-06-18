package com.nick.javatest;

import lombok.Data;

@Data
public class OtpEntity {
    private String txCode;

    /**
     * 交易資料
     */
    private String txData;

    /**
     * 程式代號
     */

    private String txId;
}
