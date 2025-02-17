package requests.consult;

import com.pedro.medical_consult.domain.Doctor;
import com.pedro.medical_consult.domain.Patient;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class ConsultPutRequestBody {

    @NotNull
    private Long id;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime hour;

    @NotNull
    private Doctor doctor;

    @NotNull
    private Patient patient;

}
