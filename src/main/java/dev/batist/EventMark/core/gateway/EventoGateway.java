package dev.batist.EventMark.core.gateway;

import dev.batist.EventMark.core.entities.Evento;

import java.util.List;

public interface EventoGateway {

    Evento criarEvento (Evento evento);

    List<Evento> listarEventos();

    Evento findIndentificador(String identificador);

    void deletar(Long id);
}
