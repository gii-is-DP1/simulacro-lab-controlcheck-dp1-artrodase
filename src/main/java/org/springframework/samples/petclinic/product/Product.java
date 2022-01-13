package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	
	@NotNull
	@Size(min=3, max=50)
    String name;
	
	@NotNull
	@Min(0)
    double price;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "product_id")
    ProductType productType;
}
