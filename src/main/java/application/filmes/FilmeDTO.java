package application.filmes;

import application.genero.record.GeneroDTO;

public record FilmeDTO(long id, String titulo, GeneroDTO genero) {
    FilmeDTO(Filme dados){
        this (dados.getId(), dados.getTitulo(), new GeneroDTO(dados.getGenero()));
    }
}
