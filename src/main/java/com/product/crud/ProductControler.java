package com.product.crud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProductControler {
	List<Product> proList = new ArrayList<>();
	
	@RequestMapping(value="/show")
	public List<Product> show(ProductDA pdtShow) {
		pdtShow = new ProductDA();
		proList = pdtShow.show();
		return proList;
	}
	
	
	@GetMapping(value ="/product/{id}")
	public Product getStudentById(@PathVariable("id") int id) {
		Product pdt ;
		ProductDA pro = new ProductDA();
		pdt = pro.productById(id);
		return pdt;
	}
	
	
	@PostMapping(value="/save")
	public void save(@RequestBody Product pdt) {
		ProductDA pro = new ProductDA();
		pro.insert(pdt);
	}
	
	
	@PostMapping(value ="/update")
	public void update(@RequestBody Product pdt) {
		ProductDA pro = new ProductDA();
			pro.update(pdt);
	}
	
	@PostMapping(value ="/delete")
	public void delete(@RequestBody Product pdt) {
		ProductDA pro = new ProductDA();
			pro.delete(pdt);
	}
	
}
