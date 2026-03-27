package ra.business;

import JDBC.ConnectionDB;
import ra.entity.Degree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DegreeManagement implements IManager{

    @Override
    public List<Degree> getAllDegrees() {
        List <Degree> degrees = new ArrayList<>();
        Connection conn ;
        CallableStatement call ;
        try{
            conn = ConnectionDB.openConnection();
            call = conn.prepareCall("{call getAllDegrees()}");
            ResultSet rs = call.executeQuery();
            while(rs.next()){
                Degree degree = new Degree();
                degree.setDegreeId(rs.getInt("degree_id"));
                degree.setDegreeName(rs.getString("degree_name"));
                degree.setEmpId(rs.getString("emp_id"));
                degree.setDegreeDate(rs.getDate("degree_date").toLocalDate());
                degree.setSchoolName(rs.getString("school_name"));
                degree.setDegreeYear(rs.getInt("degree_year"));
                degree.setDegree_classification(rs.getString("degree_classification"));
                degrees.add(degree);
            }
            if (degrees.isEmpty()){
                System.out.println("No degrees found");
            } else{
                for (Degree degree:degrees){
                    System.out.println(degree);
                }
            }

        } catch (SQLException e){
            throw new RuntimeException();
        }
        return degrees;
    }

    @Override
    public Degree getDegreeByEmpId(String empId) {
        Connection  conn ;
        CallableStatement call ;
        try {
            conn = ConnectionDB.openConnection();
            call = conn.prepareCall("{call getDegreeByEmId(?)}");
            call.setString(1, empId);
            ResultSet rs = call.executeQuery();
            if (rs.next()){
                Degree degree = new Degree();
                degree.setDegreeId(rs.getInt("degree_id"));
                degree.setDegreeName(rs.getString("degree_name"));
                degree.setEmpId(rs.getString("emp_id"));
                degree.setDegreeDate(rs.getDate("degree_date").toLocalDate());
                degree.setSchoolName(rs.getString("school_name"));
                degree.setDegreeYear(rs.getInt("degree_year"));
                degree.setDegree_classification(rs.getString("degree_classification"));
                return degree;
            }

        } catch (SQLException e){
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public Degree getDegreeByDegreeName(String degreeName) {
        Connection  conn ;
        CallableStatement call ;
        try {
            conn = ConnectionDB.openConnection();
            call  = conn.prepareCall("{call findDegreesByName(?)}");
            call.setString(1, degreeName);
            ResultSet rs = call.executeQuery();
            if (rs.next()){
                Degree degree = new Degree();
                degree.setDegreeId(rs.getInt("degree_id"));
                degree.setDegreeName(rs.getString("degree_name"));
                degree.setEmpId(rs.getString("emp_id"));
                degree.setDegreeDate(rs.getDate("degree_date").toLocalDate());
                degree.setSchoolName(rs.getString("school_name"));
                degree.setDegreeYear(rs.getInt("degree_year"));
                degree.setDegree_classification(rs.getString("degree_classification"));
                return degree;
            }
        } catch(SQLException e){
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public void addDegree(Degree degree) {
        Connection  conn = null;
        CallableStatement call ;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            call  = conn.prepareCall("{call addNewDegrees(?,?,?,?,?,?)}");
            call.setString(1, degree.getDegreeName());
            call.setString(2, degree.getEmpId());
            call.setDate(3, Date.valueOf(degree.getDegreeDate()));
            call.setString(4, degree.getSchoolName());
            call.setInt(5, degree.getDegreeYear());
            call.setString(6, degree.getDegree_classification());
            int ex =  call.executeUpdate();
            if (ex == 1){
                System.out.println("Degree added");
                conn.commit();
                conn.close();
            } else {
                System.out.println("Degree not added");
                conn.rollback();
            }
        } catch(SQLException e){
            throw new RuntimeException();
        } finally{
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void updateDegree(int degreeId, Degree degree) {
        Connection  conn = null;
        CallableStatement call ;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            call  = conn.prepareCall("{call updateDegrees(?,?,?,?,?,?,?)}");
            call.setInt(1, degreeId);
            call.setString(2, degree.getDegreeName());
            call.setString(3, degree.getEmpId());
            call.setDate(4, Date.valueOf(degree.getDegreeDate()));
            call.setString(5, degree.getSchoolName());
            call.setInt(6, degree.getDegreeYear());
            call.setString(7, degree.getDegree_classification());
            int ex = call.executeUpdate();
            if (ex == 1){
                System.out.println("Degree updated");
                conn.commit();
            } else {
                System.out.println("Degree not updated");
                conn.rollback();
            }
        } catch(SQLException e){
            throw new RuntimeException();
        } finally{
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteDegree(int degreeId) {
        Connection  conn = null;
        CallableStatement call ;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            call  = conn.prepareCall("{call deleteDegreeById (?)}");
            call.setInt(1, degreeId);
            int ex = call.executeUpdate();
            if (ex == 1){
                System.out.println("Degree deleted");
                conn.commit();
            } else {
                System.out.println("Degree not deleted");
                conn.rollback();
            }
        } catch(SQLException e){
            throw new RuntimeException();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
