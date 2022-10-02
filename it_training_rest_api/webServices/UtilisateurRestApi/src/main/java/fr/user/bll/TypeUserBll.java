package fr.user.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.user.bo.TypeUser;
import fr.user.dal.AfectDAO;

@Service
public class TypeUserBll {
	
	@Autowired
	private AfectDAO dao;
	
	public List<TypeUser> selectAll() {
		return dao.findAll();
	}
	
	public TypeUser selectById(int id) {
		return dao.findById(id).get();
	}
	
	public void update(TypeUser u) {
		dao.save(u);
	}
	
	public void insert(TypeUser u) {
		dao.save(u);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public boolean exist(int id) {
		return dao.existsById(id);
	}
}