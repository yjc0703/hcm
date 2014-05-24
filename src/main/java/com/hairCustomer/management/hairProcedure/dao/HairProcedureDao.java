package com.hairCustomer.management.hairProcedure.dao;

import com.hairCustomer.management.database.DatabaseStore;
import com.hairCustomer.management.hairProcedure.vo.HairProcedureVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HairProcedureDao {
    public HairProcedureVO get(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HPTR_HAIR_PROCEDURE WHERE IS_DELETE = 'N' AND HAIR_PROCEDURE_ID = ?");
        ps.setString(1, String.valueOf(id));
        ResultSet rs = ps.executeQuery();

        HairProcedureVO hairProcedure = new HairProcedureVO();

        if (rs.next()) {
            hairProcedure.setHairProcedureId(rs.getInt("HAIR_PROCEDURE_ID"));
            hairProcedure.setHairProcedureName(rs.getString("HAIR_PROCEDURE_NAME"));
            hairProcedure.setCustomerId(rs.getInt("CUSTOMER_ID"));
            hairProcedure.setHairProcedureDate(rs.getString("HAIR_PROCEDURE_DATE"));
            hairProcedure.setNote(rs.getString("NOTE"));
        }

        ps.close();
        conn.close();

        return hairProcedure;
    }


    public List<HairProcedureVO> getAllOfCustomerSub(int customerID) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HPTR_HAIR_PROCEDURE WHERE IS_DELETE = 'N' AND CUSTOMER_ID = ?");
        ps.setString(1, String.valueOf(customerID));
        ResultSet rs = ps.executeQuery();
        List<HairProcedureVO> list = new ArrayList<HairProcedureVO>();

        while (rs.next()) {
            HairProcedureVO hairProcedure = new HairProcedureVO();

            hairProcedure.setHairProcedureId(rs.getInt("HAIR_PROCEDURE_ID"));
            hairProcedure.setHairProcedureName(rs.getString("HAIR_PROCEDURE_NAME"));
            hairProcedure.setCustomerId(rs.getInt("CUSTOMER_ID"));
            hairProcedure.setHairProcedureDate(rs.getString("HAIR_PROCEDURE_DATE"));
            hairProcedure.setNote(rs.getString("NOTE"));

            list.add(hairProcedure);
        }

        ps.close();
        conn.close();

        return list;
    }

    public List<HairProcedureVO> getAll() throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HPTR_HAIR_PROCEDURE WHERE IS_DELETE = 'N'");
        ResultSet rs = ps.executeQuery();

        List<HairProcedureVO> list = new ArrayList<HairProcedureVO>();

        while (rs.next()) {
            HairProcedureVO hairProcedure = new HairProcedureVO();

            hairProcedure.setHairProcedureId(rs.getInt("HAIR_PROCEDURE_ID"));
            hairProcedure.setHairProcedureName(rs.getString("HAIR_PROCEDURE_NAME"));
            hairProcedure.setCustomerId(rs.getInt("CUSTOMER_ID"));
            hairProcedure.setHairProcedureDate(rs.getString("HAIR_PROCEDURE_DATE"));
            hairProcedure.setNote(rs.getString("NOTE"));

            list.add(hairProcedure);
        }

        ps.close();
        conn.close();

        return list;
    }

    public void insert(HairProcedureVO customer) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO HPTR_HAIR_PROCEDURE(HAIR_PROCEDURE_NAME, CUSTOMER_ID, HAIR_PROCEDURE_DATE, NOTE, IS_DELETE) VALUES(?, ?, ?, ?, 'N')");
        ps.setString(1, customer.getHairProcedureName());
        ps.setInt(2, customer.getCustomerId());
        ps.setString(3, customer.getHairProcedureDate());
        ps.setString(4, customer.getNote());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public void update(HairProcedureVO hairProcedure) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "UPDATE HPTR_HAIR_PROCEDURE SET HAIR_PROCEDURE_NAME = ?, HAIR_PROCEDURE_DATE = ?, NOTE = ? WHERE HAIR_PROCEDURE_ID = ?");
        ps.setString(1, hairProcedure.getHairProcedureName());
        ps.setString(2, hairProcedure.getHairProcedureDate());
        ps.setString(3, hairProcedure.getNote());
        ps.setString(4, String.valueOf(hairProcedure.getHairProcedureId()));

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public void delete(HairProcedureVO customer) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "UPDATE HPTR_HAIR_PROCEDURE SET IS_DELETE = 'Y' WHERE HAIR_PROCEDURE_ID = ?");
        ps.setString(1, String.valueOf(customer.getHairProcedureId()));

        ps.executeUpdate();

        ps.close();
        conn.close();
    }
}
