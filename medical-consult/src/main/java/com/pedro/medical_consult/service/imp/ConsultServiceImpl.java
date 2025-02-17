package com.pedro.medical_consult.service.imp;

import com.pedro.medical_consult.domain.Consult;
import com.pedro.medical_consult.exception.BadRequestException;
import com.pedro.medical_consult.mapper.ConsultMapper;
import com.pedro.medical_consult.repository.ConsultRepository;
import com.pedro.medical_consult.service.ConsultService;
import com.pedro.medical_consult.validations.ValidationId;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import requests.consult.ConsultPostRequestBody;
import requests.consult.ConsultPutRequestBody;

import java.util.Optional;


@Service
public class ConsultServiceImpl implements ConsultService {

    private final ConsultRepository consultRepository;

    private final ConsultMapper consultMapper;

    public ConsultServiceImpl(ConsultRepository consultRepository, ConsultMapper consultMapper) {
        this.consultRepository = consultRepository;
        this.consultMapper = consultMapper;
    }

    @Override
    public Consult save(Consult consult) {
        if (consult == null){
            throw new IllegalArgumentException("Entity is null");
        }

        return consultRepository.save(consult);

    }

    public Consult save(ConsultPostRequestBody consultPostRequestBody) {
        if (consultPostRequestBody == null){
            throw new IllegalArgumentException("Entity is null");
        }

        Consult consult = consultMapper.toConsult(consultPostRequestBody);

        return consultRepository.save(consult);

    }

    @Override
    public Consult findById(Long id) {
        return consultRepository.findById(id).orElseThrow(() -> new BadRequestException("Consult not found"));
    }

    @Override
    public void deleteById( @ValidationId Long id) {

        if (!existsById(id)){
            throw new EntityNotFoundException("Entity not found");
        }

        consultRepository.deleteById(id);
    }

    @Override
    public boolean existsById( @ValidationId Long id) {
        return consultRepository.existsById(id);
    }

    @Override
    public Page<Consult> findAll(Pageable pageable) {
        return consultRepository.findAll(pageable);
    }

    @Override
    public Page<Consult> findConsultByDoctorIdDoctor( @ValidationId Long idDoctor, Pageable pageable) {
        return consultRepository.findConsultByDoctorIdDoctor(idDoctor, pageable);
    }

    @Override
    public Page<Consult> findConsultByPatientIdPatient( @ValidationId Long idPatient, Pageable pageable) {
        return consultRepository.findConsultByPatientIdPatient(idPatient, pageable);
    }

    @Override
    public void deleteConsultByDoctorIdDoctor( @ValidationId Long idDoctor) {

        if (!existsConsultByDoctorIdDoctor(idDoctor)) {
            throw new EntityNotFoundException("Doctor not found");
        }

        consultRepository.deleteConsultByDoctorIdDoctor(idDoctor);
    }

    @Override
    public void deleteConsultByPatientIdPatient( @ValidationId Long idPatient) {
        if (!existsConsultByPatientIdPatient(idPatient)) {
            throw new EntityNotFoundException("Patient not found");
        }

        consultRepository.deleteConsultByPatientIdPatient(idPatient);
    }


    @Override
    public boolean existsConsultByDoctorIdDoctor( @ValidationId Long idDoctor) {
        return consultRepository.existsConsultByDoctor_IdDoctor(idDoctor);
    }

    @Override
    public boolean existsConsultByPatientIdPatient ( @ValidationId Long idPatient) {
        return consultRepository.existsConsultByPatientIdPatient(idPatient);
    }

    @Override
    public Consult updateConsultPatch( @ValidationId  Long id, ConsultPutRequestBody consultPutRequestBody) {
        Consult consult = consultRepository.findById(id).orElseThrow(() -> new BadRequestException("Consult not found"));

        if (consultPutRequestBody.getDate() != null){
            consult.setLocalDate(consultPutRequestBody.getDate());
        }

        if (consultPutRequestBody.getDoctor() != null) {
            consult.setDoctor(consultPutRequestBody.getDoctor());
        }

        if (consultPutRequestBody.getPatient() != null) {
            consult.setPatient(consultPutRequestBody.getPatient());
        }

        if (consultPutRequestBody.getHour() != null) {
            consult.setLocalTime(consultPutRequestBody.getHour());
        }

       return consultRepository.save(consult);
    }
}


