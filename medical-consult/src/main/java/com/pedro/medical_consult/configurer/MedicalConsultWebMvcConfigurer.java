package com.pedro.medical_consult.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MedicalConsultWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver = new PageableHandlerMethodArgumentResolver();

//        Sort sortByCrm = Sort.by(Sort.Direction.ASC, "crm");

        pageableHandlerMethodArgumentResolver.setFallbackPageable(PageRequest.of(0, 5));

        resolvers.add(pageableHandlerMethodArgumentResolver);
    }
}
