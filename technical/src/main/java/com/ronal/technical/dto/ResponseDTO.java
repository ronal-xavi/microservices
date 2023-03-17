package com.ronal.technical.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ResponseDTO<T> {
    private Boolean success;
    private String error;
    private String message;
    private T response;
    private Integer statusCode;
}
