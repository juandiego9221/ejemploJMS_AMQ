package pe.com.ejemplo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;


public class EnviarMensaje {
	
	public void enviarMensajeAMQ(){
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection conn = null;
		Session session = null;
		
		
		try{
			conn = cf.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = new ActiveMQQueue("queue.ejemplo");
			MessageProducer producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage();
			
			message.setText("Hola mundo - Ejemplo AMQ");
			producer.send(message);

		}catch(JMSException e){
			System.out.println("Excepcion " + e);
		}finally {
			try{
				if(session!=null){
					session.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception ex){
				System.out.println("Excepcion " + ex);

			}
		}
		
	}
	
	
	

}
