package mx.edu.utez.sicmor_api.controllers.history;

import mx.edu.utez.sicmor_api.controllers.history.dto.HistoryDto;
import mx.edu.utez.sicmor_api.models.history.History;
import mx.edu.utez.sicmor_api.services.history.HistoryService;
import mx.edu.utez.sicmor_api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-sicmor/history")
@CrossOrigin(origins = {"*"})
public class HistoryController {

    @Autowired
    private HistoryService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<History>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<Response<History>> getById(@PathVariable(value="id")Long id){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<History>> insert(@RequestBody HistoryDto history){
        return new ResponseEntity<>(
                this.service.insert(history.getHistory()),
                HttpStatus.CREATED
        );
    }
}
