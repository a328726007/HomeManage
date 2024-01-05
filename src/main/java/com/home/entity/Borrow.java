package com.home.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Borrow {
    private int borrowId;
    private int deviceId;
    private String deviceName;
    private Date date;
    private int customerId;
    private String customerName;
}
