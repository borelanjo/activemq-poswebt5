package com.borelanjo.aulapos.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString(includeFieldNames = true)
public class Paciente implements Serializable {

    private UUID code;
    private String nome;
}
