import java.util.List;
/**
 * Esta clase ArticleFormatter es una clase abstracta que formatea un articulo.
 */
public abstract class ArticleFormatter {
	protected String name;
	
	public abstract String formatAuthorsList(List<Author> authors);
	public abstract String formatReference(Article a);
	/**
	 * Constructor de la clase ArticleFormatter
	 * @param formatterName nombre del formateador
	 */
	public ArticleFormatter(String formatterName) {
		this.name = formatterName;
	}
	
	public String getName() {
		return this.name;
	}
	/**
	 * Este metodo formatea una lista de articulos.
	 * @param articles lista de articulos
	 * @return lista de articulos formateada
	 */
	public String format(List<Article> articles) {
		String result = "";
		for (Article a : articles) 
			result+= this.formatReference(a)+"\n";
		return result;		
	}
}
