package com.alura.forochallengetopico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class RespuestaComp {
    @Id
    private Long id;
    private String mensaje;
    private Date fechaCreacion;
    private Long idTopico;
    private Long idPerfil;
    private String perfilNombre;
    private Number solucion;
}
