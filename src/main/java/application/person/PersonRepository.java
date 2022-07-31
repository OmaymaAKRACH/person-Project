package application.person;

import java.util.List;
import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends Neo4jRepository<Person, Long> {
	
	Optional<Person> findByEmail(String email);
	Optional<Person> findById(@Param("id") Long id);
	
	@Query("MATCH (n:abc) return n")
	List<Person> getAll();
}
