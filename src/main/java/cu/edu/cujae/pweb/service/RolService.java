package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.RolDto;

public interface RolService {
	
	List<RolDto> listRoles();
	
	RolDto getRolById(int id);

}
