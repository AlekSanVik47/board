package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.dto_products.CreateProductDto;
import bozhko_project.electronic_board.dto.dto_products.ProductUpdateDTO;
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
    @PostMapping(value =" /user/announcement/create-product")
    public ResponseEntity<String> createProductController(@Parameter(description = "запрос на создание продукта",required = true)
                                                          @RequestBody(required = false) CreateProductDto request){
        productService.createProductService(request);
        return ResponseEntity.ok("Продукт добавлен в базу");
    }
    @Operation(description = "Обновление продукта")
    @PostMapping(value ="user/announcement/product/update-product/{productId}")
    public ResponseEntity<String> productUpdateController(@Parameter(description = "запрос на обновление продукта",required = true)
                                                              @RequestBody(required = false) ProductUpdateDTO request,
    @PathVariable("productId") Long productId){
        productService.productUpdateService(request,productId );
        return ResponseEntity.ok("Данные успешно обновлены");
    }

    @Operation(description = "Обновление названия")
    @PostMapping(value ="user/announcement/product/update-product-name/{productId}")
    public ResponseEntity<String> productNameUpdateController(@Parameter(description = "запрос на обновление продукта",required = true)
                                                          @RequestBody(required = false) ProductUpdateDTO request,
                                                          @PathVariable("productId") Long productId){
        productService.productNameUpdateService(request,productId );
        return ResponseEntity.ok("Название успешно обновлено");
    }
    @Operation(description = "Обновление изображения")
    @PostMapping(value ="user/announcement/product/update-product-image/{productId}")
    public ResponseEntity<String> productImageUpdateController(@Parameter(description = "запрос на обновление продукта",required = true)
                                                              @RequestBody(required = false) ProductUpdateDTO request,
                                                              @PathVariable("productId") Long productId){
        productService.productImageUpdateService(request,productId );
        return ResponseEntity.ok("Изображение успешно обновлено");
    }
    @Operation(description = "Обновление описания")
    @PostMapping(value ="user/announcement/product/update-product-description/{productId}")
    public ResponseEntity<String> productDescriptionUpdateController(@Parameter(description = "запрос на обновление продукта",required = true)
                                                               @RequestBody(required = false) ProductUpdateDTO request,
                                                               @PathVariable("productId") Long productId){
        productService.productDescriptionUpdateService(request,productId );
        return ResponseEntity.ok("Описание успешно обновлено");
    }
    @Operation(description = "Изменение цены")
    @PostMapping(value ="user/announcement/product/update-product-price/{productId}")
    public ResponseEntity<String> productPriceUpdateController(@Parameter(description = "запрос на обновление продукта",required = true)
                                                                     @RequestBody(required = false) ProductUpdateDTO request,
                                                                     @PathVariable("productId") Long productId){
        productService.productPriceUpdateService(request,productId );
        return ResponseEntity.ok("Цена успешно изменена");
    }

    @Operation(description = "Удаление продукта")
    @DeleteMapping(value = "/announcement/product/product-delete/{productId}")
    public ResponseEntity<Object> deleteUser(@Parameter(description = "Идентификатор для удаления", required = true)
                                             @PathVariable(value = "productId") Long productId){
        productService.deleteProductService(productId);
        return ResponseEntity.noContent().build();
    }

}
