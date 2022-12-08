package cu.edu.cujae.pweb.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AnnoBean {
	
	private int idanno;
	private int anno;

	public int getIdanno() {
		return idanno;
	}

	public void setIdanno(int idanno) {
		this.idanno = idanno;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

}
