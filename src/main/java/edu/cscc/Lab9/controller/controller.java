package edu.cscc.Lab9.controller;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.cscc.Lab9.createorder;
import edu.cscc.Lab9.orders;

@RestController
public class controller {

	public static HashMap<Integer, orders> map = new HashMap<>();
	int ordercount = 1;
	
	@GetMapping("/v1/orders")
	public ResponseEntity<?> getOrders() {
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/v1/orders/{id}")
	public ResponseEntity<?> getOrdersByID(@PathVariable Integer id) {
		if (map.containsKey(id)) {
			return new ResponseEntity<>(map.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid order number!", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/v1/orders")
	public ResponseEntity<?> postOrder(
			@RequestBody createorder request) {
		orders order = new orders(ordercount, request.firstName, request.lastName, request.quantity, request.price); 
		map.put(ordercount, order);
		ordercount++;
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/v1/orders/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
		if (map.containsKey(id)) {
			map.remove(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>("Invalid order number!", HttpStatus.NOT_FOUND);
		}
	}
}
