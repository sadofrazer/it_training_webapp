package formation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.bo.Domaine;
import formation.dal.DomaineDAO;


@Service
public class DomaineBLL {
	
	@Autowired
	private DomaineDAO dao;
	
	public List<Domaine> selectAll() {
		return dao.findAll();
	}
	
	public Domaine selectById(int id) {
		if(exist(id)) {
			return dao.findById(id).get();
		}else {
			return null;
		}
	}
	
	//if id exist in database return true, else retrun false
	public boolean exist(int id) {
		return dao.existsById(id);
	}
	
}
