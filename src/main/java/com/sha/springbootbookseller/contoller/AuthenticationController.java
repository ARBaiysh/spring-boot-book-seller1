package com.sha.springbootbookseller.contoller;

import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.service.IAuthenticationService;
import com.sha.springbootbookseller.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")
@AllArgsConstructor
public class AuthenticationController {
    private final IAuthenticationService authenticationService;
    private final IUserService userService;

    @PostMapping("sing-up")
    public ResponseEntity<User> singUp(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent())
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("sing-in")
    public ResponseEntity<?> singIn(@RequestBody User user) {
        return new ResponseEntity<>(authenticationService.singInAndReturnJWT(user), HttpStatus.OK);
    }
}
