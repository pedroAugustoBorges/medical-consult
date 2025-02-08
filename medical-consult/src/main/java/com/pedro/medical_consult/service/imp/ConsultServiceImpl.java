package com.pedro.medical_consult.service.imp;

import com.pedro.medical_consult.domain.Consult;
import com.pedro.medical_consult.repository.ConsultRepository;
import com.pedro.medical_consult.service.ConsultService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultServiceImpl implements ConsultService {

    private final ConsultRepository consultRepository;

    public ConsultServiceImpl(ConsultRepository consultRepository) {
        this.consultRepository = consultRepository;
    }


    @Override
    public Consult save(@Valid Consult entity) {
        if (entity == null){
            throw new IllegalArgumentException("Entity is null");
        }

        return consultRepository.save(entity);

    }

    @Override
    public Optional<Consult> findById(Long id) {

        Consult consult = consultRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Consult not found"));

        return Optional.of(consult);
    }

    @Override
    public void deleteById(Long id) {
        validateId(id);

        if (!existsById(id)){
            throw new EntityNotFoundException("Entity not found");
        }

        consultRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        validateId(id);

        return consultRepository.existsById(id);
    }

    @Override
    public List<Consult> findAll() {
        return consultRepository.findAll();
    }

    @Override
    public List<Consult> findConsultByDoctorIdDoctor(Long idDoctor) {
        return consultRepository.findConsultByDoctorIdDoctor(idDoctor);
    }

    @Override
    public List<Consult> findConsultByPatientIdPatient(Long idPatient) {
        return consultRepository.findConsultByPatientIdPatient(idPatient);
    }

    @Override
    public void deleteConsultByDoctorIdDoctor(Long idDoctor) {
        validateId(idDoctor);

        if (!existsConsultByDoctorIdDoctor(idDoctor)) {
            throw new EntityNotFoundException("Doctor not found");
        }

        consultRepository.deleteConsultByDoctorIdDoctor(idDoctor);
    }

    @Override
    public void deleteConsultByPatientIdPatient(Long idPatient) {
        validateId(idPatient);

        if (!existsConsultByPatientIdPatient(idPatient)) {
            throw new EntityNotFoundException("Patient not found");
        }

        consultRepository.deleteConsultByPatientIdPatient(idPatient);
    }

    private void validateId (Long id){
        if (id == null || id <= 0){
            throw new IllegalArgumentException("Id invalid " + id);
        }
    }

    @Override
    public boolean existsConsultByDoctorIdDoctor(Long idDoctor) {
        validateId(idDoctor);
        return consultRepository.existsConsultByDoctor_IdDoctor(idDoctor);
    }

    @Override
    public boolean existsConsultByPatientIdPatient(Long idPatient) {
        validateId(idPatient);

        return consultRepository.existsConsultByPatientIdPatient(idPatient);
    }

}


