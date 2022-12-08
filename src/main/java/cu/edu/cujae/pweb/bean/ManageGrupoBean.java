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

import cu.edu.cujae.pweb.dto.GrupoDto;
import cu.edu.cujae.pweb.service.GrupoService;
import cu.edu.cujae.pweb.utils.JsfUtils;

@Component
@ManagedBean
@ViewScoped
public class ManageGrupoBean {

	private GrupoDto grupo;
	private GrupoDto selectedGrupo;
	private List<GrupoDto> grupos;
	
	@Autowired
	private GrupoService grupoService;

	public ManageGrupoBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		grupos = grupos == null ? grupoService.listGrupos() : grupos;
	}
	
	public void openNew() {
		this.selectedGrupo = new GrupoDto();
	}
	
	public void openForEdit() {
		
	}

	public GrupoDto getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoDto grupo) {
		this.grupo = grupo;
	}

	public GrupoDto getSelectedGrupo() {
		return selectedGrupo;
	}

	public void setSelectedGrupo(GrupoDto selectedGrupo) {
		this.selectedGrupo = selectedGrupo;
	}

	public List<GrupoDto> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<GrupoDto> grupos) {
		this.grupos = grupos;
	}

	public GrupoService getGrupoService() {
		return grupoService;
	}

	public void setGrupoService(GrupoService grupoService) {
		this.grupoService = grupoService;
	}
	
	public void deleteGrupo() {
    	try {
    		this.grupos.remove(this.selectedGrupo);
            this.selectedGrupo = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_grupo_deleted");
            PrimeFaces.current().ajax().update("form:dt-grupos");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
		} catch (Exception e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
		}
        
    }
	
	public void saveGrupo() {
        if (this.selectedGrupo.getIdgrupo() == 0) {
            this.selectedGrupo.setIdgrupo(new Random(System.currentTimeMillis()).nextInt());
            
            this.grupos.add(this.selectedGrupo);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_asignatura_added"); //Este code permite mostrar un mensaje exitoso (FacesMessage.SEVERITY_INFO) obteniendo el mensage desde el fichero de recursos, con la llave message_user_added
        }
        else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_asignatura_edited");
        }

        PrimeFaces.current().executeScript("PF('manageGrupoDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
        PrimeFaces.current().ajax().update("form:dt-grupos");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
    }

}
