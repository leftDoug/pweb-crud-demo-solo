package cu.edu.cujae.pweb.dto;

public class NotaDto {

	private int idnota;
	private int idasignatura;
	private int idevaluacion;
	private int idestudiante;
	private String evaluacion;

	public NotaDto() {
		// TODO Auto-generated constructor stub
	}

	public NotaDto(int idnota, int idasignatura, int idevaluacion, int idestudiante) {
		super();
		this.idnota = idnota;
		this.idasignatura = idasignatura;
		this.idevaluacion = idevaluacion;
		this.idestudiante = idestudiante;
		notaToString();
	}

	public int getIdnota() {
		return idnota;
	}

	public void setIdnota(int idnota) {
		this.idnota = idnota;
	}

	public int getIdasignatura() {
		return idasignatura;
	}

	public void setIdasignatura(int idasignatura) {
		this.idasignatura = idasignatura;
	}

	public int getIdevaluacion() {
		return idevaluacion;
	}

	public void setIdevaluacion(int idevaluacion) {
		this.idevaluacion = idevaluacion;
	}

	public int getIdestudiante() {
		return idestudiante;
	}

	public void setIdestudiante(int idestudiante) {
		this.idestudiante = idestudiante;
	}

	public String getEvaluacion() {
		return evaluacion;
	}

	public void notaToString() {

		switch (idevaluacion) {
		case 5:
			evaluacion = "Excelente";
			break;
		case 4:
			evaluacion = "Bien";
			break;
		case 3:
			evaluacion = "Aprobado";
			break;
		case 2:
			evaluacion = "Suspenso";
			break;

		default:
			break;
		}
	}

}
