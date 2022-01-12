package org.springframework.samples.petclinic.product;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	
	@GetMapping(value = "/create")
	public String createGame(Map<String, Object> model) {
		Product prod = new Product();
		model.put("product", prod);
		List<ProductType> pT = productService.findAllProductTypes();
		model.put("prodType", pT);
		return "products/createOrUpdateProductForm";
	}

	@PostMapping(value = "/create")
	public String saveNewGame(@Valid Product product, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.put("message", "There are some errors");
			System.out.println(result);
			model.put("product", product);
			List<ProductType> pT = productService.findAllProductTypes();
			model.put("prodType", pT);
			return "products/createOrUpdateProductForm";
		}else {
			
			product.setId(3);
			productService.save(product);
			return "redirect:/product";
		}
		 
		
	}
    
}
