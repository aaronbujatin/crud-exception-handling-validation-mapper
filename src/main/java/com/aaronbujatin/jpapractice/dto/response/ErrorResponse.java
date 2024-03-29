package com.aaronbujatin.jpapractice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ErrorResponse {

    private final String message;
    private final List<String> details;

}
