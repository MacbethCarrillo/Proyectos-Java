public class Contacto {

	private int idContacto;
	private String nombre;
	private String apellido;
	private String alias;
	private String tipoTelefono;
	private String email;
	private int numTelefonico;

	@Override
	public String toString() {
		return "idContacto=" + idContacto + ", nombre=" + nombre + ", apellido=" + apellido + ", alias=" + alias
				+ ", tipoTelefono=" + tipoTelefono + ", email=" + email + ", numTelefonico=" + numTelefonico;
	}

	public Contacto() {

	}

	public Contacto(int idContacto, String nombre, String apellido, String alias, String tipoTelefono, String email,
			int numTelefonico) {

		this.idContacto = idContacto;
		this.nombre = nombre;
		this.apellido = apellido;
		this.alias = alias;
		this.tipoTelefono = tipoTelefono;
		this.email = email;
		this.numTelefonico = numTelefonico;

	}

	public Contacto(String nombre, int numTelefonico) {

		this.nombre = nombre;
		this.numTelefonico = 0;

	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public int getNumTelefonico() {
		return numTelefonico;
	}

	public void setNumTelefonico(int numTelefonico) {
		this.numTelefonico = numTelefonico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Contacto c) {
		if (this.nombre.equalsIgnoreCase(c.getNombre())) {
			return true;
		}
		return false;
	}
}