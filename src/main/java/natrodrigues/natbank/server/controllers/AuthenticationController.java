package natrodrigues.natbank.server.controllers;

import natrodrigues.natbank.server.config.exception.FormError;
import natrodrigues.natbank.server.config.security.TokenService;
import natrodrigues.natbank.server.controllers.dto.TokenDto;
import natrodrigues.natbank.server.controllers.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Object> authenticate(@RequestBody @Valid LoginForm loginForm, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(FormError.getErrorList(errors));
        }
        UsernamePasswordAuthenticationToken loginData = loginForm.convert();
        try {
            Authentication authentication = authManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok().body(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
