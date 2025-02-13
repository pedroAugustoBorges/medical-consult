package requests.doctor;

import com.pedro.medical_consult.domain.enumeration.Specialization;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DoctorPostRequestBody {

    @NotBlank
    private String name;

    @NotBlank
    private String crm;

    @NotBlank
    private Specialization specialization;
}
