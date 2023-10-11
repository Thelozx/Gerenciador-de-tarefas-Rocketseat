package br.com.talislima.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.var;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository  userRepository;

    //http://127.0.0.1:8080/users
    @PostMapping("/")
    public ResponseEntity create (@RequestBody UserModel userModel) {
       var user = this.userRepository.findByUsername(userModel.getUsername());

       if (user != null){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario Já Cadastrado.");

       }

       var passwordHashred = BCrypt .withDefaults()
       .hashToString(12, userModel.getPassword().toCharArray());

       userModel.setPassword(passwordHashred);


       var userCreated = this.userRepository.save(userModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);

    }
}


