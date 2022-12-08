package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.GrupoDto;

public interface GrupoService {

	void createGrupo(GrupoDto grupo);

	List<GrupoDto> listGrupos();

	GrupoDto getGrupoById(int id);

	void updateGrupo(GrupoDto grupo);

	void deleteGrupo(int id);

}
