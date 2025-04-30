package dev.batist.EventMark.core.usecase;

import dev.batist.EventMark.core.entities.Evento;

public interface AtualizarEvento {
    public Evento execute(Long id, Evento evento);
}
