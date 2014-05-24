package com.hairCustomer.management.customer.controller;

import com.hairCustomer.management.Exception.DoesNotHaveLoginInfoException;
import com.hairCustomer.management.customer.dao.CustomerDao;
import com.hairCustomer.management.customer.vo.CustomerVO;
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
@SessionAttributes("customer")
@RequestMapping("/customer")
public class CustomerController {
    CustomerDao customerDao = new CustomerDao();

    @RequestMapping(value = {"/", "/list"})
    public String list(Model model, HttpServletRequest request) throws SQLException, ClassNotFoundException {

        UserInfo userInfo = getUserInfoFromSession(request);

        List<CustomerVO> customerList = customerDao.getAll();
        model.addAttribute("customersList", customerList);
        return "Customer/list";
    }

    @RequestMapping(value={"/{customerId}"})
    public String read(@PathVariable int customerId, Model model, HttpServletRequest request) throws SQLException, ClassNotFoundException {
        UserInfo userInfo = getUserInfoFromSession(request);

        CustomerVO customer = customerDao.get(customerId);
        model.addAttribute("customer", customer);
        return "Customer/read";
    }

    @RequestMapping(value="/write", method=RequestMethod.GET)
    public String write(Model model, HttpServletRequest request) {
        UserInfo userInfo = getUserInfoFromSession(request);
        model.addAttribute("customer", new CustomerVO());
        return "Customer/write";
    }

    @RequestMapping(value="/write", method=RequestMethod.POST)
    public String write(@ModelAttribute("customer") CustomerVO customer, BindingResult result, SessionStatus sessionStatus, HttpServletRequest request) throws SQLException, ClassNotFoundException {
        UserInfo userInfo = getUserInfoFromSession(request);
        if (!result.hasErrors()) {
            customerDao.insert(customer);
            sessionStatus.setComplete();
            return "redirect:/customer/";
        }
        return "Customer/write";
    }

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String edit(@ModelAttribute CustomerVO customer, HttpServletRequest request) {
        UserInfo userInfo = getUserInfoFromSession(request);
        return "Customer/edit";
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public String edit(@ModelAttribute("customer") CustomerVO customer, BindingResult result, SessionStatus sessionStatus, HttpServletRequest request) throws SQLException, ClassNotFoundException {
        UserInfo userInfo = getUserInfoFromSession(request);
        if (!result.hasErrors()) {
            customerDao.update(customer);
            sessionStatus.setComplete();
            return "redirect:/customer/";
        }
        return "Customer/edit";
    }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public String edit(@ModelAttribute("customer") CustomerVO customer, SessionStatus sessionStatus, HttpServletRequest request) throws SQLException, ClassNotFoundException {
        UserInfo userInfo = getUserInfoFromSession(request);
        customerDao.delete(customer);
        sessionStatus.setComplete();
        return "redirect:/customer/";
    }

    private UserInfo getUserInfoFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");

        if (userInfo == null)
            throw new DoesNotHaveLoginInfoException();

        return userInfo;
    }
}
