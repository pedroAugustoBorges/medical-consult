package requests.consult;

import com.pedro.medical_consult.domain.Doctor;
import com.pedro.medical_consult.domain.Patient;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConsultPostRequestBody {

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime hour;

    @NotNull
    private Doctor doctor;

    @NotNull
    private Patient patient;
}
