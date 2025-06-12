package dev.batist.EventMark.infrastructure.gateway;

import dev.batist.EventMark.core.entities.Evento;
import dev.batist.EventMark.core.gateway.EventoGateway;
import dev.batist.EventMark.infrastructure.Mapper.EventoEntityMapper;
import dev.batist.EventMark.infrastructure.exceptions.EventoDuplicadoException;
import dev.batist.EventMark.infrastructure.exceptions.EventoNaoEncontrado;
import dev.batist.EventMark.infrastructure.persistence.EventosEntity;
import dev.batist.EventMark.infrastructure.repository.EventoRespositoy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRespositoy eventoRespositoy;
    private final EventoEntityMapper mapper;

    private boolean eventoDuplicado(Evento evento){
        return eventoRespositoy.existsByIdentificador(evento.identificador());
    }

    public EventoRepositoryGateway(EventoRespositoy eventoRespositoy, EventoEntityMapper mapper) {
        this.eventoRespositoy = eventoRespositoy;
        this.mapper = mapper;
    }

    @Override
    public Evento criarEvento(Evento evento) {
        EventosEntity entity = mapper.toEntity(evento);
        if (eventoDuplicado(evento)){
            throw new EventoDuplicadoException();
        }
        EventosEntity novoEvento = eventoRespositoy.save(entity);
        return mapper.toDomain(novoEvento);
    }

    @Override
    public List<Evento> listarEventos() {
        List<EventosEntity> listar = eventoRespositoy.findAll();
        return listar.stream().map(mapper::toDomain).toList();
    }

    @Override
    public Evento findIndentificador(String identificador) {
        if (!eventoRespositoy.existsByIdentificador(identificador)){
            throw new EventoNaoEncontrado("Event for identificator: " + identificador + " not found");
        }
        return eventoRespositoy.findByIdentificador(identificador);
    }

    @Override
    public void deletar(Long id) {
        eventoRespositoy.deleteById(id);
    }


}
