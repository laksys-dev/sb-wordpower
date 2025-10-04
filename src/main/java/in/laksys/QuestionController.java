package in.laksys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
	@Autowired
	private QuestionRepo repo;
	
	@GetMapping("/{id}") 
	public Question getQuestions(@PathVariable Integer id){
		return repo.findById(id).get();
	}
}
