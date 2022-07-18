package com.demo.projects.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@SuperBuilder
public class PlayerDTO {

    @NotNull(message = "Age cannot be null.")
    @Min(value = 5, message = "5 is the minimum player age.")
    @Max(value = 100, message = "100 is the maximum player age.")
    private Integer age;

    @Past(message = "Date of birth cannot be now or in the future.")
    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;
}
