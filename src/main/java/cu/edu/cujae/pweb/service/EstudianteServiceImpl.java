package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cu.edu.cujae.pweb.dto.EstudianteDto;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	public EstudianteServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createEstudiante(EstudianteDto estudiante) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EstudianteDto> listEstudiantes() {
		// TODO Auto-generated method stub
		
		List<EstudianteDto> estudiantes = new ArrayList<EstudianteDto>();
		
		estudiantes.add(new EstudianteDto(1, 1, "Douglas", "Izquierdo", 1, 1));
		
		return estudiantes;
	}

	@Override
	public EstudianteDto getEstudianteById(int id) {
		// TODO Auto-generated method stub
		
		EstudianteDto estudiante = listEstudiantes().stream().filter(r -> r.getIdestudiante() == id).findFirst().get();
		
		return estudiante;
	}

	@Override
	public void updateEstudiante(EstudianteDto estudiante) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEstudiante(int id) {
		// TODO Auto-generated method stub

	}

}
