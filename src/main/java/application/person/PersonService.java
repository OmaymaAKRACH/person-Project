package application.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Service
public class PersonService {
	private final PersonRepository personRepository ;
	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@GetMapping
	public List<Person> getPersons(){
		return (List<Person>) personRepository.getAll();

	}

	@PostMapping
	public void addNewPerson(Person person) {
		// TODO Auto-generated method stub
		
		Optional<Person> personOptional=personRepository.findByEmail(person.getEmail());
		if (personOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		personRepository.save(person);
	}

	/*public Person getPersonById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}*/
	public void delete(Long id) {
		boolean exists=personRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("Person with id="+id+"does not exist");
		}
		personRepository.deleteById(id);
		
	}

	
	}

	
	
	


