/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author thiendv
 */
public class UserModel extends ConnectionPool implements Serializable {

    public UserModel() throws IOException, ClassNotFoundException, SQLException {
    }

    public int getSerial() throws ClassNotFoundException, SQLException, IOException {
        int iResult = -1;
        openConnection();
        String strSql = "select count(*) as serial from users";
        mpreparedStatement = connection.prepareStatement(strSql);
        mresultSet = mpreparedStatement.executeQuery();
        while (mresultSet.next()) {
            iResult = mresultSet.getInt("serial");
        }

        closeAll();
        return iResult;

    }
}
