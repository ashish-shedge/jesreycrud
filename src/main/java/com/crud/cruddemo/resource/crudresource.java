package com.crud.cruddemo.resource;


import java.sql.SQLException;
import java.util.ArrayList;

import com.crud.cruddemo.model.crudmodel;
import com.crud.cruddemo.service.crudservice;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class crudresource {
	
	crudservice service=new crudservice();

	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    public crudmodel addStudent(crudmodel student){

		return service.insertStudent(student);
	}
	

	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public ArrayList<crudmodel> getStudent() throws SQLException{

		return service.getStudent();
	}
    
    
    @Path("/retrieveStudentById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public ArrayList<crudmodel> getStudent(@PathParam("id") int id) throws SQLException{

		return service.getStudentById(id);
	}
    
    
    @Path("/updateStudent")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    public crudmodel updateStudent(crudmodel student){

		return service.updateStudent(student);
	}
    
    
    @Path("/deleteStudentById/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
    public int deleteStudent(@PathParam("id") int id){

		return service.deleteStudent(id);
	}
}
