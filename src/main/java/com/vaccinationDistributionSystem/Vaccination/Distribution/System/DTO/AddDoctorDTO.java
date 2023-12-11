package com.vaccinationDistributionSystem.Vaccination.Distribution.System.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE) // creates all the data types as private
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddDoctorDTO {

    String name;
    String degree;
}
