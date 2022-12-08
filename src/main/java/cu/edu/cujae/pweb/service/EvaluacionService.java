package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.EvaluacionDto;

public interface EvaluacionService {
	
	List<EvaluacionDto> listEvaluaciones();
	
	EvaluacionDto getEvaluacionById(int id);

}
