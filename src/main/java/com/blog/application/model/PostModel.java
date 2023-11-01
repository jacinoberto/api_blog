package com.blog.application.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_posts")
public class PostModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_post")
    private UUID id;
    private String titulo;
    private String noticia;

    public PostModel() {
    }

    public PostModel(UUID id, String titulo, String noticia) {
        this.id = id;
        this.titulo = titulo;
        this.noticia = noticia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostModel blogModel = (PostModel) o;
        return Objects.equals(id, blogModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
