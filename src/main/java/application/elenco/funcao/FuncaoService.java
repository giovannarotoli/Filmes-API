package application.elenco.funcao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FuncaoService {
     @Autowired
    private FuncaoRepository FuncaoRepo;

    public Iterable <FuncaoDTO> getAll() {
        return FuncaoRepo.findAll().stream().map(FuncaoDTO::new).toList();
    }

     public FuncaoDTO insert(FuncaoInsertDTO dados) {
        return new FuncaoDTO(FuncaoRepo.save(new Funcao (dados)));
     }

    public FuncaoDTO getOne(long id) {
         Optional<Funcao> resultado = FuncaoRepo.findById(id);
 
        if (resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Funcao não encontrado"
                );
        }
        return new FuncaoDTO(resultado.get());
    }
    
    public FuncaoDTO update(long id, FuncaoInsertDTO dados) {
        Optional<Funcao> resultado = FuncaoRepo.findById(id);

        if (resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Funcao não encontrado"
                );
        }

        resultado.get().setDescricao(dados.descricao());
        return  new FuncaoDTO(FuncaoRepo.save(resultado.get()));
    }

    public void delete(@PathVariable long id){
        if(!FuncaoRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Genero não encontrado"
                );
        }
        FuncaoRepo.deleteById(id);
    }
}
