package dev.batist.EventMark.infrastructure.Mapper;

import dev.batist.EventMark.core.entities.Evento;
import dev.batist.EventMark.infrastructure.dtos.EventoDto;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    public static Evento toDomain(EventoDto dto){
        return new Evento(dto.id(),
                dto.nome(),
                dto.descricao(),
                dto.inicio(),
                dto.fim(),
                dto.identificador(),
                dto.organizador(),
                dto.local(),
                dto.capacidade(),
                dto.tipoEvento());
    }

        public static EventoDto toDto(Evento evento){
        return EventoDto.builder()
                .id(evento.id())
                .nome(evento.nome())
                .descricao(evento.descricao())
                .inicio(evento.inicio())
                .fim(evento.fim())
                .identificador(evento.identificador())
                .organizador(evento.organizador())
                .local(evento.local())
                .capacidade(evento.capacidade())
                .tipoEvento(evento.tipoEvento())
                .build();
        }
}
