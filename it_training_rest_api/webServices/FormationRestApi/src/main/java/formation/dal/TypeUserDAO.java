package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.TypeUser;

@Repository
public interface TypeUserDAO extends JpaRepository<TypeUser, Integer>{

}
