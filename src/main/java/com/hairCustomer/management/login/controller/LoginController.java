package com.hairCustomer.management.login.controller;

import com.hairCustomer.management.Exception.WrongLoginInfoException;
import com.hairCustomer.management.login.dao.LoginDao;
import com.hairCustomer.management.login.vo.LoginVO;
import com.hairCustomer.management.login.vo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class LoginController {
    LoginDao loginDao = new LoginDao();

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login() {
        return "login/login";
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(@ModelAttribute("login") LoginVO loginVO, HttpServletRequest request) throws SQLException, ClassNotFoundException {
        UserInfo userInfo =  loginDao.get(loginVO);

        if (userInfo == null)
            throw new WrongLoginInfoException();

        HttpSession session = request.getSession();
        session.setAttribute("userInfo", userInfo);

        return "redirect:/customer/";

    }
}
