package com.crud.cruddemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crud.cruddemo.model.crudmodel;

public class crudservice {

	Connection con = null;
	PreparedStatement ps = null;

	public crudservice() {

		String url = "jdbc:mysql://localhost:3306/test";
		String uname = "root";
		String pwd = "12345678";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pwd);

		} catch (Exception e) {
			System.out.println(e + "data insert unsuccess");

		}

	}
	
	

	public crudmodel insertStudent(crudmodel student) {
		String sql = "insert into student(student_no,student_name,student_dob,student_doj) values(?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, student.getStudent_no());
			ps.setString(2, student.getStudent_name());
			ps.setString(3, student.getStudent_dob());
			ps.setString(4, student.getStudent_dob());

			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e + "data insert unsuccess");
		}

		return student;
	}
	
	
	

	public ArrayList<crudmodel> getStudent() throws SQLException {

		ArrayList<crudmodel> data = new ArrayList<crudmodel>();

		String select = "select * from student";

		ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			crudmodel model = new crudmodel();

			model.setStudent_no(rs.getInt("student_no"));
			model.setStudent_name(rs.getString("student_name"));
			model.setStudent_dob(rs.getString("student_dob"));
			model.setStudent_doj(rs.getString("student_doj"));

			data.add(model);
		}

		return data;

	}
	
	


	public ArrayList<crudmodel> getStudentById(int id) throws SQLException {

		ArrayList<crudmodel> data = new ArrayList<crudmodel>();

		String select = "select * from student where student_no=?";

		ps = con.prepareStatement(select);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			crudmodel model = new crudmodel();

			model.setStudent_no(rs.getInt("student_no"));
			model.setStudent_name(rs.getString("student_name"));
			model.setStudent_dob(rs.getString("student_dob"));
			model.setStudent_doj(rs.getString("student_doj"));

			data.add(model);
		}

		return data;

	}
	
	
	
	
	public crudmodel updateStudent(crudmodel student) {
		String sql = "update student set student_name=?, student_dob=?, student_doj where student_no=?";

		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, student.getStudent_name());
			ps.setString(2, student.getStudent_dob());
			ps.setString(3, student.getStudent_dob());
			ps.executeUpdate();

		} catch (Exception e) {
			
			System.out.println(e + "data insert unsuccess");
		}

		return student;
	}
	
	
	
	
	public int deleteStudent(int id) {
		String sql = "delete from student where student_no=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();

		} catch (Exception e) {
			
			System.out.println(e + "data insert unsuccess");
		}

		return id;
	}
}
