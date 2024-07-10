package net.datasa.web3;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {
	
	// Entity, PK 타입
	Optional<PersonEntity> findById(String id);

}
