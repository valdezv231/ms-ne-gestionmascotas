package com.example.msnegestionmascotas.service;

import com.example.msnegestionmascotas.dto.header.AnimalHeaders;
import com.example.msnegestionmascotas.entity.ApplicationEntity;
import com.example.msnegestionmascotas.exception.ForbiddenException;
import com.example.msnegestionmascotas.repository.ApplicationRepository;
import com.example.msnegestionmascotas.repository.ConsumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeaderValidationService {

    private final ApplicationRepository applicationRepository;
    private final ConsumerRepository consumerRepository;

    public void validate(AnimalHeaders headers) {

        ApplicationEntity app = applicationRepository
                .findByApplicationCodeAndEnabledTrue(headers.applicationCode())
                .orElseThrow(() -> new ForbiddenException(
                        "Application-Code no autorizado"
                ));

        if (!app.getApplicationName().equals(headers.applicationName())) {
            throw new ForbiddenException("Application-Name no coincide");
        }

        consumerRepository
                .findByConsumerIdAndEnabledTrue(headers.consumerId())
                .orElseThrow(() -> new ForbiddenException(
                        "Consumer-Id no autorizado"
                ));
    }
}

