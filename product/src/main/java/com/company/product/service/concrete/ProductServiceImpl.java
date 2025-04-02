package com.company.product.service.concrete;

import com.company.product.RequestDto.CreateProductRequest;
import com.company.product.RequestDto.ReduceQuantityRequest;
import com.company.product.entity.ProductEntity;
import com.company.product.exception.InsufficientQuantityException;
import com.company.product.exception.NotFoundException;
import com.company.product.repository.ProductRepository;
import com.company.product.responseDto.ProductResponse;
import com.company.product.responseDto.CommentsDTO;
import com.company.product.service.CommentsServiceImpl;
import com.company.product.service.abstraction.ProductService;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.company.product.entity.enums.ErrorMessage.INSUFFICIENT_QUANTITY;
import static com.company.product.entity.enums.ErrorMessage.PRODUCT_NOT_FOUND;
import static com.company.product.mapper.ProductMapper.PRODUCT_MAPPER;
import static java.lang.String.*;

@Service


public class ProductServiceImpl implements ProductService {

 //   private static final org.slf4j.Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    private final CommentsServiceImpl reviewService;

    public ProductServiceImpl(ProductRepository productRepository,  CommentsServiceImpl reviewService) {
        this.productRepository = productRepository;
        this.reviewService = reviewService;
    }

    @Override
    public void createProduct(CreateProductRequest createProductRequest) {

        productRepository.save(PRODUCT_MAPPER.buildProductEntity(createProductRequest));

    }

    @Override
    public ProductResponse getProductById(Long id) {

       // log.info("product iD BASLADI started");

        List<CommentsDTO> reviewsByProduct = reviewService.getReviewsByProduct(id);


      ProductEntity product = productRepository.findById(id).orElseThrow(()-> new NotFoundException(format(PRODUCT_NOT_FOUND.getMessage(),id)));
       ;
      return PRODUCT_MAPPER.buildProductResponse(product,reviewsByProduct);




    }
    protected ProductEntity getProductByIdForComment(Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
          return product;

        } else {
            String errorMessage = String.format(PRODUCT_NOT_FOUND.getMessage(), id);
            throw new NotFoundException(errorMessage);
        }

    }

    @Override
    public void reduceQuantity(ReduceQuantityRequest reduceQuantityRequest) {
        var productEntity = productRepository.findById(reduceQuantityRequest.getProductId())
                .orElseThrow(() -> new NotFoundException(format(PRODUCT_NOT_FOUND.getMessage(),
                        reduceQuantityRequest.getProductId()
                )));


        if (productEntity.getQuantity() < reduceQuantityRequest.getQuantity())  {

            throw new InsufficientQuantityException(format(INSUFFICIENT_QUANTITY.getMessage(),
                    reduceQuantityRequest.getProductId()    ));
        }



    productEntity.setQuantity(productEntity.getQuantity() -reduceQuantityRequest.getQuantity());
        productRepository.save(productEntity);
    }



    public  List<ProductResponse> getProductAll() throws Exception{
        List<ProductEntity> productList = getProductList();
        return PRODUCT_MAPPER.mapToProductResponseDtoList(productList);
    }
    private  List<ProductEntity> getProductList(){
        return (List<ProductEntity>) productRepository.findAll();
    }



    public List<ProductResponse> getProductByPriceRange(double minPrice, double maxPrice) {
     //   log.info("ProductService::getProductNamesByPriceRange started");

        List<ProductEntity> productList = getProductList();

   //     log.info("ProductService::getProductNamesByPriceRange finished");
        return productList.stream()
                .filter(product -> product.getPrice() != null
                        && product.getPrice().compareTo(BigDecimal.valueOf(minPrice)) >= 0
                        && product.getPrice().compareTo(BigDecimal.valueOf(maxPrice)) <= 0)
                .map(PRODUCT_MAPPER::buildProductResponse)
                .sorted(Comparator.comparing(ProductResponse::getPrice).reversed())
                .collect(Collectors.toList());
    }

    }



