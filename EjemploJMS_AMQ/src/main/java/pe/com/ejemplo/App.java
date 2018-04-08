package pe.com.ejemplo;


public class App 
{
    public static void main( String[] args )
    {
    	
        System.out.println( "Hello World!" );
        RecibirMensaje recibirMensaje = new RecibirMensaje();
        //EnviarMensaje enviarMensaje = new EnviarMensaje();
        //enviarMensaje.enviarMensajeAMQ();
        recibirMensaje.recibirMensajeAMQ();
    }
}
