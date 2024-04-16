package com.github.kokecena.gestioncontactos.controller;

import com.github.kokecena.gestioncontactos.commons.ValidationUtil;
import com.github.kokecena.gestioncontactos.commons.response.Response;
import com.github.kokecena.gestioncontactos.commons.response.ResponseMessage;
import com.github.kokecena.gestioncontactos.exceptions.ContactoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final Map<String, String> constraintsDb;

    @ExceptionHandler(ContactoNotFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseMessage> handleContactoNotFound(ContactoNotFoundException ex) {
        return Response.of(HttpStatus.OK)
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler({NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseMessage> handleNotFoundException(ServletException ex) {
        return Response.of(HttpStatus.NOT_FOUND)
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Response<List<String>>> handleMethodArgumentException(MethodArgumentNotValidException ex) {
        return Response.of(ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()), HttpStatus.CONFLICT)
                .message("Valores no validos")
                .build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Response<String>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String rootMsg = ValidationUtil.getRootCause(ex).getMessage().replace("\n", "");
        if (rootMsg.isEmpty()) {
            return Response.of(ex.getMessage(), HttpStatus.CONFLICT)
                    .message("A ocurrido una excepción")
                    .build();
        }
        String lowerCaseMsg = rootMsg.toLowerCase();
        return constraintsDb.entrySet().stream()
                .filter(constraintMsgEntry -> {
                    String key = constraintMsgEntry.getKey().toLowerCase();
                    return lowerCaseMsg.contains(key);
                }).findFirst()
                .map(entry -> Response.of(entry.getValue(), HttpStatus.CONFLICT))
                .orElse(Response.of(rootMsg, HttpStatus.CONFLICT))
                .message("Ocurrio un conflicto")
                .build();
    }

}