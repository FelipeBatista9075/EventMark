package dev.batist.EventMark.infrastructure.repository;

import dev.batist.EventMark.core.entities.Evento;
import dev.batist.EventMark.infrastructure.persistence.EventosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRespositoy extends JpaRepository<EventosEntity, Long> {
    boolean existsByIdentificador(String identificador);
    Evento findByIdentificador(String identificador);
}
