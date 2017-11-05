package com.shuraj.restapidemo.repository;

import java.util.List;

import com.shuraj.restapidemo.entity.Alien;

public interface AlienRepository {
	public void createAlien(Alien alien);
	public List<Alien> getAllAlien();
	public Alien getAlien(int id);
	public void updateAlien(Alien alien);
	public void deleteAlien(int id);
}
