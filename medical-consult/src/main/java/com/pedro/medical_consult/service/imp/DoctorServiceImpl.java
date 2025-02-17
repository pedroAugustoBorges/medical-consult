package com.pedro.medical_consult.service.imp;

import com.pedro.medical_consult.domain.Doctor;
import com.pedro.medical_consult.exception.BadRequestException;
import com.pedro.medical_consult.mapper.DoctorMapper;
import com.pedro.medical_consult.repository.DoctorRepository;
import com.pedro.medical_consult.service.DoctorService;
import com.pedro.medical_consult.util.CrmFormatter;
import com.pedro.medical_consult.validations.ValidationId;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import requests.doctor.DoctorPostRequestBody;
import requests.doctor.DoctorPutRequestBody;

import java.util.*;

@Service

public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;


    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Transactional
    @Override
    public Doctor save(Doctor entity) {
        if (entity == null){
            throw new IllegalArgumentException("Exception throw because doctor is null ");
        }
        return doctorRepository.save(entity);
    }

    @Transactional
    public Doctor save ( @Valid DoctorPostRequestBody doctorPostRequestBody) {
        if (doctorPostRequestBody == null){
            throw new EntityNotFoundException("Entity cannot be null");
        }

        System.out.println(doctorPostRequestBody);

        Doctor doctor = doctorMapper.toDoctor(doctorPostRequestBody);


        System.out.println(doctor);

        doctor.setCrm(CrmFormatter.formatter(doctor.getCrm()));



        doctorRepository.save(doctor);

        return doctor ;
    }

    @Override
    public Doctor findById( @ValidationId Long id) {

        return doctorRepository.findById(id).orElseThrow(() -> new BadRequestException("Doctor not found")) ;
    }

    @Override
    public void deleteById( @ValidationId Long id) {
        if (!doctorRepository.existsById(id)){
            throw new EntityNotFoundException("Doctor not found with id " + id);
        }

        doctorRepository.deleteById(id);
    }

    @Override
    public boolean existsById( @ValidationId Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id less than 0");
        }
        return doctorRepository.existsById(id);
    }

    @Override
    public Page<Doctor> findAll(Pageable pageable) {

        return doctorRepository.findAll(pageable);
    }

    @Override
    public Doctor findDoctorByCrm(String crm) {
        return doctorRepository.findDoctorByCrm(CrmFormatter.formatter(crm)).orElseThrow(() -> new BadRequestException("Doctor not found")) ;
    }

    @Transactional
    public void replace (Doctor doctor){

        if (doctor == null){
            throw new EntityNotFoundException("Entity cannot be null");
        }

        Doctor doctorFounded = findById(doctor.getIdDoctor());

        doctorFounded.setName(doctor.getName());
        doctorFounded.setSpecialization(doctor.getSpecialization());
        doctorFounded.setCrm(CrmFormatter.formatter(doctor.getCrm()));

        doctorRepository.save(doctorFounded);

    }

    @Transactional
    public void replace (DoctorPutRequestBody doctorPutRequestBody){

        if (doctorPutRequestBody == null){
            throw new EntityNotFoundException("Entity cannot be null");
        }

        Doctor doctorSaved = findById(doctorPutRequestBody.getIdDoctor());


        Doctor doctor = doctorMapper.toDoctor(doctorPutRequestBody);


        doctor.setIdDoctor(doctorSaved.getIdDoctor());

        doctor.setCrm(CrmFormatter.formatter(doctor.getCrm()));


        doctorRepository.save(doctor);
    }
}
