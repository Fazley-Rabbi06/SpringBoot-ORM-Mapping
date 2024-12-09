package com.jpa.orm.mapping.OneToOne;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    private Long id;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;
}
