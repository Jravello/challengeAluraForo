package com.alura.forochallengetopico.service;

import com.alura.forochallengetopico.model.TopicoComp;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
public interface TopicoCompRepository extends JpaRepository<TopicoComp, Long> {
}
