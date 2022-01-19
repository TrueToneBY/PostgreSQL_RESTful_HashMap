package ru.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rest.model.Client;
import ru.rest.service.ClientService;

import java.util.List;

@Slf4j
@RestController
public class ClientController {

    private final ClientService clientService;


    //@Autowired — говорит спрингу, что в этом месте необходимо внедрить зависимость.
    // В конструктор мы передаем интерфейс ClientService. Реализацию данного сервиса мы пометили аннотацией @Service ранее,
    // и теперь спринг сможет передать экземпляр этой реализации в конструктор контроллера.
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/client")
    public ResponseEntity<?> create(@RequestBody Client client){
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/client")
    public ResponseEntity<List<Client>>  read(){
        final List<Client> clients = clientService.readAll();

    return clients != null && !clients.isEmpty()
            ? new ResponseEntity<>(clients,HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/client/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id")int id){
        final Client client = clientService.read(id);

        return client != null
                ? new ResponseEntity<>(client,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/client/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id")int id,@RequestBody Client client){
        final boolean updated = clientService.update(client , id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/client/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id")int id){
        final boolean delete = clientService.delete(id);

        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(RuntimeException.class)
    public String handle(RuntimeException e){
        log.error(e.getMessage());
        return "Enter parametrs";
    }
}
