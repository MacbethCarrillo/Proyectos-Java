/*
 * -PROGRAMACION ORIENTADA A OBJETOS-
 * 
 * ALUMNO: MACBETH ADOLFO CARRILLO IBARRA
 * 
 * NO.CONTROL: 19170557
 * 
 * SEMESTRE: 5
 * 
 * PROFESOR: ALDO URIARTE PORTILLO
 * 
 */
package practica;

public class Materia {

		private int idMateria;
			private String descripcion;
			private int creditos;
			private String carreraGrupo;
			private int alumnosMax;
			private int alumnosActual;
			private double calificacion;

			@Override
			public String toString() {
				return "idMateria=" + idMateria + ", descripcion=" + descripcion + ", creditos=" + creditos
						+ ", carreraGrupo=" + carreraGrupo + ", alumnosMax=" + alumnosMax + ", alumnosActual="
						+ alumnosActual + ", calificacion=" + calificacion ;
			}



			public Materia(int idMateria, String descripcion, int creditos, String carreraGrupo, int alumnosMax,int alumnosActual, double calificacion) {
				super();
				this.idMateria = idMateria;
				this.descripcion = descripcion;
				this.creditos = creditos;
				this.carreraGrupo = carreraGrupo;
				this.alumnosMax = alumnosMax;
				this.alumnosActual = alumnosActual;
				this.calificacion = calificacion;
			}


			public Materia(int idMateria, double calificacion) {
				this.idMateria = idMateria;

				this.calificacion = 0;

				
			}

			public int getIdMateria() {
				return idMateria;
			}



			public void setIdMateria(int idMateria) {
				this.idMateria = idMateria;
			}



			public String getDescripcion() {
				return descripcion;
			}



			public void setDescripcion(String descripcion) {
				this.descripcion = descripcion;
			}



			public int getCreditos() {
				return creditos;
			}



			public void setCreditos(int creditos) {
				this.creditos = creditos;
			}



			public String getCarreraGrupo() {
				return carreraGrupo;
			}



			public void setCarreraGrupo(String carreraGrupo) {
				this.carreraGrupo = carreraGrupo;
			}



			public int getAlumnosMax() {
				return alumnosMax;
			}



			public void setAlumnosMax(int alumnosMax) {
				this.alumnosMax = alumnosMax;
			}



			public int getAlumnosActual() {
				return alumnosActual;
			}



			public void setAlumnosActual(int alumnosActual) {
				this.alumnosActual = alumnosActual;
			}



			public double getCalificacion() {
				return calificacion;
			}



			public void setCalificacion(double calificacion) {
				this.calificacion = calificacion;
			}
		}