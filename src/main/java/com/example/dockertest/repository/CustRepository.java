package com.example.dockertest.repository;

import com.example.dockertest.model.CustEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustRepository extends CrudRepository<CustEntity, UUID> {

    public List<CustEntity> findByName(String name);

    public List<CustEntity> findByIcNo(String icNo);

}
