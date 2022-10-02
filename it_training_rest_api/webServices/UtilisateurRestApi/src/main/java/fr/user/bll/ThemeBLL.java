package fr.user.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.user.bo.Theme;
import fr.user.dal.ThemeDAO;

@Service
public class ThemeBLL {
	@Autowired
	private ThemeDAO dao;
	
	public List<Theme> selectAll() {
		return dao.findAll();
	}
	
	public Theme selectById(int id) {
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
