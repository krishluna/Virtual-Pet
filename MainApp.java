import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainApp extends JFrame {

	//private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private Image homeImg = new ImageIcon(MainApp.class.getResource("images/home.jpg")).getImage().getScaledInstance(2000, 2000, Image.SCALE_SMOOTH);
	
	JLabel bg,idlepos,dance,books,laptop,sofa,HomeBtn;
	JLabel homebtn,bathroombtn,bedroombtn,playgroundbtn, kitchenbtn;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					MainApp frame = new MainApp();
					frame.setVisible(true);
			
	}

	/**
	 * Create the frame.
	 */
	public MainApp() {
		setUndecorated(true);
		setBounds(10, 10, 1920, 900);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1920, 1200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Radio Button
		JLabel radio = new JLabel("");
		radio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idlepos.setBounds(266, 582, 230, 230);
				idlepos.setIcon(new ImageIcon(MainApp.class.getResource("images/dance.gif")));;
			}
		});
		radio.setBounds(174, 648, 82, 40);
		panel.add(radio);
		setLocationRelativeTo(null);
		
		//Books Button
		books = new JLabel("");
		books.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idlepos.setBounds(288, 605, 230, 230);
				idlepos.setIcon(new ImageIcon(MainApp.class.getResource("images/reading.gif")));;
			}
		});
		books.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("images/books.png")).getImage().getScaledInstance(191,150, Image.SCALE_SMOOTH)));
		books.setBounds(318, 705, 191, 161);
		panel.add(books);
		
		
		//Laptop Button
		laptop = new JLabel("");
		laptop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idlepos.setBounds(823, 598, 230, 230);
				idlepos.setIcon(new ImageIcon(MainApp.class.getResource("images/idle.gif")));
			}
		});
		laptop.setBounds(1040, 669, 153, 135);
		panel.add(laptop);
		
		
		//Sofa Button
		sofa = new JLabel("");
		sofa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idlepos.setBounds(450, 450, 230, 230);
				idlepos.setIcon(new ImageIcon(MainApp.class.getResource("images/sleeping.gif")));
			}
		});
		sofa.setBounds(329, 498, 540, 176);
		panel.add(sofa);
		
		
		
		//Home
		homebtn = new JLabel("Home");
		homebtn.setBounds(318, 44, 98, 40);
		panel.add(homebtn);
		
		//Bathroom
		bathroombtn = new JLabel("Bathroom");
		bathroombtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bathroom a = new bathroom();
				a.setVisible(true);
				MainApp.this.dispose();
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
				MainApp.this.dispose();
			}
		});
		playgroundbtn.setBounds(634, 44, 98, 40);
		panel.add(playgroundbtn);
		
		
		//Bedroom
		bedroombtn = new JLabel("Bedroom");
		bedroombtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bedroom a = new bedroom();
				a.setVisible(true);
				MainApp.this.dispose();
			}
		});
		bedroombtn.setBounds(798, 44, 98, 40);
		panel.add(bedroombtn);

		//Kitchen
		kitchenbtn = new JLabel ("Kitchen");
		kitchenbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kitchen b = new kitchen();
				b.setVisible(true);
				MainApp.this.dispose();
				}
				});
				kitchenbtn.setBounds(962, 44, 98, 40);
				panel.add(kitchenbtn);


		try {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image cursorImage = toolkit.getImage("C:\\Users\\HUAWEI\\Desktop\\PET\\src\\Start\\Cursors.png");
			Cursor customCursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "CustomCursor");
			setCursor(customCursor);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error setting custom cursor: " + e.getMessage());
		}
	

		
		//Main character
		idlepos = new JLabel("");
		idlepos.setBounds(823, 598, 230, 230);
		panel.add(idlepos);
		idlepos.setIcon(new ImageIcon(MainApp.class.getResource("images/idle.gif")));
		
		//Main Background
		bg = new JLabel("");
		bg.setBounds(0, 0, 1600, 900);
		panel.add(bg);
		bg.setIcon(new ImageIcon(MainApp.class.getResource("images/home.png")));
		
		
		
		
		//new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/res/image.png")).getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH))
		//new ImageIcon(MainApp.class.getResource("Images/home.jpg"))
		
		
	}
}

