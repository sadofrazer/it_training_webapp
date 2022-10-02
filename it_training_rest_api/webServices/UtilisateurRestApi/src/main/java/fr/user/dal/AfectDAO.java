package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.TypeUser;

@Repository
public interface AfectDAO  extends JpaRepository<TypeUser, Integer>{

}
