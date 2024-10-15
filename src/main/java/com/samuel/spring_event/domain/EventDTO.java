package com.samuel.spring_event.domain;

public class EventDTO {
    private Long id;
    private String nome;
    private String data;
    private String local;

    // Construtores, Getters e Setters
    public EventDTO() {}

    public EventDTO(Long id, String nome, String data, String local) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.local = local;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
}
