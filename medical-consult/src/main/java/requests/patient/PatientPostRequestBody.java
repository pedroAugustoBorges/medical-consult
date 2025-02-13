package requests.patient;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PatientPostRequestBody {

    @JsonProperty("numberStreet")
    @NotNull(message = "The number street cannot be empty ")
    private Long numberStreet;

    @NotBlank(message = "The name cannot be empty ")
    private String name;

    @Email
    @NotBlank(message = "The email cannot be empty ")
    private String email;

    @NotBlank(message = "The cpf cannot be empty ")
    private String cpf;

    @NotBlank(message = "The telephone cannot be empty ")
    private String telephone;

    @NotBlank(message = "The zipcode cannot be empty ")
    private String zipcode;

    @NotBlank(message = "The street cannot be empty ")
    private String street;


}
