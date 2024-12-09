package com.jpa.orm.mapping.ManyToMany;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "categories_products",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
