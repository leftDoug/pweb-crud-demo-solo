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

import cu.edu.cujae.pweb.dto.AsignaturaDto;
import cu.edu.cujae.pweb.service.AsignaturaService;
import cu.edu.cujae.pweb.utils.JsfUtils;

@Component
@ManagedBean
@ViewScoped
public class ManageAsignaturaBean {
	
	private AsignaturaDto asignatura;
	private AsignaturaDto selectedAsignatura;
	private List<AsignaturaDto> asignaturas;
	
	@Autowired
	private AsignaturaService asignaturaService;

	public ManageAsignaturaBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		asignaturas = asignaturas == null ? asignaturaService.listAsignaturas() : asignaturas;
	}
	
	public void openNew() {
		this.selectedAsignatura = new AsignaturaDto();
	}
	
	public void openForEdit() {
		
	}

	public AsignaturaDto getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(AsignaturaDto asignatura) {
		this.asignatura = asignatura;
	}

	public AsignaturaDto getSelectedAsignatura() {
		return selectedAsignatura;
	}

	public void setSelectedAsignatura(AsignaturaDto selectedAsignatura) {
		this.selectedAsignatura = selectedAsignatura;
	}

	public List<AsignaturaDto> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<AsignaturaDto> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public AsignaturaService getAsignaturaService() {
		return asignaturaService;
	}

	public void setAsignaturaService(AsignaturaService asignaturaService) {
		this.asignaturaService = asignaturaService;
	}
	
	public void deleteAsignatura() {
    	try {
    		this.asignaturas.remove(this.selectedAsignatura);
            this.selectedAsignatura = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_asignatura_deleted");
            PrimeFaces.current().ajax().update("form:dt-asignaturas");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
		} catch (Exception e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
		}
        
    }
	
	public void saveAsignatrura() {
        if (this.selectedAsignatura.getIdasignatura() == 0) {
            this.selectedAsignatura.setIdasignatura(new Random(System.currentTimeMillis()).nextInt());
            
            this.asignaturas.add(this.selectedAsignatura);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_asignatura_added"); //Este code permite mostrar un mensaje exitoso (FacesMessage.SEVERITY_INFO) obteniendo el mensage desde el fichero de recursos, con la llave message_user_added
        }
        else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_asignatura_edited");
        }

        PrimeFaces.current().executeScript("PF('manageAsignaturaDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
        PrimeFaces.current().ajax().update("form:dt-asignaturas");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
    }

}
