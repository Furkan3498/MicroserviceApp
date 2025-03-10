package com.company.orders.client.decoder;

import com.company.orders.entity.enums.ErrorMessage;
import com.company.orders.exception.CustomFeignException;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();
    @Override
    public Exception decode(String s, Response response) {
        if (response.status() >= 400 && response.status()<=499){
            return new CustomFeignException(ErrorMessage.CLIENT_ERROR.getMessage());
        }
        if (response.status() >=500  && response.status() <=599){
            return  new CustomFeignException(ErrorMessage.SERVER_ERROR_DECODER.getMessage());
        }
        return defaultErrorDecoder.decode(s,response);
    }
}
