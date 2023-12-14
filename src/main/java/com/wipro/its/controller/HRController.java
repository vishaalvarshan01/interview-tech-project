package com.wipro.its.controller;

import com.wipro.its.entity.Admin;
import com.wipro.its.entity.Candidate;
import com.wipro.its.entity.CandidateRating;
import com.wipro.its.service.AdminService;
import com.wipro.its.service.CandidateRatingService;
import com.wipro.its.service.CandidateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/hr")
public class HRController {

    @Autowired
    AdminService adminService;

    @Autowired
    CandidateService candidateService;

    @Autowired
    CandidateRatingService candidateRatingService;

    @GetMapping("/login")
    public String getIndexPage(){
        return "hrLogin";
    }

    @PostMapping("/loginUser")
    public String loginHr(@ModelAttribute("user") Admin admin, Model model,HttpSession session){
        // validate hr login
        admin.setType("hr");
        String login = adminService.loginUser(admin,"hr");

        if(login.equals("success")){
            session.setAttribute("email",admin.getEmail());
            return "hrWelcome";
        }
        model.addAttribute("msg",login);
        return "hrLogin";
    }

    @GetMapping("/hrWelcome")
    public String getWelcomePage(HttpSession session){
        String email = (String) session.getAttribute("email");
        if(email==null){
            return "/hrLogin";
        }
        return "hrWelcome";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session){
        session.invalidate();
        return "hrLogin";
    }

    @GetMapping("/viewCandidates")
    public String getAllCandidates(HttpSession session, HttpServletRequest request){
        String email = (String) session.getAttribute("email");

        if(email==null){
            return "/hrLogin";
        }

        int id = adminService.getIdFromEmail(email);
        List<Candidate> candidates = candidateService.getAllCandidates(id);
        request.setAttribute("candidates",candidates);
        return "viewHrCandidates";
    }

    @GetMapping("/rateCandidate/{id}")
    public String getCandidateRatingsPage(@PathVariable("id") int candidateId, HttpSession session){
        String email = (String) session.getAttribute("email");
        if(email==null){
            return "/hrLogin";
        }
        return "hrRateCandidate";
    }

    @PostMapping("/submitRating/{id}")
    public String submitCandidateRating(@PathVariable("id") int id,@ModelAttribute("rating")CandidateRating rating,HttpSession session){
        System.out.println("rating : " + rating);
        String email = (String) session.getAttribute("email");
        System.out.println("id : " + id);

        Optional<Candidate> _candidate = candidateService.findById(id);
        Candidate candidate = null;
        if(_candidate.isPresent()){
            candidate = _candidate.get();
        }
        rating.setCandidate(candidate);
        rating.setRated(true);
        candidateRatingService.saveCandidateRating(rating);
        return "redirect:/hr/viewCandidates";
    }

    @GetMapping("/changePassword")
    public String getChangePasswordPage(HttpSession session){
        String email = (String) session.getAttribute("email");
        if(email==null){
            return "/hrLogin";
        }
        return "changePassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(HttpServletRequest request,HttpSession session,Model model){

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        System.out.println(newPassword + " " + confirmPassword);

        String email = (String) session.getAttribute("email");

        String result = adminService.changePassword(email,oldPassword,newPassword,confirmPassword);
        if(result.equals("success")){
            model.addAttribute("msg","password successfully changed");
            return "changePassword";
        }
        model.addAttribute("msg",result);
        return "changePassword";
    }
}
