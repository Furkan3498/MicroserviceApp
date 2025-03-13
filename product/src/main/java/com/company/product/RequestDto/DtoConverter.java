package com.company.product.RequestDto;


import com.company.product.entity.CommentEntity;
import com.company.product.responseDto.CommentResponse;
import org.springframework.stereotype.Component;


@Component
public class DtoConverter {



    public CommentResponse convert(CommentEntity commentEntity){
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setText(commentEntity.getText());
        commentResponse.setId(commentEntity.getId());
        commentResponse.setProductId(commentEntity.getProductId());

        return commentResponse;
    }
}
