package com.example.back.controllers;
import com.example.back.models.AuthModel;
import com.example.back.serviceImp.authServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class authController {
    private authServiceImp authService;
    private  final Logger log = LoggerFactory.getLogger(authController.class) ;

    public authController(authServiceImp oauthService) {
        this.authService = oauthService;
    }

 @PostMapping("")
    public ResponseEntity<?> getOauthDataController(@RequestBody AuthModel authModel) {
        String clientId= authModel.getClient_id() ;
        String secret= authModel.getClient_secret() ;
        String code = authModel.getCode() ;
       return authService.getOauthData(clientId, secret, code);
    }

}
