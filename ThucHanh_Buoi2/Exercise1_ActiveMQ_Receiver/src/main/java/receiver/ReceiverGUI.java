package receiver;

import java.awt.EventQueue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.TextArea;
import java.util.Properties;
import java.awt.Dimension;
import javax.swing.JLabel;

public class ReceiverGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiverGUI frame = new ReceiverGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws NamingException
	 * @throws JMSException
	 */
	public ReceiverGUI() throws NamingException, JMSException {
		setTitle("Receiver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 446, 252);
		contentPane.add(panel);
		panel.setLayout(null);

		textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(4, 22));
		textArea.setName("Receiver");
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 22));
		textArea.setEditable(false);
		textArea.setBounds(55, 38, 341, 159);
		panel.add(textArea);
		
		// thi???t l???p m??i tr?????ng cho JMS
		BasicConfigurator.configure();
		// thi???t l???p m??i tr?????ng cho JJNDI
		Properties settings = new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		// t???o context
		Context ctx = new InitialContext(settings);
		// lookup JMS connection factory
		Object obj = ctx.lookup("ConnectionFactory");
		ConnectionFactory factory = (ConnectionFactory) obj;
		// lookup destination
		Destination destination = (Destination) ctx.lookup("dynamicQueues/nguyenviethoc");
		// t???o connection
		Connection con = factory.createConnection("admin", "admin");
		// n???i ?????n MOM
		con.start();
		// t???o session
		Session session = con.createSession(/* transaction */false, /* ACK */Session.CLIENT_ACKNOWLEDGE);
		// t???o consumer
		MessageConsumer receiver = session.createConsumer(destination);
		// blocked-method for receiving message - sync
		// receiver.receive();
		// Cho receiver l???ng nghe tr??n queue, ch???ng c?? message th?? notify - async
		System.out.println("T?? was listened on queue...");
		receiver.setMessageListener(new MessageListener() {
			// c?? message ?????n queue, ph????ng th???c n??y ???????c th???c thi
			public void onMessage(Message msg) {// msg l?? message nh???n ???????c
				try {
					if (msg instanceof TextMessage) {
						TextMessage tm = (TextMessage) msg;
						String txt = tm.getText() + "\n";
						textArea.setText(txt);
						System.out.println("Nh???n ???????c " + txt);
						msg.acknowledge();// g???i t??n hi???u ack
					} else if (msg instanceof ObjectMessage) {
						ObjectMessage om = (ObjectMessage) msg;
						System.out.println(om);
					}
					// others message type....
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
