package com.github.kokecena.gestioncontactos.commons.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
public class Response<T> implements Serializable {

    private final String message;
    private final int code;
    private final LocalDateTime timestamp;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private final T data;

    protected Response(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ResponseEntity<Response<T>> success(T data) {
        HttpStatus status = HttpStatus.OK;
        return Response.of(data, status)
                .build();
    }


    public static <T> Builder<T> of(T data, HttpStatus status) {
        return new Builder<>(data, status);
    }

    public static ResponseMessage.Builder of(HttpStatus status) {
        return new ResponseMessage.Builder(status);
    }

    public static class Builder<T> {

        private String message;
        private final HttpStatus status;
        private final T response;

        private Builder(T response, HttpStatus status) {
            this.response = response;
            this.status = status;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public ResponseEntity<Response<T>> build() {
            return new ResponseEntity<>(new Response<>(getMessage(), status.value(), response), status);
        }

        private String getMessage() {
            return Optional.ofNullable(message).orElseGet(status::getReasonPhrase);
        }

    }

}