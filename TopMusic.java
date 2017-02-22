package listadoEstructuras3SanchezSantacruzAntonioJesus;

import java.util.ArrayList;

import utiles.Menu;

/**
 * 
 * @author Antonio Jesús Sánchez Santacruz
 * @version 1.0
 *
 */
public class TopMusic {
	/**
	 * Lista para almacenar canciones
	 */
	private ArrayList<Cancion> lista;

	public TopMusic() {
		lista = new ArrayList<Cancion>();
	}

	boolean isEmpty() {
		return lista.isEmpty();
	}

	/**
	 * Muestra la cancion que esta en el top
	 * 
	 * @param lista
	 */
	Cancion topLista() {
		if (lista.size() == 0)
			return null;

		return lista.get(0);
	}

	/**
	 * Baja un puesto una cancion elegida
	 * 
	 * @param lista
	 */
	String bajarPuesto(int posicion) {

		if (lista.size() == 0 || posicion - 1 < 0 || posicion >= lista.size())
			return "\nError al bajar un puesto";
		
		lista.add(lista.remove(posicion - 1));
		return "\nSe ha bajado un puesto";

	}

	/**
	 * Sube un puesto una cancion elegida
	 * 
	 * @param lista
	 */
	String subirPuesto(int posicion) {
		if (lista.size() == 0 || posicion < lista.size() || posicion - 1 == 0)
			return "\nERROR al subir un puesto";

		lista.add(posicion - 2, lista.remove(posicion - 1));
		return "\nSe ha subido un puesto";
	}

	/**
	 * Muestra la lista de las canciones
	 * 
	 * @param lista
	 */
	StringBuilder mostrarLista() {
		StringBuilder cadena = new StringBuilder();
		int i = 0;
		if (lista.isEmpty())
			cadena.append("\nLa lista esta vacia. Por favor introduzca alguna cancion");

		for (Cancion cancion : lista) {
			cadena.append("\n\t" + ++i + ". " + cancion);
		}
		return cadena;
	}

	/**
	 * Elimina una cancion de la lista
	 * 
	 * @param lista
	 */
	String eliminarCancion(int posicion) {
		if (lista.isEmpty() || posicion - 1 < 0 || posicion > lista.size())
			return "\nERROR al eliminar una canción";

		return "\nSe ha borrado la canción: " + lista.remove(posicion - 1);

	}

	/**
	 * AÃ±ade una cancion a la lista
	 * 
	 * @param lista
	 */
	String aniadirCancion(int posicion, Cancion cancion) {
		if (!esPosicionValida(posicion)) {
			return null;
		}
		lista.add(posicion, cancion);
		return "\nSe ha añadido una canción";
	}

	/**
	 * Genera un menu con las canciones
	 * 
	 * @param lista
	 * @return Opcion elegida del menu
	 */
	int listarCanciones() {
		if (lista.isEmpty())
			return -1;

		int i = 0;
		String[] opciones = new String[lista.size()];

		for (Cancion cancion : lista) {
			opciones[i] = cancion.toString();
			i++;
		}
		Menu menuCanciones = new Menu("\n---Menú Canciones---", opciones);

		return menuCanciones.gestionar();
	}

	/**
	 * Devuelve el tamaño de la lista
	 * 
	 * @return Tamaño de la lista
	 */
	int size() {
		return lista.size();
	}

	/**
	 * Indica si una posicion es valida o no
	 * 
	 * @param posicion
	 * @return True si es valida. False si no es valida
	 */
	boolean esPosicionValida(int posicion) {
		if (posicion < 0 || posicion > size())
			return false;

		return true;
	}
}