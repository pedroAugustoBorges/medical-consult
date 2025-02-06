package com.pedro.medical_consult.service.imp;

import com.pedro.medical_consult.domain.Doctor;
import com.pedro.medical_consult.repository.DoctorRepository;
import com.pedro.medical_consult.service.DoctorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;


    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor save(Doctor entity) {
        if (entity == null){
            throw new IllegalArgumentException("Exception throw because doctor is null ");
        }
        return doctorRepository.save(entity);
    }

    @Override
    public Optional<Doctor> findById(Long id) {

        Doctor doctorFounded = doctorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Exception throw because doctor is not found"));
        return Optional.of(doctorFounded);
    }

    @Override
    public void delete(Doctor entity) {
        if (entity == null){
            throw new IllegalArgumentException("Exception throw because doctor is null ");
        }
        doctorRepository.delete(entity);
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
}
