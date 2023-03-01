package com.Hospital.demo.controller;

import com.Hospital.demo.entity.Hospital;
import com.Hospital.demo.exception.ServiceNotFondException;
import com.Hospital.demo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @PostMapping("/save")
    public Hospital saveHospital(@RequestBody Hospital hospital){
        return hospitalService.saveHospitalData(hospital);
    }
    @GetMapping("/get-by-hospitalid/{hospitalId}")
    private Hospital getByHospitalId(@PathVariable Long hospitalId){
        return hospitalService.getByHospitalId(hospitalId);
    }
    @PutMapping("/update-hospital/{hospitalId}")
    private Hospital updateHospital(@PathVariable Long hospitalId, @RequestBody Hospital hospital) throws ServiceNotFondException {
        return  hospitalService.updateHospital(hospitalId,hospital);
    }
}
