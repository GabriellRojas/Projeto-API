package rojas.gabriel.projetoapi.controllers;

import rojas.gabriel.projetoapi.models.GameEntity;
import rojas.gabriel.projetoapi.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class GameController { //Classe Controladora
    @Autowired
    private GameRepository gameRepository;

    public ResponseEntity<List<GameEntity>> findAll(){ //GET
        return new ResponseEntity<List<GameEntity>>(
                (List<GameEntity>)this.gameRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK); //ERROR 404
    }

    //GET
    @GetMapping(path = "(/{id}")
    public ResponseEntity<GameEntity>findById(@PathVariable ("id")long id) {
        if (this.gameRepository.findById(id).isPresent()) {
            return new ResponseEntity<GameEntity>(
                    this.gameRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<GameEntity>(HttpStatus.NOT_FOUND);
    }

    //POST
    @PostMapping
    public ResponseEntity<GameEntity> cadastrar (@RequestBody GameEntity gameEntity){
        return new ResponseEntity<GameEntity>(
                this.gameRepository.save(gameEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );
    }
    //PUT
    @PutMapping(value = "/id")
    public ResponseEntity<GameEntity> atualizar (@PathVariable("id")long id,
                                                        @RequestBody GameEntity gameEntity)throws Exception{
        if(id== 0 || !this.gameRepository.existsById(id)){ //op. Lógicos
            throw new Exception("Código não encontrado ou inexistente");
        }
        return new ResponseEntity<GameEntity>(
                this.gameRepository.save(gameEntity),
                new HttpHeaders(),
                HttpStatus.OK);

    }


    //DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<GameEntity> deletar (@PathVariable("id") long id ){
        this.gameRepository.deleteById(id);
        return new ResponseEntity<GameEntity>(new HttpHeaders(), HttpStatus.OK);
    }

}
