package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cu.edu.cujae.pweb.dto.GrupoDto;

@Service
public class GruposServiceImpl implements GrupoService {

	public GruposServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createGrupo(GrupoDto grupo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GrupoDto> listGrupos() {
		// TODO Auto-generated method stub
		
		List<GrupoDto> grupos = new ArrayList<GrupoDto>();
		
		grupos.add(new GrupoDto(1, 1, 11));
		
		return grupos;
	}

	@Override
	public GrupoDto getGrupoById(int id) {
		// TODO Auto-generated method stub
		
		GrupoDto grupo = listGrupos().stream().filter(r -> r.getIdgrupo() == id).findFirst().get();
		
		return grupo;
	}

	@Override
	public void updateGrupo(GrupoDto grupo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGrupo(int id) {
		// TODO Auto-generated method stub

	}

}
