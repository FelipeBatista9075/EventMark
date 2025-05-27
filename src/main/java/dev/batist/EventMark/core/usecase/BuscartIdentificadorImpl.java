package dev.batist.EventMark.core.usecase;

import dev.batist.EventMark.core.entities.Evento;
import dev.batist.EventMark.core.gateway.EventoGateway;

import java.util.List;

public class BuscartIdentificadorImpl implements BuscartIdentificadorUseCase{

    private final EventoGateway eventoGateway;

    public BuscartIdentificadorImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.findIndentificador(identificador);
    }
}
