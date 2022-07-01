package com.staffing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRequest {
    @NotNull
    private String email;
    @Length(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    @NotNull
    private String password;
}
