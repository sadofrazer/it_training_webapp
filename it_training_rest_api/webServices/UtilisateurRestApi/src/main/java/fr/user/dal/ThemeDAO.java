package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.Theme;

@Repository
public interface ThemeDAO extends JpaRepository<Theme, Integer> {

}
