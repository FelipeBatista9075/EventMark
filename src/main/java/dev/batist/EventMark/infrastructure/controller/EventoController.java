package dev.batist.EventMark.infrastructure.controller;

import dev.batist.EventMark.core.entities.Evento;
import dev.batist.EventMark.core.usecase.BuscarEventoCase;
import dev.batist.EventMark.core.usecase.BuscartIdentificadorUseCase;
import dev.batist.EventMark.core.usecase.CriarEventoCase;
import dev.batist.EventMark.core.usecase.DeletarEventoCase;
import dev.batist.EventMark.infrastructure.Mapper.EventoMapper;
import dev.batist.EventMark.infrastructure.dtos.EventoDto;
import dev.batist.EventMark.infrastructure.gateway.EventoRepositoryGateway;
import dev.batist.EventMark.infrastructure.persistence.EventosEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/")
public class EventoController {

    private final CriarEventoCase criarEventoCase;
    private final BuscarEventoCase buscarEventoCase;
    private final BuscartIdentificadorUseCase buscartIdentificadorUseCase;
    private final DeletarEventoCase deletarEventoCase;
    private final EventoMapper eventoMapper;


    public EventoController(CriarEventoCase criarEventoCase, BuscarEventoCase buscarEventoCase, BuscartIdentificadorUseCase buscartIdentificadorUseCase, DeletarEventoCase deletarEventoCase, EventoMapper eventoMapper) {
        this.criarEventoCase = criarEventoCase;
        this.buscarEventoCase = buscarEventoCase;
        this.buscartIdentificadorUseCase = buscartIdentificadorUseCase;
        this.deletarEventoCase = deletarEventoCase;
        this.eventoMapper = eventoMapper;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto dto) {
        Evento novoEvento = criarEventoCase.execute(eventoMapper.toDomain(dto));
        Map<String, Object> msg = new HashMap<>();
        msg.put("message: ", "event data has been saved");
        msg.put("Data: " , EventoMapper.toDto(novoEvento));
        return ResponseEntity.status(HttpStatus.CREATED).body(msg);
    }

    @GetMapping("listar")
    public ResponseEntity<List<EventoDto>> listar(){
        List<Evento> lista = buscarEventoCase.execute();
        List<EventoDto> dtos = lista.stream().map(EventoMapper::toDto).toList();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<EventoDto> buscarPorIdentificador(@PathVariable String id){
        Evento find = buscartIdentificadorUseCase.execute(id);
        EventoDto dto = EventoMapper.toDto(find);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        deletarEventoCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
