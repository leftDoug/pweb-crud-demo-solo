package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.AnnoDto;

public interface AnnoService {
	
	List<AnnoDto> listAnnos();
	
	AnnoDto getAnnoById(int id);

}
