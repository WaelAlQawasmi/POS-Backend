package com.WebPOS.WebPOS.Requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class loginReq {
    String email;
    String password;

}
