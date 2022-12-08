package cu.edu.cujae.pweb.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioBean {
	
	private int idusuario;
	private int idrol;
	private String usuario;
	private String contrasenna;
	
	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idUsuario) {
		this.idusuario = idUsuario;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idRol) {
		this.idrol = idRol;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

}
