package application.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/person")
public class PersonController {
	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping(value = {"", "/"})
	public List<Person> getPersons(){
		return personService.getPersons();
		
	}
	
	@PostMapping
	 public void registerNewPerson(@RequestBody Person person) {
		 personService.addNewPerson(person);
		 
	 }
	
	@DeleteMapping(path = "{id}")
	public void deletePerson(@PathVariable("id") Long id) {
		personService.delete(id);
	}
	
}
