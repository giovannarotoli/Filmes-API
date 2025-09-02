package application.genero.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import application.genero.Genero;
import application.genero.record.GeneroDTO;
import application.genero.record.GeneroInsertDTO;
import application.genero.repository.GeneroRepository;
import application.genero.service.GeneroService;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository GeneroRepo;

    public Iterable <GeneroDTO> getAll() {
        return GeneroRepo.findAll().stream().map(GeneroDTO::new).toList();
    }

     public GeneroDTO insert(GeneroInsertDTO dados) {
        return new GeneroDTO(GeneroRepo.save(new Genero (dados)));
     }

    public GeneroDTO getOne(long id) {
         Optional<Genero> resultado = GeneroRepo.findById(id);
 
        if (resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Genero não encontrado"
                );
        }
        return new GeneroDTO(resultado.get());
    }
    
    public GeneroDTO update(long id, GeneroInsertDTO dadosAluno) {
        Optional<Genero> resultado = GeneroRepo.findById(id);

        if (resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Genero não encontrado"
                );
        }

        resultado.get().setNome(dadosAluno.nome());
        return  new GeneroDTO(GeneroRepo.save(resultado.get()));
    }

    public void delete(@PathVariable long id){
        if(!GeneroRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Genero não encontrado"
                );
        }
        GeneroRepo.deleteById(id);
    }
}