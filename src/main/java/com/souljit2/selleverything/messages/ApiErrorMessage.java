package com.souljit2.selleverything.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ApiErrorMessage extends ApiResponseMessage {
    private String title;
    private String errorMessage;
}
