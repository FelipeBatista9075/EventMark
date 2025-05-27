package dev.batist.EventMark.infrastructure.persistence;

import dev.batist.EventMark.core.entities.enums.Tipo;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Eventos")
@Builder
public class EventosEntity{
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                            Long id;
                            String nome;
                            String descricao;
                            LocalDateTime inicio;
                            LocalDateTime fim;
                            String identificador;
                            String organizador;
                            @Column(name = "local_evento")
                            String local;
                            Integer capacidade;
                            @Enumerated(EnumType.STRING)
                            @Column(name = "tipo_evento")
                            Tipo tipoEvento;

    public EventosEntity() {
    }

    public EventosEntity(Long id, String nome, String descricao, LocalDateTime inicio, LocalDateTime fim, String identificador, String organizador, String local, Integer capacidade, Tipo tipoEvento) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.identificador = identificador;
        this.organizador = organizador;
        this.local = local;
        this.capacidade = capacidade;
        this.tipoEvento = tipoEvento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Tipo getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(Tipo tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}
