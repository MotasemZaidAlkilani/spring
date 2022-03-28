package com.example.auth.Controllers;

import com.example.auth.Repositries.loginUserRepositry;
import com.example.auth.modals.LoginUser;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {

    private final loginUserRepositry loginUserRepositry;

    public AuthenticationController(loginUserRepositry loginUserRepositry) {
        this.loginUserRepositry = loginUserRepositry;
    }
    @GetMapping("/login")
    public String getLoginPage()
    {
        return "login";
    }
    @PostMapping("/login")
    public RedirectView logInUser(HttpServletRequest request, String username, String password)
    {
        LoginUser userFromDb = loginUserRepositry.findByUsername(username);

        if ((userFromDb == null) || (!BCrypt.checkpw(password, userFromDb.getPassword()))) {
            return new RedirectView("/login");
        }
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        return new RedirectView("/loggedin");
    }

    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";

    }

    @PostMapping("/signup")
    public RedirectView signUpUser(Model m, String username, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        LoginUser newUser = new LoginUser(username, hashedPassword);

        loginUserRepositry.save(newUser);
        return new RedirectView("/login");
    }
    @GetMapping("/loggedin")
    String getLogged_inPage(HttpServletRequest request, Model m){
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        m.addAttribute("username", username);
        return "loggedin";
    }
}