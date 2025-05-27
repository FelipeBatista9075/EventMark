package dev.batist.EventMark.core.usecase;

import dev.batist.EventMark.core.entities.Evento;
import dev.batist.EventMark.core.gateway.EventoGateway;

import java.util.List;

public class BuscarEventoCaseImpl implements BuscarEventoCase{

    private final EventoGateway eventoGateway;

    public BuscarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute() {
        return eventoGateway.listarEventos();
    }
}
