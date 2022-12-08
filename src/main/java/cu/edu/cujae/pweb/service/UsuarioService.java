package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.UsuarioDto;

public interface UsuarioService {
	
	void createUsuario(UsuarioDto usuario);
	
	List<UsuarioDto> listUsuarios();
	
	UsuarioDto getUsuarioById(int userId);
	
	void updateUsuario(UsuarioDto usuario);
	
	void deleteUsuario(int id);

}
