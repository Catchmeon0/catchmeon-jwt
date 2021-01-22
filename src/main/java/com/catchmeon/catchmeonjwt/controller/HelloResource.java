package com.catchmeon.catchmeonjwt.controller;


import com.catchmeon.catchmeonjwt.models.request.AuthenticationRequest;
import com.catchmeon.catchmeonjwt.models.reponse.AuthenticationResponse;
import com.catchmeon.catchmeonjwt.models.UserCMO;

import com.catchmeon.catchmeonjwt.models.reponse.SignUpResponse;
import com.catchmeon.catchmeonjwt.models.request.SignUpRequest;
import com.catchmeon.catchmeonjwt.models.request.TweetRequest;
import com.catchmeon.catchmeonjwt.models.twetterModel;
import com.catchmeon.catchmeonjwt.services.UserService;
import com.catchmeon.catchmeonjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;


@RestController
public class HelloResource {



    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello world";
    }


    @CrossOrigin("*")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception(" Incorrect username or password");
        }
        final UserCMO userCMO =userService.getUser(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userCMO);
        return ResponseEntity.ok(new AuthenticationResponse(jwt, userCMO));
    }

    @CrossOrigin("*")
    @PostMapping ("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest newUser) throws Exception{
        UserCMO user= new UserCMO(newUser.getUsername(),newUser.getPassword(),newUser.getEmail());
         user = this.userService.createUser(user);
        return ResponseEntity.ok(new SignUpResponse(user.getUsername()));
    }



    @RequestMapping (value = "/getTweetFromUser" /*,produces = MediaType.APPLICATION_JSON_VALUE*/)
    @ResponseBody
    @CrossOrigin("*")
    public ResponseEntity<?> getTweet(@RequestParam  (required = false) String  userTwetterId) throws Exception{
        twetterModel tweet = new twetterModel();
        // String res = new TweetRequest(userTwetterId).getJsonData(userTwetterId);
        String tweetRequestList = new TweetRequest(userTwetterId).listStatusJsonResponse();


        return new ResponseEntity<>(
                tweetRequestList,
                HttpStatus.OK);
    }

}
