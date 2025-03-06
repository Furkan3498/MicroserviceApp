package com.company.product.model.constants;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationConstants {

    private ApplicationConstants(){
        throw  new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
    public static final String PRODUCT_ID_IS_REQUIRED="Product id is required";
    public static final String NAME_IS_REQUIRED = "Name is required";
    public static final String NAME_IS_Description = "Description is required";
    public static final String NAME_IS_Price= "Price is required";
    public static final String NAME_IS_Quantity = "Quantity is required";
    public static final String QUANTITIY_IS_REQUIRED = "Quantity is required";

}
