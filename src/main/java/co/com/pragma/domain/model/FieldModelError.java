package co.com.pragma.domain.model;

import java.io.Serial;
import java.io.Serializable;

public record FieldModelError(String field, String error) implements Serializable {
    @Serial
    private static final long serialVersionUID = 3708567824775716466L;
}