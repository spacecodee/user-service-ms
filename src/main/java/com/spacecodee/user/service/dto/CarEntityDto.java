package com.spacecodee.user.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarEntityDto implements Serializable {
    private final String carModel;
    private final String carBrand;
    private final int carUserId;
}
