package com.example.demo.controller;

import java.security.Principal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
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
    return jwt.getClaimAsString("preferred_username");
  }



}
