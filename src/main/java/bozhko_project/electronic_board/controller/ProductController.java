package bozhko_project.electronic_board.controller;

import bozhko_project.electronic_board.dto.dto_products.CreateProductDto;
import bozhko_project.electronic_board.dto.dto_products.ProductDto;
import bozhko_project.electronic_board.dto.dto_products.ProductUpdateDTO;
import bozhko_project.electronic_board.entities.products.Product;
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

import java.util.List;
import java.util.Optional;

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
    @PostMapping(value ="announcement/create-product")
    public ResponseEntity<String> createProductController(@Parameter(description = "запрос на создание продукта",required = true)
                                                          @RequestBody(required = false) CreateProductDto request){
        productService.createProductService(request);
        return ResponseEntity.ok("Продукт добавлен в базу");
    }
    @Operation(description = "Обновление продукта")
    @PutMapping(value ="announcement/product/update-product/{productId}")
    public ResponseEntity<String> productUpdateController(@Parameter(description = "запрос на обновление продукта",required = true)
                                                              @RequestBody(required = false) ProductUpdateDTO request,
    @PathVariable("productId") Long productId){
        productService.productUpdateService(request,productId );
        return ResponseEntity.ok("Данные успешно обновлены");
    }

    @Operation(description = "Обновление названия")
    @PutMapping(value ="announcement/product/update-product-name/{productId}")
    public ResponseEntity<String> productNameUpdateController(@Parameter(description = "запрос на обновление продукта",required = true)
                                                          @RequestBody(required = false) ProductUpdateDTO request,
                                                          @PathVariable("productId") Long productId){
        productService.productNameUpdateService(request,productId );
        return ResponseEntity.ok("Название успешно обновлено");
    }
    @Operation(description = "Обновление изображения")
    @PutMapping(value ="announcement/product/update-product-image/{productId}")
    public ResponseEntity<String> productImageUpdateController(@Parameter(description = "запрос на обновление продукта",required = true)
                                                              @RequestBody(required = false) ProductUpdateDTO request,
                                                              @PathVariable("productId") Long productId){
        productService.productImageUpdateService(request,productId );
        return ResponseEntity.ok("Изображение успешно обновлено");
    }
    @Operation(description = "Обновление описания")
    @PutMapping(value ="announcement/product/update-product-description/{productId}")
    public ResponseEntity<String> productDescriptionUpdateController(@Parameter(description = "запрос на обновление продукта",required = true)
                                                               @RequestBody(required = false) ProductUpdateDTO request,
                                                               @PathVariable("productId") Long productId){
        productService.productDescriptionUpdateService(request,productId );
        return ResponseEntity.ok("Описание успешно обновлено");
    }
    @Operation(description = "Изменение цены")
    @PutMapping(value ="announcement/product/update-product-price/{productId}")
    public ResponseEntity<String> productPriceUpdateController(@Parameter(description = "запрос на обновление продукта",required = true)
                                                                     @RequestBody(required = false) ProductUpdateDTO request,
                                                                     @PathVariable("productId") Long productId){
        productService.productPriceUpdateService(request,productId );
        return ResponseEntity.ok("Цена успешно изменена");
    }

    @Operation(description = "Удаление продукта")
    @DeleteMapping(value = "announcement/product/product-delete/{productId}")
    public ResponseEntity<Object> deleteProductController(@Parameter(description = "Идентификатор для удаления", required = true)
                                             @PathVariable(value = "productId") Long productId){
        productService.deleteProductService(productId);
        return ResponseEntity.noContent().build();
    }
    @Operation(description = " Получение списка продуктов")
    @GetMapping(value = "announcement/product/all-products",
            produces = {"application/json"})
    public ResponseEntity<List<Product>> getListAllProductController(@Parameter(description = "Список пользователей")
                                                               @RequestParam String products){
        List<Product> productList = productService.getListAllProductService();
        return ResponseEntity.ok(productList);
    }
    @Operation(description = " Получение продукта по ID")
    @GetMapping(value = "/announcement/by-product-id/{productId}",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<Optional<Product>> getProductById(@Parameter(description = "Поиск продукта по ID")
                                                      @PathVariable(value = "productId") Long productId,
                                                            @RequestBody(required = false) ProductDto request) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }
    @Operation(description = " Получение продукта по названию")
    @GetMapping(value = "/announcement/by-product-name/{productName}",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<List<Product>> getProductByProductName(@Parameter(description = "Поиск продукта по названию")
                                                            @PathVariable(value = "productName") String productName,
                                                                 @RequestBody(required = false) ProductDto request) {
        return ResponseEntity.ok(productService.getProductByProductNameService(productName));

    }
/*    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException exception)
    {
        Map<String, Object> errorAttributes = new LinkedHashMap();
        errorAttributes.put("timestamp", LocalDateTime.now());
        errorAttributes.put("status", HttpStatus.BAD_REQUEST);
        errorAttributes.put("error", "Некорректный запрос!");
        return new ResponseEntity<>(errorAttributes, HttpStatus.BAD_REQUEST);
    }*/
}
