package dev.batist.EventMark.core.usecase;

import dev.batist.EventMark.core.gateway.EventoGateway;

public class DeletarEventoImpl implements DeletarEventoCase {

    private final EventoGateway eventoGateway;

    public DeletarEventoImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public void execute(Long id) {
        eventoGateway.deletar(id);
    }
}
