package com.WebPOS.WebPOS.Requests;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@RequiredArgsConstructor
@Data
public class ErrorRes {
    @NonNull
    HttpStatus httpStatus;
    @NonNull
    String message;

}
