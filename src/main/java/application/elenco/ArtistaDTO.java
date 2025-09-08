package application.elenco;

public record ArtistaDTO(long id, String nome) {
    public ArtistaDTO(Artista dados){
        this(dados.getId());
    }
}
