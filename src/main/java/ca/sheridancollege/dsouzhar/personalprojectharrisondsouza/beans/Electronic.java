package ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.beans;



import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class Electronic {
    private Long id;
    private String imageUrl;
    private String productName;
    private String productDesc;
    private float price;
}
