package pe.com.ejemplo;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EnviarMensaje enviarMensaje = new EnviarMensaje();
        enviarMensaje.enviarMensajeAMQ();
    }
}
