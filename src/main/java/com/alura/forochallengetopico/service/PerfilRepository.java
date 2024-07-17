package com.alura.forochallengetopico.service;

import com.alura.forochallengetopico.model.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}