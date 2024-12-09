package com.jpa.orm.mapping;

import com.jpa.orm.mapping.ManyToMany.Category;
import com.jpa.orm.mapping.ManyToMany.CategoryRepository;
import com.jpa.orm.mapping.ManyToMany.Product;
import com.jpa.orm.mapping.ManyToMany.ProductRepository;
import com.jpa.orm.mapping.OneToMany.Address;
import com.jpa.orm.mapping.OneToMany.AddressRepository;
import com.jpa.orm.mapping.OneToMany.Person;
import com.jpa.orm.mapping.OneToMany.PersonRepository;
import com.jpa.orm.mapping.OneToOne.Laptop;
import com.jpa.orm.mapping.OneToOne.LaptopRepository;
import com.jpa.orm.mapping.OneToOne.Student;
import com.jpa.orm.mapping.OneToOne.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OrmMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmMappingApplication.class, args);
    }

    @Autowired
    LaptopRepository laptopRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            //todo OneToOne
            var laptop = Laptop.builder()
                    .id(1L)
                    .name("MacBook Pro")
                    .build();
            var student = Student.builder()
                    .id(1L)
                    .build();

            laptop.setStudent(student);
            laptopRepository.save(laptop);

            //todo OneToMany/ManyToOne
            var address1 = Address.builder()
                    .id(1L)
                    .city("Seoul")
                    .street("Jungreong")
                    .build();

            var address2 = Address.builder()
                    .id(2L)
                    .city("Dhaka")
                    .street("Badda")
                    .build();

            var person = Person.builder()
                    .id(1L)
                    .name("John")
                    .addresses(List.of(address1, address2))
                    .build();

            address1.setPerson(person);
            address2.setPerson(person);

            personRepository.save(person);

            //todo ManyToMany

            var category1 = Category.builder()
                    .id(1L)
                    .name("student1")
                    .build();

            var category2 = Category.builder()
                    .id(2L)
                    .name("student2")
                    .build();

            var product1 = Product.builder()
                    .id(1L)
                    .name("course1")
                    .build();

            var product2 = Product.builder()
                    .id(2L)
                    .name("Course2")
                    .build();

            category1.setProducts(List.of(product1,product2));
            category2.setProducts(List.of(product1,product2));

            categoryRepository.save(category1);
            categoryRepository.save(category2);
        };
    }

}
