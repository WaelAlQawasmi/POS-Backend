package com.WebPOS.WebPOS.Requests;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class loginRes {
    @NonNull
    private String email;
    @NonNull
    private String token;
}
