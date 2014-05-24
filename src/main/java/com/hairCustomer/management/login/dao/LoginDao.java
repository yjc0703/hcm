package com.hairCustomer.management.login.dao;

import com.hairCustomer.management.database.DatabaseStore;
import com.hairCustomer.management.login.vo.LoginVO;
import com.hairCustomer.management.login.vo.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public UserInfo get(LoginVO loginVO) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseStore.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HPTR_USER WHERE USER_ID = ? AND USER_PW = ?");
        ps.setString(1, loginVO.getLoginId());
        ps.setString(2, loginVO.getLoginPw());
        ResultSet rs = ps.executeQuery();

        UserInfo userInfo = null;

        if (rs.next()) {
            userInfo = new UserInfo();
            userInfo.setUserId(rs.getString("USER_ID"));
            userInfo.setUserName(rs.getString("USER_NAME"));
        }

        ps.close();
        conn.close();

        return userInfo;
    }
}
