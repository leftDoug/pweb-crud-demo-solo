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

import cu.edu.cujae.pweb.dto.NotaDto;
import cu.edu.cujae.pweb.service.NotaService;
import cu.edu.cujae.pweb.utils.JsfUtils;

@Component
@ManagedBean
@ViewScoped
public class ManageNotaBean {

	private NotaDto nota;
	private NotaDto selectedNota;
	private List<NotaDto> notas;
	
	@Autowired
	private NotaService notaService;

	public ManageNotaBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		notas = notas == null ? notaService.list() : notas;
	}
	
	public void openNew() {
		this.selectedNota = new NotaDto();
	}
	
	public void openForEdit() {
		
	}

	public NotaDto getAsignatura() {
		return nota;
	}

	public void setNota(NotaDto nota) {
		this.nota = nota;
	}

	public NotaDto getSelectedNota() {
		return selectedNota;
	}

	public void setSelectedNota(NotaDto selectedNota) {
		this.selectedNota = selectedNota;
	}

	public List<NotaDto> getNotas() {
		return notas;
	}

	public void setNotas(List<NotaDto> notas) {
		this.notas = notas;
	}

	public NotaService getNotaService() {
		return notaService;
	}

	public void setNotaService(NotaService notaService) {
		this.notaService = notaService;
	}
	
	public void deleteNota() {
    	try {
    		this.notas.remove(this.selectedNota);
            this.selectedNota = null;
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_nota_deleted");
            PrimeFaces.current().ajax().update("form:dt-notas");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
		} catch (Exception e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
		}
        
    }
	
	public void saveNota() {
        if (this.selectedNota.getIdnota() == 0) {
            this.selectedNota.setIdnota(new Random(System.currentTimeMillis()).nextInt());
            
            this.notas.add(this.selectedNota);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_nota_added"); //Este code permite mostrar un mensaje exitoso (FacesMessage.SEVERITY_INFO) obteniendo el mensage desde el fichero de recursos, con la llave message_user_added
        }
        else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_nota_edited");
        }

        PrimeFaces.current().executeScript("PF('manageNotaDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
        PrimeFaces.current().ajax().update("form:dt-notas");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
    }

}
