package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cu.edu.cujae.pweb.dto.NotaDto;

@Service
public class NotaServiceImpl implements NotaService {

	public NotaServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(NotaDto nota) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<NotaDto> list() {
		// TODO Auto-generated method stub
		
		List<NotaDto> notas = new ArrayList<NotaDto>();
		
		notas.add(new NotaDto(1, 1, 5, 1));
		
		return notas;
	}

	@Override
	public NotaDto getById(int id) {
		// TODO Auto-generated method stub
		
		NotaDto nota = list().stream().filter(r -> r.getIdnota() == id).findFirst().get();
		
		return nota;
	}

	@Override
	public void update(NotaDto nota) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
