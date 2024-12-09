package com.jpa.orm.mapping.ManyToMany;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "products",cascade = CascadeType.ALL)
    private List<Category> categories;
}
