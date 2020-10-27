package com.globallogic.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.globallogic.model.PhoneEntity;
import com.globallogic.model.Phones;
import com.globallogic.model.UserEntity;
import com.globallogic.model.Usuario;


@Transactional
@Component
public class UserService {
	
	private JsonNodeFactory nodeFactory = JsonNodeFactory.instance;
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	private static final String MENSAJE = "mensaje";
	private static final String ERROR = "error";
	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public ObjectNode create(Usuario data) {
		ObjectNode response = nodeFactory.objectNode();
		logger.info("## Validando datos de entrada");
		
		if (!getUserByEmail(data.getEmail())) {
			logger.info("## Revisando si el usuario ya existe en la base de datos");
			response.put(MENSAJE, "Usuario ya se encuentra registrado");
			return response;
		}
		
		if (!UtilService.validaMail(data.getEmail())) {
			logger.info("## El correo tiene formato invalido");
			response.put(ERROR, "El correo tiene formato invalido");
			return response;
		}
			
		if (!UtilService.validaPassword(data.getPassword())) {
			logger.info("## La contraseña tiene un formato invalido");
			response.put(ERROR, "el password debe tener al menos 2 números, una mayúscula y una minúscula");
			return response;
		}
		
		UserEntity user = new UserEntity();
		user.setId(UtilService.uuid());
		user.setPassword(data.getPassword());
		user.setName(data.getName());
		user.setEmail(data.getEmail());
		user.setCreated(new Date());
		user.setLastlogin(new Date());
		user.setToken(UtilService.getJWTToken(data.getEmail()));
		user.setIsactive(true);
		
		List<PhoneEntity> phoneEntities = new ArrayList<>();
		for(Phones phone : data.getPhones()) {
			PhoneEntity phe = new PhoneEntity();
			phe.setCitycode(phone.getCitycode());
			phe.setCountrycode(phone.getContrycode());
			phe.setNumber(phone.getNumber());
			phe.setUser(user);
			phoneEntities.add(phe);
		}
		user.setPhones(phoneEntities);
		
		logger.info("## Guardando usuario en base de datos");
		 entityManager.persist(user);
		 return usuarioSalida(user);
	}
	
	public ObjectNode getUsers() {
		List<UserEntity> listUsers = (List<UserEntity>) userRepository.findAll();
		ObjectNode response = nodeFactory.objectNode();
		ArrayNode responseUsers = nodeFactory.arrayNode();
		logger.info("## Recuperando listado de usuarios en base de datos");
		for (UserEntity users : listUsers) {
			responseUsers.add(usuarioSalida(users));
		}
		response.set("Users", responseUsers);
		return response;
	}
	
	
	public ObjectNode login(Usuario body) {
		ObjectNode response = nodeFactory.objectNode();
		UserEntity user = verifyLogin(body.getEmail(), body.getPassword());
		if (user !=null) {
			logger.info("## Usuario encontrado exitosamente");
			user.setLastlogin(new Date());
			userRepository.save(user);
			return usuarioSalida(user);
		}
		logger.info("## Usuario no encontrado o contraseña incorrecta");
		response.put(MENSAJE, "Usuario no encontrado o contraseña incorrecta");
		return response;
	}
	
	
	
	public ObjectNode usuarioSalida (UserEntity user) {
		ObjectNode response = nodeFactory.objectNode();
		logger.info("## Recuperando los valores de la base de datos");
		response.put("id", user.getId());
		response.put("name", user.getName());
		response.put("email", user.getEmail());
		response.put("created", sdf.format(user.getCreated()));
		response.put("modified", sdf.format(user.getCreated()));
		response.put("last_login", sdf.format(user.getLastlogin()));
		response.put("token", user.getToken());
		response.put("isactive", user.getIsactive());
		
		ArrayNode telefonos = nodeFactory.arrayNode();
		for (PhoneEntity phone : user.getPhones()) {
			ObjectNode telefono = nodeFactory.objectNode();
			telefono.put("number", phone.getNumber());
			telefono.put("citycode", phone.getCitycode());
			telefono.put("countrycode", phone.getCountrycode());
			telefonos.add(telefono);
		}
		response.set("phones", telefonos);
		return response;
		
	}
	
	public ObjectNode getUser(String id) {
		logger.info("## Buscando usuario en la base de datos");
		UserEntity user = userRepository.findById(id);
		if (user == null) {
			ObjectNode response = nodeFactory.objectNode();
			logger.info("## Usuario no encontrado en base de datos");
			response.put(MENSAJE, "El usuario no ha sido encontrado");
			return response;
		}
		return usuarioSalida(user);
	}
	
	public boolean getUserByEmail(String email) {
		logger.info("## Recueperando usuario buscando por email");
		UserEntity user = userRepository.findByEmail(email);
		return (user == null);
	}
	
	public UserEntity verifyLogin(String email, String password) {
		logger.info("## Recuperando usuario por email y contraseña");
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	public UserEntity updateLogin(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}


}
