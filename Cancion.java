package listadoEstructuras3SanchezSantacruzAntonioJesus;

import java.util.Calendar;

/**
 * 
 * @author Antonio Jesús Sánchez Santacruz
 * @version 1.0
 *
 */
public class Cancion {

	private static Calendar fecha = Calendar.getInstance();

	/**
	 * Año actual
	 */
	private static int anioActual = fecha.get(Calendar.YEAR);

	/**
	 * Titulo de la cancion
	 */
	private String titulo;

	/**
	 * Artista de la cancion
	 */
	private String artista;

	/**
	 * Año de la cancion
	 */
	private int anioGrabacion;

	/**
	 * Constructor de la clase cancion
	 * 
	 * @param titulo
	 * @param artista
	 * @param anioGrabacion
	 */
	private Cancion(String titulo, String artista, int anioGrabacion) {
		setTitulo(titulo);
		setArtista(artista);
		setAnioGrabacion(anioGrabacion);
	}

	/**
	 * Comprueba que los argumentos sean correctos mediante expresiones
	 * regulares
	 * 
	 * @param titulo
	 * @param artista
	 * @param anioGrabacion
	 * @return Cancion
	 */
	static Cancion getInstance(String titulo, String artista, int anioGrabacion) {
		String anio = Integer.toString(anioGrabacion);
		if (!(titulo.matches(".{2,}") && artista.matches(".{2,}") && anio.matches("19\\d{2}|2\\d{3}")
				&& anioGrabacion <= anioActual))
			return null;

		return new Cancion(titulo, artista, anioGrabacion);
	}

	public String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	private void setArtista(String artista) {
		this.artista = artista;
	}

	private void setAnioGrabacion(int anioGrabacion) {
		this.anioGrabacion = anioGrabacion;
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", artista=" + artista + ", anioGrabacion=" + anioGrabacion + "]";
	}

}
