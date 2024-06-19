package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList; // Added import statement for ArrayList
import java.util.List; // Added import statement for List

import com.entity.jobs;

public class JobDAO {

    private Connection conn;

    public JobDAO(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean addJobs(jobs j) {
        boolean f = false;

        try {
            String sql = "insert into jobs(id,title,description,category,status,location) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, j.getId());
            ps.setString(2, j.getTitle());
            ps.setString(3, j.getDescription());
            ps.setString(4, j.getCategory());
            ps.setString(5, j.getStatus());
            ps.setString(6, j.getLocation());
            

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    private Timestamp getPdate() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<jobs> getAllJobs() {
        List<jobs> list = new ArrayList<jobs>(); // Changed to ArrayList<jobs>
        jobs j = null;

        try {
            String sql = "select * from jobs order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                j = new jobs();
                j.setId(rs.getInt(1));
                j.setTitle(rs.getString(2));
                j.setDescription(rs.getString(3));
                j.setCategory(rs.getString(4));
                j.setStatus(rs.getString(5));
                j.setLocation(rs.getString(6)); 
                j.setPdate(rs.getString(7) );
                list.add(j);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public List<jobs> getJobsForUser() {
        List<jobs> list = new ArrayList<jobs>(); // Changed to ArrayList<jobs>
        jobs j = null;

        try {
            String sql = "select * from jobs where status=? order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Active");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                j = new jobs();
                j.setId(rs.getInt(1));
                j.setTitle(rs.getString(2));
                j.setDescription(rs.getString(3));
                j.setCategory(rs.getString(4));
                j.setStatus(rs.getString(5));
                j.setLocation(rs.getString(6)); 
                j.setPdate(rs.getString(7) );
                list.add(j);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public jobs getJobById(int id) {
       
        jobs j = null;

        try {
            String sql = "select * from jobs where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                j = new jobs();
                j.setId(rs.getInt(1));
                j.setTitle(rs.getString(2));
                j.setDescription(rs.getString(3));
                j.setCategory(rs.getString(4));
                j.setStatus(rs.getString(5));
                j.setLocation(rs.getString(6)); 
                j.setPdate(rs.getString(7) );
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }
	
	public boolean updateJob(jobs j) {
		boolean f = false;

        try {
            String sql = "update jobs set title=?,description=?,category=?,status=?,location=?) where id=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, j.getId());
            ps.setString(2, j.getTitle());
            ps.setString(3, j.getDescription());
            ps.setString(4, j.getCategory());
            ps.setString(5, j.getStatus());
            ps.setString(6, j.getLocation());
            ps.setInt(6, j.getId());

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
	}
        
        public boolean deleteJobs(int id) {
        	boolean f=false;
        	try {
        		String sql="delete from jobs where id=?";
        		PreparedStatement ps=conn.prepareStatement(sql);
        		ps.setInt(1, id);
        		
        		int i=ps.executeUpdate();
        		if(i==1) {
        			f=true;
        		}
        	    }catch(Exception e) {
        			e.printStackTrace();
        		}
        			
        		return f;
        	}
        }
	

