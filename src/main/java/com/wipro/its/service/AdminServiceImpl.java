package com.wipro.its.service;

import com.wipro.its.entity.Admin;
import com.wipro.its.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository adminRepository;
    @Override
    public String loginUser(Admin admin, String type) {
        Admin dbAdmin = adminRepository.findByEmail(admin.getEmail());
        if(dbAdmin == null){
            return "User not found";
        }
        if(!dbAdmin.getType().equals(type)){
            return "Login UnAuthorized";
        }
        if(!admin.getPassword().equals(dbAdmin.getPassword())){
            return "wrong credentials";
        }
        return "success";
    }

    @Override
    public int getIdFromEmail(String email) {
        Admin admin = adminRepository.findByEmail(email);
        System.out.println("from service : " + admin);
        return admin.getId();
    }

    @Override
    public Admin getAdminByEmail(String email){
        return adminRepository.findByEmail(email);
    }

    @Override
    public String changePassword(String email,String oldPassword, String newPassword, String confirmPassword) {
        Admin admin = adminRepository.findByEmailAndPassword(email,oldPassword);
        if(admin == null){
            return "User not found";
        }
        if(!newPassword.equals(confirmPassword)){
            return "passwords do not match";
        }
        admin.setPassword(newPassword);
        adminRepository.save(admin);
        return "success";
    }
}
