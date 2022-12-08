package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.NotaDto;

public interface NotaService {

	void create(NotaDto nota);

	List<NotaDto> list();

	NotaDto getById(int id);

	void update(NotaDto nota);

	void delete(int id);

}
