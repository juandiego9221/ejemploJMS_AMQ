package pe.com.ejemplo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EnviarMensaje enviarMensaje = new EnviarMensaje();
        enviarMensaje.enviarMensajeAMQ();
    }
}
