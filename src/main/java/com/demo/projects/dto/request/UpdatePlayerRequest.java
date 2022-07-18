package com.demo.projects.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class UpdatePlayerRequest {

    @NotNull(message = "Age cannot be null.")
    @Min(value = 5, message = "5 is the minimum player age.")
    @Max(value = 100, message = "5 is the maximum player age.")
    private Integer age;
}
