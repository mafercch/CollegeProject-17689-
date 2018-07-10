/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesFolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mariacontreras / 17689
 */
public class Implementor {
    public Implementor() {
    }

    public List<Branch> getAllBranches() {
        List<Branch> list = new ArrayList<Branch>();
        ResultSet rs = DatabaseOperations.getTableResultSet("branch");
        try {
            while (rs.next()) {
                Branch branch = new Branch(rs.getLong("idbranch"), rs.getString("name"), rs.getString("details"));
                System.out.println(branch);
                list.add(branch);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<Course>();
        ResultSet rs = DatabaseOperations.getTableResultSet("course");
        try {
            while (rs.next()) {
                Course course = new Course(rs.getString("name"), rs.getString("details"));
                System.out.println(course);
                list.add(course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Exam> getAllTests() {
        List<Exam> list = new ArrayList<Exam>();
        ResultSet rs = DatabaseOperations.getTableResultSet("test");
        try {
            while (rs.next()) {
                Exam test = new Exam(rs.getLong("testid"), rs.getString("name"), rs.getInt("isExam") == 1, rs.getInt("isAssignment") == 1, rs.getString("testdetails"), rs.getInt("maxmarkalloted"));
                System.out.println(test);
                list.add(test);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean createTest(String testName, boolean assignment, boolean exam, String description, int maxMarksAlloted) {
        return DatabaseOperations.createTest(testName, assignment, exam, description, maxMarksAlloted);
    }

    public boolean createBranch(String branchName, String description) {
        return DatabaseOperations.createBranch(branchName, description);
    }

    public boolean createStudentResult(Long testId, Long studentid, int marks) {
        return DatabaseOperations.createStudentResult(testId, studentid, marks);
    }

    public boolean createFee(String feePurpose, Long studentId, int amount, String paidDate) {
        return DatabaseOperations.createFee(feePurpose, studentId, amount, paidDate);
    }

    public void addSuperAdmin(String firstName, String lastName, String password) {
        DatabaseOperations.registerSuperAdmin(firstName, lastName, password);
    }

    public void addFacultY(String firstName, String lastName, String password) {
        DatabaseOperations.registerFaculty(firstName, lastName, password);
    }

    public void addStudent(String firstName, String lastName, String password) {
        DatabaseOperations.registerStudent(firstName, lastName, password);
    }

    public User getUser(String username, String password) {
        if (DatabaseOperations.getAvailableRows("superadmin", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DatabaseOperations.getTableResultSet("superadmin", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), true, false, false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (DatabaseOperations.getAvailableRows("faculty", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DatabaseOperations.getTableResultSet("faculty", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new User(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), false, true, false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (DatabaseOperations.getAvailableRows("student", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DatabaseOperations.getTableResultSet("student", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new User(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), false, false, true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
