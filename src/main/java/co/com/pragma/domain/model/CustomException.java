package co.com.pragma.domain.model;

import java.io.Serial;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 3508567824775716466L;
    private final ResponseCode responseCode;
    private final List<FieldModelError> fieldModelErrors;

    public CustomException(ResponseCode responseCode, String... params) {
        super(MessageFormat.format(responseCode.getHtmlMessage(), (Object[]) params));
        this.responseCode = responseCode;
        this.fieldModelErrors = new ArrayList<>();
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public List<FieldModelError> getFieldErrors() {
        return fieldModelErrors;
    }

    public void addFieldError(FieldModelError fieldModelError) {
        this.fieldModelErrors.add(fieldModelError);
    }
}
