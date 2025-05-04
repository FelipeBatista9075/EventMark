package dev.batist.EventMark.infrastructure.persistence;

import dev.batist.EventMark.core.entities.enums.Tipo;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Eventos")
public record EventosEntity(
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                            Long id,
                            String nome,
                            String descricao,
                            LocalDateTime inicio,
                            LocalDateTime fim,
                            UUID identificador,
                            String organizador,
                            String local,
                            Integer capacidade,
                            @Enumerated(EnumType.STRING)
                            Tipo tipoEvento) {
}
