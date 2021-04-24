package com.souljit2.selleverything.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ApiSuccessMessage<T> extends ApiResponseMessage {
    private String title;
    private String message;
    private T data;
}
