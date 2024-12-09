package com.jpa.orm.mapping.OneToMany;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    private Long id;
    private String street;
    private String city;

    @ManyToOne
    private Person person;
}
