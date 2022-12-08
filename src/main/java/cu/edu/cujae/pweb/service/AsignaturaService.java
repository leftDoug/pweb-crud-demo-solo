package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.AsignaturaDto;

public interface AsignaturaService {

	void createAsignatura(AsignaturaDto asignatura);

	List<AsignaturaDto> listAsignaturas();

	AsignaturaDto getAsignaturaById(int id);

	void updateAsignatura(AsignaturaDto asignatura);

	void deleteAsignatura(int id);

}
