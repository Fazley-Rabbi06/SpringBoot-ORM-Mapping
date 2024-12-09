package com.jpa.orm.mapping.OneToOne;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "laptops")
public class Laptop {

    @Id
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;
}
