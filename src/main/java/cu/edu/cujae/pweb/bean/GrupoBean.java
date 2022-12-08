package cu.edu.cujae.pweb.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GrupoBean {
	
	private int idgrupo;
	private int idanno;
	private int grupo;

	public int getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}

	public int getIdanno() {
		return idanno;
	}

	public void setIdanno(int idanno) {
		this.idanno = idanno;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

}
