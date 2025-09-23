public class Reserva extends Usuarios{
    //private int Reservas;

    @Override
    public void UserAdd(int ID, String nombre, String email){
        System.out.println("Reserva creada exitosamente" + "\nNombre: " + nombre + "\nCorreo: " + email + "\n ID Usuario: " + ID);
    }
    
}
