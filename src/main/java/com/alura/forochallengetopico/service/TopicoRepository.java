package com.alura.forochallengetopico.service;

import com.alura.forochallengetopico.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
