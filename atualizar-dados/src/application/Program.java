package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "update seller "
                    + "set BaseSalary = BaseSalary + ? "
                    + "where "
                    + "(DepartmentId = ?)");

            st.setDouble(1, 200.0);//? #1: informo o valor que será acrescido no salário
            st.setInt(2, 2);//? #2: informo qual departamento receberá esse aumento

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
