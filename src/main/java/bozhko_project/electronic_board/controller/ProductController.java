package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.dto_products.CreateProductDto;
import bozhko_project.electronic_board.mapper.ProductMapper;
import bozhko_project.electronic_board.repository.product_rep.ProductRepository;
import bozhko_project.electronic_board.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "ProductController", description = "API продуктов")
@Validated
public class ProductController {
    @Autowired
    private final ProductService productService;
    @Autowired
    private final ProductMapper productMapper;
    @Autowired
    private final ProductRepository productRepository;

    @Operation(description = "Добавление/создание продукта")
    @PostMapping(value =" /user/announcement/product")
    public ResponseEntity<String> createProductController(@Parameter(description = "запрос на создание продукта",required = true)
                                                          @RequestBody(required = false) CreateProductDto request){
        productService.createProductService(request);
        return ResponseEntity.ok("Продукт добавлен в базу");
    }

}
