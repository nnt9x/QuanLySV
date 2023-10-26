import java.sql.*;

public class StudentDB {
    // Ket noi den CSDL, thuc hien truy van
    private final String URL_CONNECTION = "jdbc:mysql://localhost:8889/demo_triggger2triggger";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public void printStudents() throws SQLException {
        // Buoc 1: Ket noi den CSDL
        // Buoc 2: chuan bi lenh sql
        // Buoc 3: Thuc thi va xem ket qua
        // Buoc 4: In thong tin
        // Buoc 5: Dong ket noi
        Connection conn = DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);
        String sql = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        // Kiem tra du lieu va in

        while (rs.next() != false) {
            // Ma sv, ten sv, gpa
            System.out.println("\tMa sinh vien: " + rs.getInt("id"));
            System.out.println("\tHo ten: " + rs.getString("full_name"));
            System.out.println("\tDiem gpa: " + rs.getFloat("gpa"));
            System.out.println("\t-------------------------------------------");
        }

        conn.close();
    }
    public void updateStudent(int id, String fullName, float gpa) throws SQLException {
        // Tam thoi bo qua validate
        // Buoc 1: Ket noi den CSDL
        // Buoc 2: chuan bi lenh sql
        // Buoc 3: Thuc thi va xem ket qua
        // Buoc 4: In thong tin
        // Buoc 5: Dong ket noi
        Connection conn = DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);
        String sql =  String.format("UPDATE students  SET full_name = '%s', gpa = %.2f WHERE id = %d", fullName, gpa, id);

        Statement stmt = conn.createStatement();
        int rs = stmt.executeUpdate(sql);
        if(rs == 0){
            System.out.println("Cap nhat that bai");
        }
        else{
            System.out.println("Cap nhat thanh cong!");
        }
        conn.close();
    }
}
