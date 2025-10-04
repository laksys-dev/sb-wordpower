package in.laksys;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topic")
public class TopicController {
	@Autowired
	private TopicRepo repo;
	
	@GetMapping("/{id}")
	public Topic getById(@PathVariable Integer id) {
		//return repo.findById(id).get();
		return repo.findById(id).orElseThrow(() -> new NoSuchElementException("No topic found for that id " + id));
	}
	@GetMapping
	public List<TopicDTO> getAll(){
		Mapper mapper = new Mapper();
		List<TopicDTO> topicDTO = 
			repo.findAll().stream()
				//.map(entity -> new TopicDTO(entity.getId(), entity.getName(), entity.getDescription()))
				.map( entity -> mapper.toDto(entity))
				.collect(Collectors.toList());
		
		return topicDTO;
	}
}
