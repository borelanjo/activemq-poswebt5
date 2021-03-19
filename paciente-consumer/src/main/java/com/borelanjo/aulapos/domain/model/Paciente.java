package com.borelanjo.aulapos.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@ToString(includeFieldNames = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_paciente", schema = "paciente")
public class Paciente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private UUID code;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private String status;

    @Column
    private String descricao;

    @Column
    @NotNull
    private LocalDateTime dataInternacao;

    @Column
    private LocalDateTime dataLiberacao;

    @Column(name="unidade_code")
    @NotNull
    private UUID codigoUnidade;
}
