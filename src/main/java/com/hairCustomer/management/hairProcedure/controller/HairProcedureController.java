package com.hairCustomer.management.hairProcedure.controller;

import com.hairCustomer.management.Exception.DoesNotHaveLoginInfoException;
import com.hairCustomer.management.hairProcedure.dao.HairProcedureDao;
import com.hairCustomer.management.hairProcedure.vo.HairProcedureVO;
import com.hairCustomer.management.login.vo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
@SessionAttributes("hairProcedure")
@RequestMapping("/hairProcedure")
public class HairProcedureController {
    HairProcedureDao hairProcedureDao = new HairProcedureDao();

    @RequestMapping(value={"/{customerId}/list", "/{customerId}/"})
    public String hairProcedureList(@PathVariable int customerId, Model model, HttpServletRequest request) throws SQLException, ClassNotFoundException {
        UserInfo userInfo = getUserInfoFromSession(request);

        List<HairProcedureVO> hairProcedureList = hairProcedureDao.getAllOfCustomerSub(customerId);
        model.addAttribute("hairProcedureList", hairProcedureList);
        model.addAttribute("customerId", customerId);
        return "HairProcedure/list";
    }

    @RequestMapping("/{customerId}/{hairProcedureId}")
    public String hairProcedureEdit(@PathVariable int customerId, @PathVariable int hairProcedureId, Model model, HttpServletRequest request) throws SQLException, ClassNotFoundException {
        UserInfo userInfo = getUserInfoFromSession(request);

        HairProcedureVO hairProcedure = hairProcedureDao.get(hairProcedureId);
        model.addAttribute("hairProcedure", hairProcedure);
        model.addAttribute("customerId", customerId);
        return "HairProcedure/read";
    }

    @RequestMapping(value="/{customerId}/write", method= RequestMethod.GET)
    public String write(@PathVariable int customerId, Model model, HttpServletRequest request) {
        UserInfo userInfo = getUserInfoFromSession(request);

        HairProcedureVO hairProcedure = new HairProcedureVO();
        hairProcedure.setCustomerId(customerId);
        model.addAttribute("hairProcedure", hairProcedure);
        model.addAttribute("customerId", customerId);
        return "HairProcedure/write";
    }

    @RequestMapping(value="/{customerId}/write", method=RequestMethod.POST)
    public String write(@ModelAttribute("hairProcedure") HairProcedureVO hairProcedure, BindingResult result, SessionStatus sessionStatus, HttpServletRequest request) throws SQLException, ClassNotFoundException {
        UserInfo userInfo = getUserInfoFromSession(request);

        if (!result.hasErrors()) {
            hairProcedureDao.insert(hairProcedure);
            sessionStatus.setComplete();
            return "redirect:/hairProcedure/" + hairProcedure.getCustomerId()+"/";
        }
        return "HairProcedure/write";
    }

    @RequestMapping(value="/{customerId}/edit", method=RequestMethod.GET)
    public String edit(Model model, @ModelAttribute HairProcedureVO hairProcedure, HttpServletRequest request) {
        UserInfo userInfo = getUserInfoFromSession(request);

        model.addAttribute("customerId", hairProcedure.getCustomerId());
        return "HairProcedure/edit";
    }

    @RequestMapping(value="/{customerId}/edit", method=RequestMethod.POST)
    public String edit(@ModelAttribute("hairProcedure") HairProcedureVO hairProcedure, BindingResult result, SessionStatus sessionStatus, HttpServletRequest request) throws SQLException, ClassNotFoundException {
        UserInfo userInfo = getUserInfoFromSession(request);

        if (!result.hasErrors()) {
            hairProcedureDao.update(hairProcedure);
            sessionStatus.setComplete();
            return "redirect:/hairProcedure/" + hairProcedure.getCustomerId()+"/";
        }
        return "HairProcedure/edit";
    }

    @RequestMapping(value="/{customerId}/delete", method=RequestMethod.POST)
    public String edit(@ModelAttribute("hairProcedure") HairProcedureVO hairProcedure, SessionStatus sessionStatus, HttpServletRequest request) throws SQLException, ClassNotFoundException {
        UserInfo userInfo = getUserInfoFromSession(request);

        hairProcedureDao.delete(hairProcedure);
        sessionStatus.setComplete();
        return "redirect:/hairProcedure/" + hairProcedure.getCustomerId()+"/";
    }

    private UserInfo getUserInfoFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");

        if (userInfo == null)
            throw new DoesNotHaveLoginInfoException();

        return userInfo;
    }
}
