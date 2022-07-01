package com.staffing.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.staffing.admin.entity.Admin;
import com.staffing.admin.service.AdminService;
import com.staffing.exceptions.EmailAlreadyExistsException;
import com.staffing.role.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private AdminService adminService;

    @Test
    void testAddAdminValid() throws Exception {
        String password = "azer2022";
        String email = "azer@azer.com";
        String firstName = "Azer";
        String lastName = "Chabbar";
        ArrayList<Role> roles = new ArrayList<>();
        Admin admin = new Admin(email, password, firstName, lastName, roles);
        when(adminService.addAdmin(admin)).thenReturn(admin);
        mockMvc.perform(MockMvcRequestBuilders.post("/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(admin)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testInvalidPasswordLength() throws Exception {
        String password = "azer202";
        String email = "azer@azer.com";
        String firstName = "Azer";
        String lastName = "Chabbar";
        ArrayList<Role> roles = new ArrayList<>();
        Admin admin = new Admin(email, password, firstName, lastName, roles);
        when(adminService.addAdmin(admin)).thenReturn(admin);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(admin)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}