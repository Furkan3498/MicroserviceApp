package com.company.product.client.decoder;

import com.company.product.exception.CustomExcepiton;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();
    @Override
    public Exception decode(String s, Response response) {
        if (response.status() >= 400 && response.status()<=499){
            return new CustomExcepiton("Client error occurred while making the request");
        }
        if (response.status() >=500  && response.status() <=599){
            return  new CustomExcepiton("Server error occurred while making the request");
        }
        return defaultErrorDecoder.decode(s,response);
    }
}
