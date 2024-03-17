package com.axsos.javaexam.controllers;

import com.axsos.javaexam.models.Team;
import com.axsos.javaexam.models.User;
import com.axsos.javaexam.models.LoginUser;
import com.axsos.javaexam.services.TeamService;
import com.axsos.javaexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    private final UserService userServ;
    private final TeamService teamService;

    public HomeController(UserService userServ, TeamService teamService) {
        this.userServ = userServ;
        this.teamService = teamService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            return "redirect:/home";
        }
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {
        User regUser = userServ.register(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }
        session.setAttribute("user_id", regUser.getId());
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {
        User logUser = userServ.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
        session.setAttribute("user_id", logUser.getId());
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String success(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userServ.findUserById(userId);
            List<Team> allteam = teamService.allTeams();
            model.addAttribute("currentUser", currentUser);
            model.addAttribute("allteam", allteam);
            return "success.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/teams/new")
    public String addTeam(Model model, HttpSession session, @ModelAttribute("team") Team team) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long) session.getAttribute("user_id");
            User user = userServ.findUserById(userId);
            model.addAttribute("user", user);
            return "index.jsp";
        }
        return "redirect:/";

    }

    @PostMapping("/teams/new")
    public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        }
        teamService.createTeam(team);
        return "redirect:/home";
    }


    @GetMapping("/teams/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
        Team team = teamService.findTripById(id);
        Long userId = (Long) session.getAttribute("user_id");
        if (userId == null || userId != team.getTeamCreator().getId()) {
            return "redirect:/";
        }
        User user = userServ.findUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("userId", userId);
        model.addAttribute("team", team);
        return "edit.jsp";
    }

    @PostMapping("/teams/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session) {
        if (session.getAttribute("user_id") == null || session.getAttribute("user_id") != team.getTeamCreator().getId()) {
            return "redirect:/";
        }
        if (result.hasErrors()) {
            return "edit.jsp";
        }
        team.setId(id);
        teamService.updateTeam(team);
        return "redirect:/home";
    }


    @GetMapping("/teams/{id}")
    public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
        Team team = teamService.findTripById(id);
        Long userId = (Long) session.getAttribute("user_id");
        if (userId == null) {
            return "redirect:/";
        }
        User currentUser = userServ.findUserById(userId);
        User user = userServ.findUserById(userId);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("userId", userId);
        model.addAttribute("team", team);
        return "showteam.jsp";


    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        teamService.deleteTeam(id);
        return "redirect:/home";
    }





















}
