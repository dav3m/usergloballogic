package com.globallogic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.globallogic.model.Usuario;
import com.globallogic.service.UserService;

	@RestController
	public class UserController {

	@Autowired
	private UserService user;

	private static final String MENSAJE = "mensaje";
	private static final String ERROR = "error";
	
	@PostMapping(value = "/globallogic/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <ObjectNode> register(@RequestBody(required = false) Usuario body) {
		ObjectNode usuario = user.create(body);
		if (usuario.has(MENSAJE)) {
			return new ResponseEntity<>(usuario,HttpStatus.NOT_FOUND);
		}else if (usuario.has(ERROR)) {
			return new ResponseEntity<>(usuario,HttpStatus.PRECONDITION_FAILED);
		}
		return new ResponseEntity<>(usuario,HttpStatus.CREATED);
		
	}
	
		@PostMapping(value = "/globallogic/login", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ObjectNode> login(@RequestBody(required = false) Usuario body) {
			ObjectNode usuario = user.login(body);
			if (usuario.has(MENSAJE)) {
				return new ResponseEntity<>(usuario,HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok(usuario);
			
		}
	
	
	@GetMapping(value = "/globallogic/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <ObjectNode> users() {
		ObjectNode usuarios = user.getUsers();
		return ResponseEntity.ok(usuarios);
		
	}
	
	@GetMapping(value = "/globallogic/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <ObjectNode> user(@PathVariable("id") String id) {
		ObjectNode usuario = user.getUser(id);
		if (usuario.has(MENSAJE)) {
			return new ResponseEntity<>(usuario,HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(usuario);
		
	}

}

