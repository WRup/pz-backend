package pl.shopgen.controllers.mocks;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.shopgen.models.Product;
import pl.shopgen.models.mocks.ProductListGenerator;
import pl.shopgen.repositories.CategoryRepository;
import pl.shopgen.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/mocks/productsGenerator")
public class ProductsGeneratorController {

    private final ProductListGenerator productListGenerator;

    private final ProductRepository productRepository;

    public ProductsGeneratorController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        productListGenerator = new ProductListGenerator(categoryRepository);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> generateProducts() {
        return productRepository.insert(productListGenerator.generateProducts());
    }
}
