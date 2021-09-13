package com.curso.coches.exception;

public class GestionCocheException extends RuntimeException {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String matricula;
		private String mensaje;
		
		public GestionCocheException(String matricula) {
			super();
			this.matricula = matricula;
			this.mensaje = "";
		}
		
		public GestionCocheException(String matricula, String mensaje) {
			super();
			this.matricula = matricula;
			this.mensaje = mensaje;
		}

		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public String getMensaje() {
			return mensaje;
		}

		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}
		
		
		
		
		
		
}
