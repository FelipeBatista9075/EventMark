package dev.batist.EventMark.core.entities;

import dev.batist.EventMark.core.entities.enums.Tipo;

import java.time.LocalDateTime;
import java.util.UUID;

public record Evento(Long id, String nome, String desccricao, LocalDateTime inicio, LocalDateTime fim, UUID identificador, String local, int capacidade, Tipo tipoEvento) {
}
