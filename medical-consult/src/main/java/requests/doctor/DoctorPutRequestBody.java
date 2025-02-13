package requests.doctor;

import com.pedro.medical_consult.domain.enumeration.Specialization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DoctorPutRequestBody {

    @NotNull
    private Long idDoctor;

    @NotBlank
    private String name;

    @NotBlank
    private String crm;

    @NotBlank
    private Specialization specialization;
}
