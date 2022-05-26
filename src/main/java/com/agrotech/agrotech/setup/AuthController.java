package com.agrotech.agrotech.setup;

import com.agrotech.agrotech.domain.model.Role;
import com.agrotech.agrotech.domain.model.User;
import com.agrotech.agrotech.domain.repository.IRoleRepository;
import com.agrotech.agrotech.domain.repository.IUserRepository;
import com.agrotech.agrotech.security.JwtAuthResponseDTO;
import com.agrotech.agrotech.security.JwtAuthenticationFilter;
import com.agrotech.agrotech.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IRoleRepository iRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        //obtenemos jwt
        String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthResponseDTO(token));
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpDTO signUpDTO){
        if(iUserRepository.existsByEmail(signUpDTO.getEmail())){
            return new ResponseEntity<>("This email already exists",HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(signUpDTO.getName());
        user.setLastname(signUpDTO.getLastname());
        user.setDni(signUpDTO.getDni());
        user.setCellphoneNumber(signUpDTO.getCellphoneNumber());
        user.setEmail(signUpDTO.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        user.setProfileImage(signUpDTO.getProfileImage());
        user.setAccessType(signUpDTO.getAccessType());

        Role role = iRoleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(role));

        iUserRepository.save(user);
        return new ResponseEntity<>("Successfully registered user",HttpStatus.OK);

    }
}
