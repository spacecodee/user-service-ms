package com.spacecodee.user.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarEntityDto implements Serializable {
    private String carModel;
    private String carBrand;
    private int carUserId;
}
