package com.example.dockertest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "customer_tbl")
public class CustEntity extends BaseEntity{

    private String name;

    private String icNo;

    private String email;

    private String address;

    public CustEntity() {
    }

    public CustEntity(String name, String icNo, String email, String address) {
        this.name = name;
        this.icNo = icNo;
        this.email = email;
        this.address = address;
    }
}
