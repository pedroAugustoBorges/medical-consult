package requests.patient;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class PatientPostRequestBody {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String cpf;

    @NotBlank
    private String telephone;


    @NotBlank
    private String zipcode;

    @NotBlank
    private Long numberStreet;

    @NotBlank
    private String street;


}
