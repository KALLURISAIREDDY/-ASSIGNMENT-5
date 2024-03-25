import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/departments";
    private static final String DB_USER = "sai kumar reddy";
    private static final String DB_PASSWORD = "123456";

    private static final String INSERT_DEPARTMENT_SQL = "INSERT INTO department (id, name) VALUES (?, ?)";

    public void addDepartment(Department department) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_DEPARTMENT_SQL)) {

            pstmt.setInt(1, department.getId());
            pstmt.setString(2, department.getName());

            pstmt.executeUpdate();
            System.out.println("Department added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Department department = new Department(1, "HR");

        DepartmentDAO departmentDAO = new DepartmentDAO();

        departmentDAO.addDepartment(department);
    }
}

class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
