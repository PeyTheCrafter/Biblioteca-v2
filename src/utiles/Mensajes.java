package utiles;

public enum Mensajes {
	ErrorIsbnRepetido("ISBN repetido."), ErrorIsbnInvalido("ISBN incorrecto."), ErrorInsercion(
			"Error al insertar el libro."), ExitoInsercion(
					"Libro a�adido correctamente."), ErrorMemoria("Memoria llena."), ErrorBorrar(
							"Error al borrar el libro."), ExitoBorrar("Libro borrado con �xito"), ExitoModificacion(
									"Libro modificado con �xito."), ErrorModificacion("Error al modificar el libro.");

	String mensaje;

	private Mensajes(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return mensaje.toString();
	}
}
