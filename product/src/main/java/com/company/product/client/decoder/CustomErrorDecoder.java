package com.company.product.client.decoder;

import com.company.product.entity.enums.ErrorMessage;
import com.company.product.exception.CustomFeignExcepiton;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();
    @Override
    public Exception decode(String s, Response response) {
        if (response.status() >= 400 && response.status()<=499){
            return new CustomFeignExcepiton(ErrorMessage.CLIENT_ERROR.getMessage());
        }
        if (response.status() >=500  && response.status() <=599){
            return  new CustomFeignExcepiton(ErrorMessage.SERVER_ERROR_DECODER.getMessage());
        }
        return defaultErrorDecoder.decode(s,response);
    }
}
