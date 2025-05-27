package dev.batist.EventMark.core.usecase;

import dev.batist.EventMark.core.entities.Evento;

import java.util.List;

public interface BuscartIdentificadorUseCase {

    public Evento execute(String identificador);
}
