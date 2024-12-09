package com.jpa.orm.mapping.ManyToMany;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public List<Product> getProductsFromCateGories() {
        return categoryRepository.findById(10L)
                .get()
                .getProducts();
    }

}
