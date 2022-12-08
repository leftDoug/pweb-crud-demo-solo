package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cu.edu.cujae.pweb.dto.AsignaturaDto;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
	
	public AsignaturaServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createAsignatura(AsignaturaDto asignatura) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AsignaturaDto> listAsignaturas() {
		// TODO Auto-generated method stub

		List<AsignaturaDto> asignaturas = new ArrayList<AsignaturaDto>();
		
		
		  asignaturas.add(new AsignaturaDto(1, 1, "Matematica I", 82));
		  asignaturas.add(new AsignaturaDto(2, 1, "Matematica II", 76));
		  asignaturas.add(new AsignaturaDto(3, 2, "Matematica III", 70));
		  asignaturas.add(new AsignaturaDto(4, 2, "Matematica Numerica", 78));
		  asignaturas.add(new AsignaturaDto(5, 3, "Paginas Web", 68));
		  asignaturas.add(new AsignaturaDto(6, 3, "Seguridad Informatica", 70));
		  asignaturas.add(new AsignaturaDto(7, 4, "Investigacion de Operaciones", 78));
		  asignaturas.add(new AsignaturaDto(8, 4, "Gestion de Proyectos", 74));
		 

		return asignaturas;
	}

	@Override
	public AsignaturaDto getAsignaturaById(int id) {
		// TODO Auto-generated method stub

		AsignaturaDto asignatura = listAsignaturas().stream().filter(r -> r.getIdasignatura() == id).findFirst().get();
		
		return asignatura;

	}

	@Override
	public void updateAsignatura(AsignaturaDto asignatura) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAsignatura(int id) {
		// TODO Auto-generated method stub

	}

}
