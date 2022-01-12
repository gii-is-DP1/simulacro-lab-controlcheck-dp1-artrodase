package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private ProductRepository prodRepository;

	@Autowired
    public ProductService(ProductRepository prodRepository) {
		this.prodRepository = prodRepository;
	}

	public List<Product> getAllProducts(){
        return prodRepository.findAll();
    }
	
	

    public List<Product> getProductsCheaperThan(double price) {
        return prodRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
    	return prodRepository.getProductType(typeName);
    }

    public Product save(Product p){
        return prodRepository.save(p);       
    }
    
    public List<ProductType> findAllProductTypes(){
    	return prodRepository.findAllProductTypes(); 
    }

    
}
