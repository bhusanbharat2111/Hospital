package com.Hospital.demo.service;

import com.Hospital.demo.entity.Hospital;
import com.Hospital.demo.exception.ServiceNotFondException;
import org.springframework.stereotype.Service;

@Service
public interface HospitalService {
    Hospital saveHospitalData(Hospital hospital);

    Hospital getByHospitalId(Long hospitalId);

    Hospital updateHospital(Long hospitalId, Hospital hospital) throws ServiceNotFondException;

    Hospital addData(Hospital hospital);
}
