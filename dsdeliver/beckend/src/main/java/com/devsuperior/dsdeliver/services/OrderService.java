package com.devsuperior.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired//endpoint para salvar
	private OrderRepository repository;
	
	@Autowired//endpoint para salvar
	private ProductRepository productRepository;//para isntanciar as entidade

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	@Transactional//faz a transação e fecha o mbanco de dados
	public OrderDTO insert(OrderDTO dto){//contem todos os dados do pedidoe todos os produtos desse pedido
		Order order = new Order(null, dto.getAddress(),dto.getLatitude(), //instanciar o pedidos
				dto.getLongitude(), Instant.now(), OrderStatus.PENDING);//instancia todos os pedidos
		for(ProductDTO p : dto.getProducts()) {//percorrer todo os dto s
			Product product = productRepository.getOne(p.getId());//instacia os pedidos e as associação com base id do p
			order.getProducts().add(product);//adicionar um produto instsn. no productdto
		 
	 }
		order = repository.save(order);//salva na variavel
		return new OrderDTO(order);//retorna convertido para o dto
}
}
