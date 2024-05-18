import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class bedroom extends JFrame {

	JLabel bg,idlepos,dance,books,laptop,sofa,HomeBtn;
	JLabel homebtn,bathroombtn,bedroombtn,playgroundbtn,kitchenbtn,swtch;
	private JPanel contentPane;
	int status;
	private JLabel lblNewLabel;
	private JLabel chair;
	private JLabel idleposbedroom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bedroom frame = new bedroom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bedroom() {
		setUndecorated(true);
		setBounds(10 ,10, 1920, 900);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1920, 1200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//Main character
				idlepos = new JLabel("");
				idlepos.setBounds(984, 521, 230, 230);
				panel.add(idlepos);
				idlepos.setIcon(new ImageIcon(MainApp.class.getResource("images/idle.gif")));
		
		//Home
		homebtn = new JLabel("Home");
		homebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainApp a = new MainApp();
				a.setVisible(true);
				bedroom.this.dispose();
			}
		});
		homebtn.setBounds(318, 44, 98, 40);
		panel.add(homebtn);
		
		//Bathroom
		bathroombtn = new JLabel("Bathroom");
		bathroombtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bathroom a = new bathroom();
				a.setVisible(true);
				bedroom.this.dispose();
			}
		});
		bathroombtn.setBounds(488, 44, 98, 40);
		panel.add(bathroombtn);
		
		//PlayGround
		playgroundbtn = new JLabel("Playground");
		playgroundbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playground a = new playground();
				a.setVisible(true);
				bedroom.this.dispose();
			}
		});
		playgroundbtn.setBounds(634, 44, 98, 40);
		panel.add(playgroundbtn);
		
		//Bedroom
		bedroombtn = new JLabel("Bedroom");
		bedroombtn.setBounds(798, 44, 98, 40);
		panel.add(bedroombtn);

		//Kitchen
		kitchenbtn = new JLabel ("Kitchen");
		kitchenbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kitchen b = new kitchen();
				b.setVisible(true);
				bedroom.this.dispose();
				}
				});
				kitchenbtn.setBounds(962, 44, 98, 40);
				panel.add(kitchenbtn);


		
		
		
	
		//Light Switch Button
		swtch = new JLabel("");
		swtch.setBounds(272, 288, 33, 58);
		swtch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(status == 0) {
					bg.setIcon(new ImageIcon(MainApp.class.getResource("images/sleepingbed.gif")));
					idlepos.setVisible(false);
					status = 1;
					
				}
				else if(status == 1) {
					bg.setIcon(new ImageIcon(MainApp.class.getResource("images/bedroomLight.png")));
					idlepos.setVisible(true);
					status = 0;
					
					
				}
			}
		});
		panel.add(swtch);
		
		
		idleposbedroom = new JLabel("");
		idleposbedroom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idlepos.setBounds(984, 521, 230, 230);
			}
		});
		idleposbedroom.setBounds(931, 681, 320, 70);
		panel.add(idleposbedroom);
		
		
		chair = new JLabel("");
		chair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idlepos.setIcon(new ImageIcon(MainApp.class.getResource("images/idle.gif")));
				idlepos.setBounds(160, 400, 239, 230);
			}
		});
		chair.setBounds(160, 400, 239, 230);
		panel.add(chair);
		
	
		
		//Main Background
		bg = new JLabel("");
		bg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		bg.setBounds(0, 0, 1600, 900);
		panel.add(bg);
		bg.setIcon(new ImageIcon(MainApp.class.getResource("images/bedroomLight.png")));
		
		
		try {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image cursorImage = toolkit.getImage("C:\\Users\\HUAWEI\\Desktop\\PET\\src\\Start\\Cursors.png");
			Cursor customCursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "CustomCursor");
			setCursor(customCursor);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error setting custom cursor: " + e.getMessage());
		}
		}
		
		
	}

