package fr.user.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.user.bo.Formateur;
import fr.user.dal.FormateurDAO;






@Service
public class FormateurBll {
	@Autowired
	 private FormateurDAO dao;
		
	public List<Formateur> selectAll() {
		return dao.findAll();
	}
	
	public Formateur selectById(int id) {
		return dao.findById(id).get();
	}
	
	public void update(Formateur f) {
		dao.save(f);
	}
	
	public void insert(Formateur f) {
		dao.save(f);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public boolean exist(int id) {
		return dao.existsById(id);
	}
}




	