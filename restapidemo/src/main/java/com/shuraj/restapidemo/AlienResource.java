package com.shuraj.restapidemo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.shuraj.restapidemo.entity.Alien;
import com.shuraj.restapidemo.repository.AlienRepository;
import com.shuraj.restapidemo.repository.AlienRepositoryImpl;

@Path("aliens")
public class AlienResource {

	private AlienRepository alienRepo;
	
	public AlienResource() {
		alienRepo = new AlienRepositoryImpl();
	}
	
	//get All data from database
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> getAllAlien(){
		return alienRepo.getAllAlien();
	}
	
	//insert data into database from user data
	@POST
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien createAlien(Alien alien) {
		alienRepo.createAlien(alien);
		return alien;
	}
	
	
	//get data by id 
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien getAlienById(@PathParam("id") int id) {
		return alienRepo.getAlien(id);
	}
	
	@PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien updateAlien(Alien alien) {
		alienRepo.updateAlien(alien);
		return alien;
	}
	
	@DELETE
	@Path("alien/{id}")
	public Alien killAlien(@PathParam("id") int id) {
		alienRepo.deleteAlien(id);
		return alienRepo.getAlien(id);
	}
}
