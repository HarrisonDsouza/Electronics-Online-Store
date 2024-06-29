package ca.sheridancollege.dsouzhar.beans;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class Electronic {
    private long id;
    private String imageUrl;
    private String productName;
    private String productDesc;
    private float price;
    private List<String> reviews = new CopyOnWriteArrayList<>();
}
