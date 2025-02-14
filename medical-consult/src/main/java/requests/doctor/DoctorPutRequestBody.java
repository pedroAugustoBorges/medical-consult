package requests.doctor;

import com.pedro.medical_consult.domain.enumeration.Specialization;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @NotNull

    private Specialization specialization;
}
