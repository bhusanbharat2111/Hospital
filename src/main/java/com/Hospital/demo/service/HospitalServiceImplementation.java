package com.Hospital.demo.service;

import com.Hospital.demo.entity.Hospital;
import com.Hospital.demo.exception.ServiceNotFondException;
import com.Hospital.demo.repo.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class HospitalServiceImplementation implements HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public Hospital saveHospitalData(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
    @Override
    public Hospital getByHospitalId(Long hospitalId) {
        return hospitalRepository.getById(hospitalId);
    }
    @Override
    public Hospital updateHospital(Long hospitalId, Hospital hospital) throws ServiceNotFondException {
        Hospital hospitalDatabase = hospitalRepository.findById(hospitalId).get();
        if (Objects.isNull(hospitalDatabase)){
            throw new ServiceNotFondException("Hospital not found ");
        }
        if (Objects.nonNull(hospital.getHospitalName())) {
            hospitalDatabase.setHospitalName((hospital.getHospitalName()));
        }
        if (Objects.nonNull(hospital.getCity())) {
            hospitalDatabase.setCity(hospital.getCity());
        }
        return hospitalRepository.save(hospitalDatabase);
    }

    @Override
    public Hospital addData(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
}
