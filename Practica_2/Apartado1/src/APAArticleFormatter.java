import java.util.List;
/**
 * Esta clase APAArticleFormatter es una herencia de la clase ArticleFormatter.
 * Formatea un articulo con estilo APA.
 */
public class APAArticleFormatter extends ArticleFormatter {
	/**
	 * An example:
	 * 
	 * Last name, Initials. (Year). Article title. Journal Name, Volume(Issue).
	 **/
	/**
	 * Constructor de la clase APAArticleFormatter
 	 */
	public APAArticleFormatter(){
		super("APA");
	}
	/**
	 * Este metodo formatea la lista de autores de un articulo.
	 * @param authors lista de autores
	 * @return lista de autores formateada
	 */
	@Override
	public String formatAuthorsList(List<Author> authors) {
		StringBuffer sb = new StringBuffer();
		for (Author a : authors) {
			sb.append((sb.length()>0)?", ":"");
			sb.append(a.getLastName() + ", "  + a.getInitial() + ".");
		}
		return sb.toString();
	}
	/**
	 * Este metodo formatea un articulo.
	 * @param a articulo
	 * @return articulo formateado
	 */
	@Override
	public String formatReference(Article a) {
		return formatAuthorsList(a.getAuthors()) + " "+
			   "(" + a.getYear() + "). " + 
			   a.getTitle() + ". " + a.getJournal() + ", " +
			   a.getVolume() + "(" + a.getIssue() + ").";
	}
}
