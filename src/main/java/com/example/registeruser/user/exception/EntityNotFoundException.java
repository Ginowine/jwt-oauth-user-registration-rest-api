package com.example.registeruser.user.exception;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends ServiceException {

    public EntityNotFoundException(final String message, final Throwable root) {
        super(message, root);
    }

    public EntityNotFoundException(final String message) {
        super(message);
    }
}
