package com.equipe2.projet_integre_equipe2.service;

import com.equipe2.projet_integre_equipe2.model.Admin;
import com.equipe2.projet_integre_equipe2.model.Monitor;
import com.equipe2.projet_integre_equipe2.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService;

    public Admin admin;

    @BeforeEach
    void setup(){
         admin = Admin.adminBuilder()
                .username("username")
                .password("password")
                .build();
    }

    @Test
    public void testLoginAdmin(){
        when(adminRepository.findAdminByUsernameAndPassword(admin.getUsername(), admin.getPassword())).thenReturn(admin);
        Admin actualAdmin = adminService.login(admin);
        assertThat(actualAdmin.equals(admin));
    }
}