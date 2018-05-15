package com.rest.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.poc.model.User;
import com.rest.poc.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

   /*---Add new user---*/
   @PostMapping("/user")
   public ResponseEntity<?> save(@RequestBody User user) {
      long id = userService.save(user);
      return ResponseEntity.ok().body(user);
   }

   /*---Get a user by id---*/
   @GetMapping("/user/{id}")
   public ResponseEntity<User> get(@PathVariable("id") long id) {
      User user = userService.get(id);
      return ResponseEntity.ok().body(user);
   }

   /*---get all user---*/
   @GetMapping("/user")
   public ResponseEntity<List<User>> list() {
      List<User> users = userService.list();
      return ResponseEntity.ok().body(users);
   }

   /*---Update a user by id---*/
   @PutMapping("/user/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User user) {
      userService.update(id, user);
      return ResponseEntity.ok().body(user);
   }

   /*---Delete a user by id---*/
   @DeleteMapping("/user/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	   User user = userService.get(id);
	   if(user != null) {
		   return ResponseEntity.ok().body(id);
	   } else {
		   return ResponseEntity.notFound().build();
	   }
   }
}
