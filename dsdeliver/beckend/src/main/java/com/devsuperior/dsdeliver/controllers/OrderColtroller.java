package com.devsuperior.dsdeliver.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.services.OrderService;



@RestController
@RequestMapping(value = "/orders")
public class OrderColtroller {
	
	@Autowired
	private OrderService service;
	
	@GetMapping//para passar a lista de produto e quando receber 
	public ResponseEntity<List<OrderDTO>> findAll(){
		List<OrderDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);//quando receber passar o codigo 200
	}
	@PostMapping//o metodo http vai ser POST		
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){//ORDERDTO vai ser um jainson requesst body converte para jainson
		dto = service.insert(dto);//cria um insert
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")//import java.uri
				.buildAndExpand(dto.getId()).toUri();//para passar o codigo 201 - chamada para criar a uri do recurso que voce criou 
		return ResponseEntity.created(uri).body(dto);//restorna a resposta 200
		
	}
	
	@PutMapping("/{id}/delivered")//passa na url
	public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id){
		OrderDTO dto = service.setDelivered(id);
		return ResponseEntity.ok().body(dto);
	}
}
