package co.com.pragma.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
@JsonDeserialize
public class CompensationPlan implements Cloneable {
    private Long id;
    private String title;
    private Double selfCompensation;
    private Double additionalEarning;

    /*
     * This implementation is a simile with Prototype pattern
     * Review this post: https://refactoring.guru/es/design-patterns/prototype
     */
    @Override
    public CompensationPlan clone() throws CloneNotSupportedException
    {
        return (CompensationPlan) super.clone();
    }
}
