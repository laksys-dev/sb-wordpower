package in.laksys;

import org.springframework.stereotype.Component;

@Component
public class Mapper {
	public TopicDTO toDto(Topic topic) {
		TopicDTO dto = new TopicDTO();
		dto.setId(topic.getId());
		dto.setName(topic.getName());
		dto.setDescription(topic.getDescription());
		return dto;
	}
}
