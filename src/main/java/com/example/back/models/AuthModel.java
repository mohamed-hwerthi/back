package com.example.back.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthModel {
     public String client_id;
     public String client_secret ;
     public String code ;
}
