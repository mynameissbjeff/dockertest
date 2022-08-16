package com.example.dockertest.controller;

import com.example.dockertest.model.CustDTO;
import com.example.dockertest.model.CustEntity;
import com.example.dockertest.repository.CustRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class DockertestCtrl {

    private static final Logger logger = LogManager.getLogger(DockertestCtrl.class);

    @Autowired
    CustRepository custRepository;

    @RequestMapping("/")
    public String home() {
        return "Welcome to Docker World";
    }

    @GetMapping("/more")
    public String more(){
        return "No More for now.";
    }


    @PostMapping("/cust/add")
    public CustEntity addCustomer(@RequestBody CustDTO request){

        logger.debug("Start Add Customer with Request:{}",request);

        CustEntity custEntity = new CustEntity(request.getName(),request.getIcNo(),request.getEmail(),request.getAddress());
        custRepository.save(custEntity);

        List<CustEntity> entityList = custRepository.findByIcNo(request.getIcNo());
        CustEntity responseEntity = null;
        if(!entityList.isEmpty()){
            responseEntity = entityList.get(0);
        }

        logger.debug("End Add Customer with Response:{}",responseEntity);

        return responseEntity;
    }

    @PostMapping("/cust/update")
    public CustEntity updateCust(@RequestBody CustDTO request){

        List<CustEntity> entityList = custRepository.findByIcNo(request.getIcNo());
        if(entityList.isEmpty()){
            return null;
        }
        CustEntity custEntity = entityList.get(0);
        custEntity.setName(request.getName());
        custEntity.setEmail(request.getEmail());
        custEntity.setAddress(request.getAddress());

        custRepository.save(custEntity);

        return custEntity;
    }
}
