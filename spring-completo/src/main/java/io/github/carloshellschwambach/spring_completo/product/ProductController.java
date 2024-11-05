package io.github.carloshellschwambach.spring_completo.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/shop")
public class ProductController {

    private ProductRepository productRepository;

    private ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable("id") String id) {
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping("/name")
    public List<Product> getByName(@RequestParam("name") String name) {
        return productRepository.findByName(name);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
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
