package fr.user.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.user.bo.Apprenant;
import fr.user.dal.ApprenantDAO;






@Service
public class ApprenantBll {
      @Autowired
	 private ApprenantDAO dao;
		
      public List<Apprenant> selectAll() {
  		return dao.findAll();
  	}
  	
  	public Apprenant selectById(int id) {
  		return dao.findById(id).get();
  	}
  	
  	public void update(Apprenant a) {
  		dao.save(a);
  	}
  	
  	public void insert(Apprenant a) {
  		dao.save(a);
  	}
  	
  	public void delete(int id) {
  		dao.deleteById(id);
  	}
  	
  	public boolean exist(int id) {
  		return dao.existsById(id);
  	}
  }



