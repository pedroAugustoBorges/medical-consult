package requests.doctor;

import com.pedro.medical_consult.domain.enumeration.Specialization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class DoctorPostRequestBody {

    @NotBlank
    private String name;

    @NotBlank
    private String crm;

    @NotNull
    private Specialization specialization;
}
