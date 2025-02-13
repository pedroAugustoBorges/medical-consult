package com.pedro.medical_consult.service;

import com.pedro.medical_consult.domain.Doctor;

import java.util.Optional;

public interface DoctorService extends CrudService<Doctor, Long>{

    Doctor findDoctorByCrm (String crm);

}
