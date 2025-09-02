package application.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    FilmeService filmeservice;

    @GetMapping
    public Iterable<FilmeDTO> getAll() {
        return this.filmeservice.getll();

    }

    @PostMapping
    public FilmeDTO insert(@RequestBody FilmeInsertDTO dadosNovos) {
        return this.filmeservice.insert(dadosNovos);
    }

    @PutMapping("/{id}")
    public FilmeDTO update(@PathVariable long id, @RequestBody FilmeInsertDTO dados) {
        return this.filmeservice.update(id, dados);
    }

    @GetMapping("/{id}")
    public FilmeDTO getOne(@PathVariable long id){
        return this.filmeservice.getOne(id);
    }
}