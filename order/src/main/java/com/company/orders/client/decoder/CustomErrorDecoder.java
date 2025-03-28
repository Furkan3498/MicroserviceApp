package com.company.orders.client.decoder;

import com.company.orders.entity.enums.ErrorMessage;
import com.company.orders.exception.CustomFeignException;
import com.company.orders.utils.MapperUtil;
import com.fasterxml.jackson.databind.JsonNode;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

import static com.company.orders.entity.enums.ErrorMessage.CLIENT_ERROR;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        String errorMessage = CLIENT_ERROR.getMessage();


        JsonNode jsonNode;

        try (var body = response.body().asInputStream()){
            jsonNode = MapperUtil.MAPPER_UTIL.map(body, JsonNode.class);


        }catch (Exception exception){
            throw  new CustomFeignException(CLIENT_ERROR.getMessage());
        }

        if (jsonNode.has(JsonNodeFıeldName.MESSAGE.getValue()))
            errorMessage = jsonNode.get(JsonNodeFıeldName.MESSAGE.getValue()).asText();
        return new CustomFeignException(errorMessage);
    }

}
