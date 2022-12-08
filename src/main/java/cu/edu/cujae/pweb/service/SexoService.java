package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.SexoDto;

public interface SexoService {

	List<SexoDto> listSexos();

	SexoDto getSexoById(int id);

}
