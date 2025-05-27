package dev.batist.EventMark.infrastructure.Mapper;

import dev.batist.EventMark.core.entities.Evento;
import dev.batist.EventMark.infrastructure.persistence.EventosEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoEntityMapper {

    public EventosEntity toEntity(Evento evento){
        return EventosEntity.builder()
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

    public Evento toDomain(EventosEntity entity){
        return new Evento(entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getInicio(),
                entity.getFim(),
                entity.getIdentificador(),
                entity.getOrganizador(),
                entity.getLocal(),
                entity.getCapacidade(),
                entity.getTipoEvento());
    }
}
