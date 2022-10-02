package fr.user.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.user.bo.Responsable;
import fr.user.dal.ResponsableDAO;




@Service
public class ResponsableBll {
@Autowired
private ResponsableDAO dao;
	
public List<Responsable> selectAll() {
	return dao.findAll();
}

public Responsable selectById(int id) {
	return dao.findById(id).get();
}

public void update(Responsable r) {
	dao.save(r);
}

public void insert(Responsable r) {
	dao.save(r);
}

public void delete(int id) {
	dao.deleteById(id);
}

public boolean exist(int id) {
	return dao.existsById(id);
}
}