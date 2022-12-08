package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.EstudianteDto;

public interface EstudianteService {
	
	void createEstudiante(EstudianteDto estudiante);
	
	List<EstudianteDto> listEstudiantes();
	
	EstudianteDto getEstudianteById(int id);
	
	void updateEstudiante(EstudianteDto estudiante);
	
	void deleteEstudiante(int id);

}
