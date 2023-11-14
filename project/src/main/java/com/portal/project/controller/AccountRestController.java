package com.portal.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.project.config.JwtTokenUtil;
import com.portal.project.config.MyUserDetails;
import com.portal.project.dto.LoginRequest;
import com.portal.project.dto.LoginResponse;
import com.portal.project.dto.RegisterRequest;
import com.portal.project.handler.CustomResponse;
import com.portal.project.model.Cv;
import com.portal.project.model.User;
import com.portal.project.repository.CvRepository;
import com.portal.project.repository.UserRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class AccountRestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CvRepository cvRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private MyUserDetails myUserDetails;

    //submit register
    @PostMapping("save")
    public ResponseEntity<Object> save(@RequestBody RegisterRequest registerRequest){
        User user = new User();

        user.setUser_id(registerRequest.getUser_id());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(registerRequest.getRole());

        userRepository.save(user);
        Boolean isUserSaved = userRepository.findById(user.getUser_id()).isPresent();
        if(isUserSaved){
            Cv cv = new Cv();

            cv.setCv_id(user.getUser_id());
            cv.setName(registerRequest.getName());
            cv.setPhone(registerRequest.getPhone());
            cv.setAddress(registerRequest.getAddress());
            // cv.setUser(user);

            cvRepository.save(cv);
            Boolean isCvSaved = cvRepository.findById(cv.getCv_id()).isPresent();
            if(isCvSaved){
                return CustomResponse.generate(HttpStatus.OK, "berhasil membuat akun baru");
            }
            return CustomResponse.generate(HttpStatus.OK, "berhasil membuat akun baru");
        }
        return CustomResponse.generate(HttpStatus.BAD_REQUEST, "tidak berhasil membuat akun baru");
    }

    //login authenticate
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {

		authenticate(loginRequest.getEmail(), loginRequest.getPassword());

		final UserDetails userDetails = myUserDetails.loadUserByUsername(loginRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new LoginResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
