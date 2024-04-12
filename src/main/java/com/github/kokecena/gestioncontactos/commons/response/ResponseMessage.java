package com.github.kokecena.gestioncontactos.commons.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ResponseMessage extends Response<Void> {

    protected ResponseMessage(String message, int code, Void data) {
        super(message, code, data);
    }

    public static class Builder {

        private String message;
        private final HttpStatus status;

        protected Builder(HttpStatus status) {
            this.status = status;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ResponseEntity<ResponseMessage> build() {
            return new ResponseEntity<>(new ResponseMessage(getMessage(), status.value(), null), status);
        }

        private String getMessage() {
            return Optional.ofNullable(message).orElseGet(status::getReasonPhrase);
        }

    }
}
