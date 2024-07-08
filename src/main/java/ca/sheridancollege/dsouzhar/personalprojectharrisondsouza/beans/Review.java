package ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.beans;

import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class Review {
    private Long id;
    private Long productId;
    private String userName;
    private String userEmail;
    private float reviewScore;
}
