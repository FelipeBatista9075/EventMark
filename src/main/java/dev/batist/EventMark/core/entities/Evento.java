package dev.batist.EventMark.core.entities;

import dev.batist.EventMark.core.entities.enums.Tipo;

import java.time.LocalDateTime;
import java.util.UUID;

public record Evento(Long id,
                     String nome,
                     String descricao,
                     LocalDateTime inicio,
                     LocalDateTime fim,
                     String identificador,
                     String organizador,
                     String local,
                     Integer capacidade,
                     Tipo tipoEvento) {
}
