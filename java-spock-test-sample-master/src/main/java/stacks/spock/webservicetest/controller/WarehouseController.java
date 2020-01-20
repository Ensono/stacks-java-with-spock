package stacks.spock.webservicetest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stacks.spock.webservicetest.customexception.EntityNotFoundException;
import stacks.spock.webservicetest.entities.Employee;
import stacks.spock.webservicetest.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author suresh
 */
@RestController
public class WarehouseController {

    private List<Product> existingProducts = new ArrayList<Product>();

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String healthCheck() {

        return "Active and Running";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> listProducts() {
        return existingProducts;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product createDefaultProduct() {
        Product product = new Product();
        product.setName("test product");
        product.setPrice(0);
        product.setStock(10);
        product.setId(existingProducts.size());
        existingProducts.add(product);

        return product;

    }

    @RequestMapping(value = "/products", method = RequestMethod.DELETE)
    public String deleteAllProducts() {
        int count = existingProducts.size();
        existingProducts.clear();
        return "Removed " + count + " products";

    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public Product listProduct(@PathVariable Integer productId) {
        if (Objects.isNull(productId)) {
            throw new EntityNotFoundException("product id not found");
        }
        return existingProducts.get(productId);
    }

    @RequestMapping(value = "/products/{productId}/name", method = RequestMethod.PUT, params = "name")
    public Product renameProduct(@PathVariable Integer productId, @RequestParam("name") String name) {
        if (productId < 0 || productId >= existingProducts.size()) {
            throw new EntityNotFoundException("product id not found");
        }
        Product product = existingProducts.get(productId);
        product.setName(name);
        return product;
    }

    @PostMapping("/employees")
    ResponseEntity newEmployee(@RequestBody Employee newEmployee) {
        if (Objects.isNull(newEmployee)) {
            throw new EntityNotFoundException("Not valid Employee.");
        }
        return new ResponseEntity(HttpStatus.OK);
    }


}

