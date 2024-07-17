package com.alura.forochallengetopico.model;

import lombok.Data;

import java.util.Date;

@Data
public class NewTopico {
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    private Boolean status;
    private Long idPerfil;
    private Long idCurso;
}
