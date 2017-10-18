package metier;

public class ValidatorPerson {

	private boolean error = false;
	private String nameError = "";
	private String emailError = "";

	public boolean hasError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getNameError() {
		return nameError;
	}

	public void setNameError(String nameError) {
		this.nameError = nameError;
	}

	public String getEmailError() {
		return emailError;
	}

	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}

}
