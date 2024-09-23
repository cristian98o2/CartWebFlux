package co.com.pragma.router.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class AppliedDiscountResponseDto {
    private String name;
    private List<ActionResponseDto> actions;
}
