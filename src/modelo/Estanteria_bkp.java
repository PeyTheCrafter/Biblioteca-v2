package modelo;

public class Estanteria_bkp {
	private Libro[] libros;

	public Estanteria_bkp(int tamano) {
		this.libros = new Libro[tamano];
	}

	/**
	 * Calcula el tama�o del array.
	 * 
	 * @return
	 */
	public int getTamano() {
		return this.libros.length;
	}

	public int getUsoMemoria() {
		int contador = 0;
		for (Libro libro : libros) {
			if (libro != null) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * PROPIO. Busca el primer hueco libre que haya.
	 * 
	 * @return el �ndice del hueco encontrado.
	 */
	public int buscarEspacio() {
		for (int i = 0; i < this.libros.length; i++) {
			if (this.libros[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Obtiene el libro en la posici�n.
	 * 
	 * @param posicion
	 *            la posici�n.
	 * @return el libro si lo ha encontrado, null si no.
	 */
	public Libro obtenerLibro(int posicion) {
		return this.getLibros()[posicion];
	}

	/**
	 * PROPORCIONADO. Inserta un libro en el array.
	 * 
	 * @param libro:
	 *            el libro a insertar.
	 * @return true si lo ha guardado, false si no.
	 */
	public boolean insertarLibro(Libro libro) {
		int indice = this.buscarEspacio();
		if (indice != -1 && !this.comprobarISBNRepetido(libro.getIsbn())) {
			this.libros[indice] = libro;
			return this.libros[indice] != null;
		} else {
			return false;
		}
	}

	/**
	 * PROPORCIONADO. Busca la posici�n del un libro por su nombre.
	 * 
	 * @param nombre:
	 *            nombre del libro a buscar.
	 * @return la posici�n si lo ha encontrado, -1 si no.
	 */
	public int posicionLibro(String nombre) {
		for (int i = 0; i < this.getLibros().length; i++) {
			if (this.getLibros()[i] != null
					&& this.getLibros()[i].getTitulo().toLowerCase().equals(nombre.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * PROPIO. Busca la posici�n del un libro por su ISBN.
	 * 
	 * @param nombre:
	 *            ISBN del libro a buscar.
	 * @return la posici�n si lo ha encontrado, -1 si no.
	 */
	public int posicionLibroISBN(String isbn) {
		for (int i = 0; i < this.getLibros().length; i++) {
			if (this.getLibros()[i] != null && this.getLibros()[i].getIsbn().toLowerCase().equals(isbn.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Obtiene la posici�n de un libro por su nombre.
	 * 
	 * @param nombre
	 *            nombre del libro a buscar.
	 * @return la posici�n si lo encuentra, -1 si no.
	 */
	public int posicionLibroNombre(String nombre) {
		for (int i = 0; i < this.getLibros().length; i++) {
			if (this.getLibros()[i] != null
					&& this.getLibros()[i].getTitulo().toLowerCase().equals(nombre.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Borra la posici�n.
	 * 
	 * @param indice
	 *            la posici�n a borrar.
	 * @return true si se ha borrado, false si no.
	 */
	public boolean borrarLibroPosicion(int indice) {
		if (indice >= 0 && indice < this.libros.length) {
			Libro libro = this.getLibros()[indice];
			if (libro != null) {
				this.getLibros()[indice] = null;
			}
			return this.getLibros()[indice] == null;
		}
		return false;
	}

	/**
	 * PROPIO. Borra un libro por su ISBN.
	 * 
	 * @param nombre:
	 *            el ISBN del libro.
	 * @return true si lo borra, false si no.
	 */
	public boolean borrarLibroISBN(String isbn) {
		int indice = this.posicionLibroISBN(isbn);
		System.out.println(indice);
		this.libros[indice] = null;
		return this.libros[indice] == null;
	}

	/**
	 * PROPIO. Comprueba si el ISBN del libro est� repetido.
	 * 
	 * @param isbn:
	 *            el c�digo a comprobar.
	 * @return true si est� repetido, false si no.
	 */
	private boolean comprobarISBNRepetido(String isbn) {
		for (int i = 0; i < this.libros.length; i++) {
			if (this.libros[i] != null && this.libros[i].getIsbn().equals(isbn)) {
				return true;
			}
		}
		return false;
	}

	public Libro[] getLibros() {
		return libros;
	}

}
