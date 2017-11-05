package com.shuraj.restapidemo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shuraj.restapidemo.entity.Alien;
import com.shuraj.restapidemo.util.JdbcConnection;

public class AlienRepositoryImpl implements AlienRepository{
	private PreparedStatement ps;
	private ResultSet rs;
	
	public AlienRepositoryImpl() {
	}
	
	@Override
	public void createAlien(Alien alien) {
		String sql = "insert into aliens(id,name,points) values(?,?,?)";
		try {
			ps = JdbcConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, alien.getId());
			ps.setString(2, alien.getName());
			ps.setInt(3, alien.getPoints());
			
			ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			JdbcConnection.closeAll(ps);
		}
	}

	@Override
	public List<Alien> getAllAlien() {
		List<Alien> alienList = new ArrayList<Alien>();
		String sql = "select * from aliens";
		try {
			ps = JdbcConnection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Alien alien = new Alien();
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setPoints(rs.getInt(3));
				
				alienList.add(alien);
			}
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}finally {
			JdbcConnection.closeAll(ps);
		}
		return alienList;
	}

	@Override
	public Alien getAlien(int id) {
		Alien alien = new Alien();
		String sql = "SELECT * FROM aliens where id="+id;
		try {
			ps = JdbcConnection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setPoints(rs.getInt(3));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcConnection.closeAll(ps);
		}
		return alien;
	}

	@Override
	public void updateAlien(Alien alien) {
		String sql = "update aliens set name=?,points=? where id=?";
		try {
			ps = JdbcConnection.getConnection().prepareStatement(sql);
			ps.setString(1, alien.getName());
			ps.setInt(2, alien.getPoints());
			ps.setInt(3, alien.getId());
			
			ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			JdbcConnection.closeAll(ps);
		}
	}

	@Override
	public void deleteAlien(int id) {
		String sql = "delete from aliens where id="+id;
		try {
			ps = JdbcConnection.getConnection().prepareStatement(sql);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcConnection.closeAll(ps);
		}
	}

}
