package com.staffing.dto;

import com.staffing.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthResponse {
    private User user;
    private String accessToken;
}
