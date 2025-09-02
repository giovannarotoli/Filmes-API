package application.genero.record;

import application.genero.Genero;

public record GeneroDTO(long id, String nome) {
    public GeneroDTO(Genero dados) {
        this(dados.getId(), dados.getNome());
    }    
}
