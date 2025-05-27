package dev.batist.EventMark.core.usecase;

import dev.batist.EventMark.core.entities.Evento;
import dev.batist.EventMark.core.gateway.EventoGateway;

public class CriarEventoImpl implements CriarEventoCase{

    private final EventoGateway eventoGateway;

    public CriarEventoImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        return eventoGateway.criarEvento(evento);
    }
}
