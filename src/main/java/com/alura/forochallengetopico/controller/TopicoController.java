package com.alura.forochallengetopico.controller;

import com.alura.forochallengetopico.exception.ErrorException;
import com.alura.forochallengetopico.model.NewTopico;
import com.alura.forochallengetopico.model.Topico;
import com.alura.forochallengetopico.model.TopicoComp;
import com.alura.forochallengetopico.model.Usuario;
import com.alura.forochallengetopico.service.TopicoCompRepository;
import com.alura.forochallengetopico.service.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    private final TopicoCompRepository topicoCompRepository;
    private final TopicoRepository topicoRepository;

    TopicoController(TopicoCompRepository topicoCompRepository, TopicoRepository topicoRepository) {
        this.topicoCompRepository = topicoCompRepository;
        this.topicoRepository = topicoRepository;
    }

    @GetMapping
    ResponseEntity<List<TopicoComp>> all() {
        var topicos = topicoCompRepository.findAll();
        if (topicos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(topicos);
    }

    @PostMapping
    ResponseEntity<String> createTopico(@RequestBody  NewTopico bodyTopico) {

        if (bodyTopico.getId() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id no puede ser ingresado");
        }

        if (bodyTopico.getTitulo() == null || bodyTopico.getMensaje() == null || bodyTopico.getFechaCreacion() == null || bodyTopico.getStatus() == null || bodyTopico.getIdPerfil() == null || bodyTopico.getIdCurso() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Todos los campos son obligatorios");
        }

        Topico newTopico = new Topico();
        newTopico.setTitulo(bodyTopico.getTitulo());
        newTopico.setMensaje(bodyTopico.getMensaje());
        newTopico.setFechaCreacion(bodyTopico.getFechaCreacion());
        newTopico.setStatus(bodyTopico.getStatus());
        newTopico.setIdPerfil(bodyTopico.getIdPerfil());
        newTopico.setIdCurso(bodyTopico.getIdCurso());
        Topico createdTopico = topicoRepository.save(newTopico);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTopico.toString());
    }

    @PutMapping
    ResponseEntity<String> updateTopico(@RequestBody NewTopico bodyTopico) {

        if (!topicoRepository.existsById(bodyTopico.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Topico no encontrado");
        }

        Topico newTopico = new Topico();
        newTopico.setId(bodyTopico.getId());
        newTopico.setTitulo(bodyTopico.getTitulo());
        newTopico.setMensaje(bodyTopico.getMensaje());
        newTopico.setFechaCreacion(bodyTopico.getFechaCreacion());
        newTopico.setStatus(bodyTopico.getStatus());
        newTopico.setIdPerfil(bodyTopico.getIdPerfil());
        newTopico.setIdCurso(bodyTopico.getIdCurso());
        Topico updatedTopico = topicoRepository.save(newTopico);
        return ResponseEntity.status(HttpStatus.OK).body("Topico actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteTopico(@PathVariable Long id) {

        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id no puede ser nulo");
        }

        if (!topicoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Topico no encontrado");
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Topico eliminado correctamente");
    }


}
