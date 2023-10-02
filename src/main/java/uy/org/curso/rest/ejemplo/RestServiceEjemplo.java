package uy.org.curso.rest.ejemplo;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import uy.org.curso.rest.dto.SaludoDto;
import uy.org.curso.rest.dto.User;

@RestController
public class RestServiceEjemplo {
	
	@GetMapping(value = "/hello", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SaludoDto sayHelloMix() {
		return new SaludoDto("Hola");
	}
	
	
	//QUERY PARAMS EJEMPLOS
	@GetMapping(value = "/helloNamed")
	public String namedHello(@RequestParam(name = "name", defaultValue = "Sin Nombre", required = false) String name) {
		return MessageFormat.format("hola {0}", name);
	}
	
	@GetMapping(value = "/helloMultiple")
	public String namedHello(@RequestParam Map<String, String> allParams) {
		return "Los params son: " + allParams.entrySet();
	}
	
	//http://localhost:8080/helloValues?ids=1,2,3,4,5
	@GetMapping(value = "/helloValues")
	public String namedHello(@RequestParam(name = "ids") List<String> listParams) {
		return "los valores del param ids: " + listParams;
	}
	
	
	//PATH VARIABLE EJEMPLOS
	
	//http://localhost:8080/empleados/12
	@GetMapping("/empleados/{id}")
	public String getEmpleadosById(@PathVariable(name = "id") Long id) {
	    return "Empleado ID: " + id;
	}
	
	//http://localhost:8080/empleados/12/juan
	@GetMapping("/empleados/{id}/{name}")
	public String getempleadosByIdAndName(@PathVariable String id, @PathVariable String name) {
		return "Empleado ID: " + id + ", nombre: " + name;
	}
	
	//http://localhost:8080/empleadoNoRequerido
	//http://localhost:8080/empleadoNoRequerido/76
	@GetMapping(value = { "/empleadoNoRequerido", "/empleadoNoRequerido/{id}" })
	public String getEmpleadosByIdNoRequerido(@PathVariable(required = false) String id) {
	    if (id != null) {
	        return "Empleado ID: " + id;
	    } else {
	        return "Falta Empleado ID";
	    }
	}
	
	
	//EJEMPLO DE POST
	
	@PostMapping(value="/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public User registerUserCredential(@RequestBody User user){
	    System.out.println("Username: "+user.getUsername());
	    System.out.println("Password: "+user.getPassword());
	    return user;
	}	
}


