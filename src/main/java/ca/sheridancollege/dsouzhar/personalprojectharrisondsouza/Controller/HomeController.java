package ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.Controller;

import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.beans.Electronic;
import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.beans.Review;
import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.database.DatabaseAccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private DatabaseAccess db;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("electronics", db.getProductsList());
        return "index";
    }

    @GetMapping("/productDetail/{productId}")
    public String showProductDetail(@PathVariable Long productId, Model model) {
        Electronic product = db.getProductById(productId).get(0);
        List<Review> reviews = db.getReviewsByProductId(productId);
        model.addAttribute("product", product);
        model.addAttribute("reviews", reviews);
        return "productDetail";
    }

    @PostMapping("/addReview/{productId}")
    public String addReview(@PathVariable Long productId, @ModelAttribute Review review) {
        review.setProductId(productId);
        db.addReview(review);
        return "redirect:/productDetail/" + productId;
        // I wanted to return the same product detail page with the product ID. I
        // couldn't do it the normal way. I learnt the above returning technique from
        // stackoverflow -
        // https://stackoverflow.com/questions/40880772/spring-boot-redirect-to-a-different-controller-method
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("product", new Electronic());
        model.addAttribute("electronics", db.getProductsList());
        return "admin";
    }

    @PostMapping("/admin/addProduct")
    public String addProduct(Model model, @ModelAttribute Electronic product) {
        if (!db.getProductById(product.getId()).isEmpty()) {
            db.editProduct(product);
        } else {
            db.insertProduct(product);
        }
        model.addAttribute("product", new Electronic());
        model.addAttribute("electronics", db.getProductsList());
        return "admin";
    }

    @GetMapping("/admin/deleteProduct/{id}")
    public String deleteProduct(Model model, @PathVariable Long id) {
        db.deleteProduct(id);
        model.addAttribute("product", new Electronic());
        model.addAttribute("electronics", db.getProductsList());
        return "admin";
    }

    @GetMapping("/admin/editProduct/{id}")
    public String editProduct(Model model, @PathVariable Long id) {
        Electronic productToUpdate = db.getProductById(id).get(0);
        model.addAttribute("product", productToUpdate);
        model.addAttribute("electronics", db.getProductsList());
        return "admin";
    }

}
