package com.example.dockertest.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CustDTO {

    public String name;
    public String icNo;
    public String email;
    public String address;

}
