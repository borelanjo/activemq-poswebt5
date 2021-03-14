package com.borelanjo.aulapos.presentation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString(includeFieldNames = true)
public class PacienteTo {
    private UUID code;
    private String nome;
}
