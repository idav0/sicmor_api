package mx.edu.utez.sicmor_api.controllers.user;


import mx.edu.utez.sicmor_api.controllers.user.dto.UserDto;
import mx.edu.utez.sicmor_api.models.user.User;
import mx.edu.utez.sicmor_api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mx.edu.utez.sicmor_api.services.user.UserService;

@RestController
@RequestMapping("/api-sicmor/user")
@CrossOrigin(origins = {"*"})
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/{id}")
    public ResponseEntity<Response<User>> getById(@PathVariable(value="id")Long id){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }


    @PutMapping("/")
    public ResponseEntity<Response<User>> update(@RequestBody UserDto user){
        return new ResponseEntity<>(
                this.service.update(user.getUser()),
                HttpStatus.OK
        );
    }
}
