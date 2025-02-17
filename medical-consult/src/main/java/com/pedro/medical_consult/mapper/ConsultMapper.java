package com.pedro.medical_consult.mapper;

import com.pedro.medical_consult.domain.Consult;
import org.mapstruct.Mapper;
import requests.consult.ConsultPostRequestBody;
import requests.consult.ConsultPutRequestBody;

@Mapper
public abstract class ConsultMapper {

    public abstract Consult toConsult (ConsultPostRequestBody consultPostRequestBody);

    public abstract Consult toConsult (ConsultPutRequestBody consultPutRequestBody);
}
