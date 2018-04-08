package pe.com.ejemplo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class RecibirMensaje {
	
	public void recibirMensajeAMQ(){
		
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection conn = null;
		Session session = null;
		
		try{
			conn = cf.createConnection();
			conn.start();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = new ActiveMQQueue("queue.ejemplo");
			MessageConsumer consumer = session.createConsumer(destination);
			
			Message message = consumer.receive();
			
			TextMessage textMessage = (TextMessage) message;
			
			System.out.println("Se obtuvo mensaje: " + textMessage.getText());
			
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
