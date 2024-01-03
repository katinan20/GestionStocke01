package com.paulo.gestionstock0_1.service.implService;

import com.paulo.gestionstock0_1.DTO.CategoryDTO;
import com.paulo.gestionstock0_1.entity.Category;
import com.paulo.gestionstock0_1.exception.EntityNotFoundException;
import com.paulo.gestionstock0_1.exception.ErrorCodes;
import com.paulo.gestionstock0_1.exception.InvalidEntityException;
import com.paulo.gestionstock0_1.repository.CategoryRepository;
import com.paulo.gestionstock0_1.service.CategorieService;
import com.paulo.gestionstock0_1.validation.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieServiceImp implements CategorieService {

    private CategoryRepository categoryRepository;
    @Autowired
    public CategorieServiceImp(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        List<String> errors = CategoryValidator.validate(categoryDTO);
        if (!errors.isEmpty()){
            log.error("Categories is not valid {}", categoryDTO);
            throw new InvalidEntityException("la categories est invalid", ErrorCodes.CATEGORY_NOT_FOUND, errors);
        }
        return CategoryDTO.fromEntity(
                categoryRepository.save(
                        CategoryDTO.toEntity(categoryDTO)
                )
        );
    }

    @Override
    public CategoryDTO findById(Integer id) {
        if (id == null){
            log.error("CATEGORIES ID EST NULL");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);

        return Optional.of(CategoryDTO.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucune categories avec l'ID =" + id + "n'a été trouvé dans la base de donnée",
                        ErrorCodes.CATEGORY_NOT_FOUND
                )
        );
    }

    @Override
    public CategoryDTO findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("Categories code est null");
            return null;
        }
        Optional<Category> category = categoryRepository.findCategoriesByCode(code);

        return Optional.of(CategoryDTO.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucune categories avec l'ID =" + code + "n'a été trouvé dans la base de donnée",
                        ErrorCodes.CATEGORY_NOT_FOUND
                )
        );
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDTO::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        List<String> errors = CategoryValidator.validate(categoryDTO);
        return null;
    }



    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("l'ID de la categories est null");
        }
        categoryRepository.deleteById(id);

    }
}
