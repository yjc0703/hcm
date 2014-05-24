package com.hairCustomer.management.customer.dao;

import com.hairCustomer.management.customer.vo.CustomerVO;
import com.hairCustomer.management.database.DatabaseStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public CustomerVO get(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HPTR_CUSTOMER WHERE IS_DELETE = 'N' AND CUSTOMER_ID = ?");
        ps.setString(1, String.valueOf(id));
        ResultSet rs = ps.executeQuery();

        CustomerVO customer = new CustomerVO();

        if (rs.next()) {
            customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
            customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
            customer.setPhoneNumber(rs.getString("PHONE_NUMBER"));
            customer.setNote(rs.getString("NOTE"));
        }

        ps.close();
        conn.close();

        return customer;
    }

    public List<CustomerVO> getAll() throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HPTR_CUSTOMER WHERE IS_DELETE = 'N'");

        ResultSet rs = ps.executeQuery();
        List<CustomerVO> list = new ArrayList<CustomerVO>();

        while (rs.next()) {
            CustomerVO customer = new CustomerVO();
            customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
            customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
            customer.setPhoneNumber(rs.getString("PHONE_NUMBER"));
            customer.setNote(rs.getString("NOTE"));

            list.add(customer);
        }

        ps.close();
        conn.close();

        return list;
    }

    public void insert(CustomerVO customer) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO HPTR_CUSTOMER(CUSTOMER_NAME, PHONE_NUMBER, NOTE, IS_DELETE) VALUES(?, ?, ?, 'N')");
        ps.setString(1, customer.getCustomerName());
        ps.setString(2, customer.getPhoneNumber());
        ps.setString(3, customer.getNote());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public void update(CustomerVO customer) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "UPDATE HPTR_CUSTOMER SET CUSTOMER_NAME = ?, PHONE_NUMBER = ?, NOTE = ? WHERE CUSTOMER_ID = ?");
        ps.setString(1, customer.getCustomerName());
        ps.setString(2, customer.getPhoneNumber());
        ps.setString(3, customer.getNote());
        ps.setString(4, String.valueOf(customer.getCustomerId()));

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public void delete(CustomerVO customer) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "UPDATE HPTR_CUSTOMER SET IS_DELETE = 'Y' WHERE CUSTOMER_ID = ?");
        ps.setString(1, String.valueOf(customer.getCustomerId()));

        ps.executeUpdate();

        ps.close();
        conn.close();
    }
}
