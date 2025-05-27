package dev.batist.EventMark.infrastructure.config;

import dev.batist.EventMark.core.gateway.EventoGateway;
import dev.batist.EventMark.core.usecase.*;
import dev.batist.EventMark.infrastructure.Mapper.EventoEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfig {

    private final EventoEntityMapper mapper;

    public BeanConfig(EventoEntityMapper mapper) {
        this.mapper = mapper;
    }

    @Bean
    public CriarEventoCase criarEventoCase(EventoGateway eventoGateway){
        return new CriarEventoImpl(eventoGateway);
    }

    @Bean
    public BuscarEventoCase buscarEventoCase(EventoGateway eventoGateway){
        return new BuscarEventoCaseImpl(eventoGateway);
    }

    @Bean
    public BuscartIdentificadorUseCase buscartIdentificadorUseCase (EventoGateway eventoGateway){
        return new BuscartIdentificadorImpl(eventoGateway);
    }

    @Bean
    public DeletarEventoCase deletarEventoCase(EventoGateway eventoGateway){
        return new DeletarEventoImpl(eventoGateway);
    }

}
