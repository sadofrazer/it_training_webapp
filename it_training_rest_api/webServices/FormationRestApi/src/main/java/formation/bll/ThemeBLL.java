package formation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.bo.Theme;
import formation.dal.ThemeDAO;

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
