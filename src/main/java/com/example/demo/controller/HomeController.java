package com.example.demo.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

  @GetMapping
  public ResponseEntity<Principal> home(@AuthenticationPrincipal Principal principal) {
    return ResponseEntity.ok(principal);
  }

  @GetMapping("/username")
  public String name(@AuthenticationPrincipal Jwt jwt) {
    return new String(Base64Utils.decodeFromString(jwt.getSubject()));
  }



}
