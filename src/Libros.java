public class Libros{
    protected String titulo;
    protected String fechaPublicacion;
    protected String autor;
    protected String editoria;
    protected String genero;

    public Libros(String titulo, String fechaPublicacion, String autor, String editoria, String genero) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.editoria = editoria;
        this.genero = genero;
    }

    public void libroReservado(){
        System.out.println("|Titulo: " + titulo + " |Autor: " + autor + " |Genero:" + genero + " |Publiacion: " + fechaPublicacion + " |Editoria: " + editoria);
    }


    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaPublicacion() {
        return this.fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditoria() {
        return this.editoria;
    }

    public void setEditoria(String editoria) {
        this.editoria = editoria;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    

}