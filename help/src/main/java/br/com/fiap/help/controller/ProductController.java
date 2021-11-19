package br.com.fiap.help.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.help.model.Product;
import br.com.fiap.help.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping("/product")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("products");
		List<Product> products = repository.findAll();
		modelAndView.addObject("products", products);
		return modelAndView;
	}
	
	@PostMapping("/product")
	public String save(Product product) {
		repository.save(product);
		System.out.println("salvar tarefa..." + product);
		return "products";
	}
	
	@RequestMapping("/product/new")
	public String create() {
		return "product-form";
	}
	
}
