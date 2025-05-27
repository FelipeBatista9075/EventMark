package dev.batist.EventMark.infrastructure.dtos;

import dev.batist.EventMark.core.entities.enums.Tipo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record EventoDto(Long id,
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
