package in.laksys;

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
		return repo.findById(id).get();
	}
}
