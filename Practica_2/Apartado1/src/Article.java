import java.util.List;
/**
 * Esta clase Article es una clase que crea un objeto articulo.
 */
public class Article{
	private List<Author> authors;
	private int year, volume, issue;
	private String title, journal;
	/**
	 * Constructor de la clase Article
	 * @param authors lista de autores
	 * @param year año de publicacion
	 * @param title titulo del articulo
	 * @param journal nombre de la revista
	 * @param vol volumen de la revista
	 * @param issue numero de la revista
	 */
	public Article(List<Author> authors, int year, String title, String journal, 
			       int vol, int issue) {
		this.authors = authors;
		this.year = year;
		this.title = title;
		this.journal = journal;
		this.volume = vol;
		this.issue = issue;		
	}
	/**
	 * Este metodo obtiene la lista de autores del articulo
	 * @return lista de autores
	 */
	public List<Author> getAuthors() {
		return authors;
	}
	/**
	 * Este metodo obtiene el año de publicacion del articulo
	 * @return año de publicacion
	 */
	public int getYear() {
		return year;
	}
	/**
	 * Este metodo obtiene el titulo del articulo
	 * @return titulo del articulo
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Este metodo obtiene el nombre de la revista del articulo
	 * @return nombre de la revista
	 */
	public String getJournal() {
		return journal;
	}

	public int getVolume() {
		return volume;
	}

	public int getIssue() {
		return issue;
	}
}
