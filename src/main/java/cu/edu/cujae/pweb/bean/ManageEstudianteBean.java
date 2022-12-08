package cu.edu.cujae.pweb.bean;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.EstudianteDto;
import cu.edu.cujae.pweb.service.EstudianteService;
import cu.edu.cujae.pweb.utils.JsfUtils;

@Component
@ManagedBean
@ViewScoped
public class ManageEstudianteBean {

	private EstudianteDto estudiante;
	private EstudianteDto selectedEstudiante;
	private List<EstudianteDto> estudiantes;
	
	@Autowired
	private EstudianteService estudianteService;

	public ManageEstudianteBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		estudiantes = estudiantes == null ? estudianteService.listEstudiantes() : estudiantes;
	}
	
	public void openNew() {
		this.selectedEstudiante = new EstudianteDto();
	}
	
	public void openForEdit() {
		
	}

	public EstudianteDto getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteDto estudiante) {
		this.estudiante = estudiante;
	}

	public EstudianteDto getSelectedEstudiante() {
		return selectedEstudiante;
	}

	public void setSelectedEstudiante(EstudianteDto selectedEstudiante) {
		this.selectedEstudiante = selectedEstudiante;
	}

	public List<EstudianteDto> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<EstudianteDto> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public EstudianteService getEstudianteService() {
		return estudianteService;
	}

	public void setEstudianteService(EstudianteService estudianteService) {
		this.estudianteService = estudianteService;
	}
	
	public void deleteEstudiante() {
    	try {
    		this.estudiantes.remove(this.selectedEstudiante);
            this.selectedEstudiante = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_estudiante_deleted");
            PrimeFaces.current().ajax().update("form:dt-estudiantes");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
		} catch (Exception e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
		}
        
    }
	
	public void saveEstudiante() {
        if (this.selectedEstudiante.getIdestudiante() == 0) {
            this.selectedEstudiante.setIdestudiante(new Random(System.currentTimeMillis()).nextInt());
            
            this.estudiantes.add(this.selectedEstudiante);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_estudiante_added"); //Este code permite mostrar un mensaje exitoso (FacesMessage.SEVERITY_INFO) obteniendo el mensage desde el fichero de recursos, con la llave message_user_added
        }
        else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_estudiante_edited");
        }

        PrimeFaces.current().executeScript("PF('manageEstudianteDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
        PrimeFaces.current().ajax().update("form:dt-estudiantes");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
    }

}
