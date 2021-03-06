package modelo;

import java.util.ArrayList;

public class Estanteria {
	private ArrayList<Libro> libros;

	public Estanteria() {
		this.libros = new ArrayList<>();
	}

	/**
	 * Calcula el tama�o del array.
	 * 
	 * @return
	 */
	public int getTamano() {
		return this.libros.size();
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
	 * Obtiene el libro en la posici�n.
	 * 
	 * @param posicion
	 *            la posici�n.
	 * @return el libro si lo ha encontrado, null si no.
	 */
	public Libro obtenerLibro(int posicion) {
		return this.getLibros().get(posicion);
	}

	/**
	 * PROPORCIONADO. Inserta un libro en el array.
	 * 
	 * @param libro:
	 *            el libro a insertar.
	 * @return true si lo ha guardado, false si no.
	 */
	public boolean insertarLibro(Libro libro) {
		if (!this.comprobarISBNRepetido(libro.getIsbn())) {
			return this.getLibros().add(libro);
		}
		return false;
	}
	
	public boolean insertarLibro(Libro libro, int posicion) {
		assert posicion >=0;
		if(!this.comprobarISBNRepetido(libro.getIsbn())) {
			this.getLibros().add(posicion, libro);
		}
		return this.obtenerLibro(posicion) != null && this.obtenerLibro(posicion).getIsbn().equals(libro.getIsbn());
	}

	/**
	 * PROPORCIONADO. Busca la posici�n del un libro por su nombre.
	 * 
	 * @param nombre:
	 *            nombre del libro a buscar.
	 * @return la posici�n si lo ha encontrado, -1 si no.
	 */
	public int posicionLibro(String nombre) {
		for (int i = 0; i < this.getLibros().size(); i++) {
			if (this.getLibros().get(i).getTitulo().toLowerCase().equals(nombre.toLowerCase())) {
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
		for (int i = 0; i < this.getLibros().size(); i++) {
			if (this.getLibros().get(i).getIsbn().toLowerCase().equals(isbn.toLowerCase())) {
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
		for (int i = 0; i < this.getLibros().size(); i++) {
			if (this.getLibros().get(i).getTitulo().toLowerCase().equals(nombre.toLowerCase())) {
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
		if (indice >= 0 && indice < this.libros.size()) {
			Libro libro = this.getLibros().get(indice);
			return this.getLibros().remove(indice) != null;
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
		return this.getLibros().remove(indice) != null;
	}

	/**
	 * PROPIO. Comprueba si el ISBN del libro est� repetido.
	 * 
	 * @param isbn:
	 *            el c�digo a comprobar.
	 * @return true si est� repetido, false si no.
	 */
	private boolean comprobarISBNRepetido(String isbn) {
		if (this.getLibros().size() == 0) {
			for (int i = 0; i < this.libros.size(); i++) {
				if (this.getLibros().get(i) != null && this.getLibros().get(i).getIsbn().equals(isbn)) {
					return true;
				}
			}
		}
		return false;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

}
