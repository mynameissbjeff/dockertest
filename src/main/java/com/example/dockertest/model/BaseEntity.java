package com.example.dockertest.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String modifyBy;

    private LocalDateTime modifyTime;

    private String createBy;

    private LocalDateTime createTime;

    private String version;

    @PrePersist
    public void preCreate(){
        createTime = LocalDateTime.now();
        createBy = "System";
    }

    @PreUpdate
    public void preUpdate(){
        modifyTime = LocalDateTime.now();
        modifyBy = "System123";
    }

}
