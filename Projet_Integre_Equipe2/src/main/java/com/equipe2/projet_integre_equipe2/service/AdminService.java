package com.equipe2.projet_integre_equipe2.service;

import com.equipe2.projet_integre_equipe2.model.Admin;
import com.equipe2.projet_integre_equipe2.repository.AdminRepository;
import com.equipe2.projet_integre_equipe2.repository.SupervisorRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Data
@Service
public class AdminService {

    public AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public Admin login(Admin admin){
       return adminRepository.findAdminByUsernameAndPassword(admin.getUsername(),admin.getPassword());
    }
}