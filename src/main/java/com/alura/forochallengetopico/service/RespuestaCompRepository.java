package com.alura.forochallengetopico.service;

import com.alura.forochallengetopico.model.RespuestaComp;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface RespuestaCompRepository extends JpaRepository<RespuestaComp, Long> {
}
