package com.minchu.incampus.transportation.locationmanagement.model.dto;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class EmbeddableLocation implements Serializable {

    private String idgps;
    private long timestamp;
}
