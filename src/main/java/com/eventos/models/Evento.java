package com.eventos.models;

import com.eventos.enums.Classificacao;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String descricao;
    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fim")
    private String horafim;

    @Column(name = "hora_abertura")
    private String horaAbertura;

    private String imagem;

    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    @ManyToOne
    @JoinColumn(name = "produtora_id")
    private Produtora produtora;

    public Evento() {
    }

    public Evento(Long id, Date date, String descricao, String horaInicio, String horafim, String horaAbertura, String imagem, Classificacao classificacao, Produtora produtora) {
        this.id = id;
        this.date = date;
        this.descricao = descricao;
        this.horaInicio = horaInicio;
        this.horafim = horafim;
        this.horaAbertura = horaAbertura;
        this.imagem = imagem;
        this.classificacao = classificacao;
        this.produtora = produtora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHorafim() {
        return horafim;
    }

    public void setHorafim(String horafim) {
        this.horafim = horafim;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Produtora getProdutora() {
        return produtora;
    }

    public void setProdutora(Produtora produtora) {
        this.produtora = produtora;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(id, evento.id) && Objects.equals(date, evento.date) && Objects.equals(descricao, evento.descricao) && Objects.equals(horaInicio, evento.horaInicio) && Objects.equals(horafim, evento.horafim) && Objects.equals(horaAbertura, evento.horaAbertura) && Objects.equals(imagem, evento.imagem) && classificacao == evento.classificacao && Objects.equals(produtora, evento.produtora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, descricao, horaInicio, horafim, horaAbertura, imagem, classificacao, produtora);
    }
}
