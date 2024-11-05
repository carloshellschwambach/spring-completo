package io.github.carloshellschwambach.spring_completo.product;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

}
