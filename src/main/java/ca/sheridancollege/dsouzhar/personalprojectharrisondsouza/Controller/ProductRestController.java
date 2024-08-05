package ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.Controller;

import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.beans.Electronic;
import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.database.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private DatabaseAccess databaseAccess;

    @GetMapping
    public List<Electronic> getAllProducts() {
        return databaseAccess.getProductsList();
    }
}
