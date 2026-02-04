package com.example.msnegestionmascotas.service;

import com.example.msnegestionmascotas.dto.Headers;
import com.example.msnegestionmascotas.exception.ForbiddenException;
import com.example.msnegestionmascotas.exception.HeaderValidationException;
import com.example.msnegestionmascotas.repository.ApplicationRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class HeaderValidationService {

    private final ApplicationRepository repository;
    private final Validator validator;

    public void validate(Headers headers) {

        Set<ConstraintViolation<Headers>> violations =
                validator.validate(headers);

        if (!violations.isEmpty()) {
            throw new HeaderValidationException(
                    violations.iterator().next().getMessage()
            );
        }

        boolean exists = repository
                .existsByApplicationNameAndApplicationCodeAndConsumerId(
                        headers.applicationName(),
                        headers.applicationCode(),
                        headers.consumerId()
                );

        if (!exists) {
            throw new ForbiddenException(
                    "Aplicación no autorizada para consumir el servicio"
            );
        }
    }
}