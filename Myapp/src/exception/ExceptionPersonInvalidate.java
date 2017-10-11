package exception;

public class ExceptionPersonInvalidate extends Exception {
	private String nomValide;
	private String emailValide;
	
	public ExceptionPersonInvalidate() {
		// TODO Auto-generated constructor stub
		this.emailValide = "";
		this.nomValide = "";
	}

	public String getNomValide() {
		return nomValide;
	}

	public void setNomValide(String nomValide) {
		this.nomValide = nomValide;
	}

	public String getEmailValide() {
		return emailValide;
	}

	public void setEmailValide(String emailValide) {
		this.emailValide = emailValide;
	}

	
		
}
