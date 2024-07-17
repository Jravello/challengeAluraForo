package com.alura.forochallengetopico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Entity
@Data
public class TopicoComp {
    @Id
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    private Boolean status;

    // Perfil
    private Long idPerfil;
    private String perfilNombre;

    // Curso
    private Long idCurso;
    private String cursoNombre;
    private String cursoCategoria;

    // Respuestas
    @Transient
    private List<RespuestaComp> respuestas;
}
