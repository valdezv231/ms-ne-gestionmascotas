package com.example.msnegestionmascotas.interceptor;

import com.example.msnegestionmascotas.dto.header.AnimalHeaders;
import com.example.msnegestionmascotas.service.HeaderValidationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class HeaderValidationInterceptor implements HandlerInterceptor {

    private final HeaderValidationService headerValidationService;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) {

        AnimalHeaders headers = new AnimalHeaders(
                request.getHeader("Id-Transaccion"),
                request.getHeader("Application-Name"),
                request.getHeader("Application-Code"),
                request.getHeader("Consumer-Id")
        );
        headerValidationService.validate(headers);

        return true;
    }
}
