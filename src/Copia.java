public class Copia extends Libros {
    private int IDcopia;
    private String codigoBarra;
    private String ubicacionCopia;
    
    

    public Copia(int IDcopia, String codigoBarra, String ubicacionCopia, String titulo, String fechaPublicacion, String autor, String editoria, String genero) {
        super(titulo, fechaPublicacion, autor, editoria, genero);
        this.IDcopia = IDcopia;
        this.codigoBarra = codigoBarra;
        this.ubicacionCopia = ubicacionCopia;
    }
    
    @Override
    public void libroReservado() {
    super.libroReservado();
    System.out.println("\n\n La identificacion de esta copia: " + IDcopia + " |Codigo de barra: " + codigoBarra + " |Ubicacion: " + ubicacionCopia);
    }


    public int getIDcopia() {
        return this.IDcopia;
    }

    public void setIDcopia(int IDcopia) {
        this.IDcopia = IDcopia;
    }

    public String getCodigoBarra() {
        return this.codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getUbicacionCopia() {
        return this.ubicacionCopia;
    }

    public void setUbicacionCopia(String ubicacionCopia) {
        this.ubicacionCopia = ubicacionCopia;
    }


}
