package com.milankascomposer.composerapi.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper=false)
public class ExceptionResponseDTO extends Exception {

    private static final long serialVersionUID = 1L;

    private HttpStatus status;

    public ExceptionResponseDTO(String message) {
        super(message);
    }

    /**
     * Status has to be converted into {@link HttpStatus}
     */
    public void setStatus(String status) {
        this.status = HttpStatus.valueOf(Integer.valueOf(status));
    }

}