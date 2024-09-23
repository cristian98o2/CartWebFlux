package co.com.pragma.router.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class FieldModelErrorsDtos {
    private String type;
    private List<String> ids;
}
