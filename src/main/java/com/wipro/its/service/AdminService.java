package com.wipro.its.service;

import com.wipro.its.entity.Admin;

public interface AdminService {

    String loginUser(Admin admin, String type);

    int getIdFromEmail(String email);

    Admin getAdminByEmail(String email);

    String changePassword(String email,String oldPassword,String newPassword,String confirmPassword);


}
