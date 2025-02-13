package com.pedro.medical_consult.service.imp;

import com.pedro.medical_consult.domain.Doctor;
import com.pedro.medical_consult.exception.BadRequestException;
import com.pedro.medical_consult.mapper.DoctorMapper;
import com.pedro.medical_consult.repository.DoctorRepository;
import com.pedro.medical_consult.service.DoctorService;
import com.pedro.medical_consult.util.CrmFormatter;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    public Doctor save (DoctorPostRequestBody doctorPostRequestBody) {
        if (doctorPostRequestBody == null){
            throw new EntityNotFoundException("Entity cannot be null");
        }

        Doctor doctor = doctorMapper.toDoctor(doctorPostRequestBody);


        doctor.setCrm(CrmFormatter.formatter(doctor.getCrm()));

        doctorRepository.save(doctor);

        return doctor ;
    }

    @Override
    public Optional<Doctor> findById(Long id) {

        Doctor doctorFounded = doctorRepository.findById(id).orElseThrow(() -> new BadRequestException("Doctor not found"));
        return Optional.of(doctorFounded);
    }


    @Override
    public void deleteById(Long id) {
       validateId(id);
        if (!doctorRepository.existsById(id)){
            throw new EntityNotFoundException("Doctor not found with id " + id);
        }

        doctorRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {

        if (id <= 0) {
            throw new IllegalArgumentException("Id less than 0");
        }
        return doctorRepository.existsById(id);
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> listDoctors = doctorRepository.findAll();

        return listDoctors.isEmpty() ? Collections.emptyList() : listDoctors;
    }

    private void validateId (Long id){
        if (id == null || id <= 0){
            throw new IllegalArgumentException("Id invalid: " + id);
        }
    }
    @Override
    public Doctor findDoctorByCrm(String crm) {
        return doctorRepository.findDoctorByCrm(crm).orElseThrow(() -> new BadRequestException("Doctor not found")) ;
    }

    @Transactional
    public void replace (Doctor doctor){

        if (doctor == null){
            throw new EntityNotFoundException("Entity cannot be null");
        }

        Optional<Doctor> doctorOptional = findById(doctor.getIdDoctor());

        Doctor doctorFounded = doctorOptional.get();

        doctorFounded.setName(doctor.getName());
        doctorFounded.setSpecialization(doctor.getSpecialization());
        doctorFounded.setCrm(doctor.getCrm());

        doctorRepository.save(doctorFounded);

    }

    @Transactional
    public void replace (DoctorPutRequestBody doctorPutRequestBody){

        if (doctorPutRequestBody == null){
            throw new EntityNotFoundException("Entity cannot be null");
        }

        Doctor doctorSaved = findById(doctorPutRequestBody.getIdDoctor()).get();

        Doctor doctor = doctorMapper.toDoctor(doctorPutRequestBody);

        doctor.setIdDoctor(doctorSaved.getIdDoctor());
        doctor.setCrm(CrmFormatter.formatter(doctorSaved.getCrm()));

        doctorRepository.save(doctor);
    }
}
