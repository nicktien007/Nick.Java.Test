package com.nick.javatest.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class CafeInfo {

    private String id;
    private String name;
    private String city;
    private Integer wifi;
    private Integer seat;
    private BigDecimal quiet;
    private BigDecimal tasty;
    private Integer cheap;
    private Integer music;
    private String url;
    private String address;
    private String latitude;
    private String longitude;
    private String limited_time;
    private String socket;
    private String standing_desk;
    private String mrt;
    private String open_time;

    public String getLocation() {
        return this.latitude + "," + this.longitude;
    }

    private String location;
}