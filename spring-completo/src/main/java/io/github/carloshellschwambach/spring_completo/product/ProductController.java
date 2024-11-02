package io.github.carloshellschwambach.spring_completo.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/shop")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable("id") String id) {
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping("{id}")
    public Product getByName(@PathVariable("id") String id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void save(@RequestBody Product product) {
        productRepository.save(product);
    }

    @PutMapping
    public void update(@PathVariable("id") String id, @RequestBody Product product) {
        product.setId(id);

        productRepository.save(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id) {
        productRepository.deleteById(id);
    }

}