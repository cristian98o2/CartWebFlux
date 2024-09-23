package co.com.pragma.router.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ActionResponseDto {
    private String application;
    private String discountType;
    private String operation;
    private BigDecimal value;
}
