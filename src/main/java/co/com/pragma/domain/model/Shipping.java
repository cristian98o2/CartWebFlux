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
public class Shipping {
    private Long id;
    private String name;
    private String lastName;
    private String documentNumber;
    private String documentType;
    private String email;
    private String cellPhone;
    private String longitude;
    private String latitude;
    private String zip;
    private String address;
    private String city;
    private String state;
    private String country;
    private String detail;
    private String idCart;
}
