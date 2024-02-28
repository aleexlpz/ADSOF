/**
 * Esta clase Author es una clase que crea un objeto autor con un nombre y un apellido*
 */
public class Author {
	private String lastName;
	private String name;
	/**
	 * Constructor de la clase Author
	 * @param name nombre del autor
	 * @param lastName apellido del autor
	 */
	public Author(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	/**
	 * Este metodo obtiene el apellido del autor
	 * @return apellido del autor
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Este metodo obtiene el nombre del autor
	 * @return nombre del autor
	 */
	public String getName() {
		return name;
	}
	/**
	 * Este metodo obtiene la inicial del nombre del autor
	 * @return inicial del nombre del autor
	 */
	public String getInitial() {
		return name.substring(0, 1).toUpperCase();
	}
}
