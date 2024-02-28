
import java.util.List;
/**
 * Esta clase IEEEArticleFormatter es una herencia de la clase ArticleFormatter.
 * Formatea un articulo con estilo IEEE.
 */
public class IEEEArticleFormatter extends ArticleFormatter{
    /**
     * Constructor de la clase IEEEArticleFormatter
     */
    public IEEEArticleFormatter(){
        super("IEEE");
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
            sb.append(a.getInitial() + "."+ a.getLastName()  );
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
        return formatAuthorsList(a.getAuthors()) + ", \""+a.getTitle() +"\"" +", " + a.getJournal()+", "+  "vol. "+ a.getVolume()+", " + "no. "+ a.getIssue()+", " +  a.getYear()+".";

    }

}
