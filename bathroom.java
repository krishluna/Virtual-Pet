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
import javax.swing.border.EmptyBorder;

public class bathroom extends JFrame {
	
	private JPanel contentPane;
	JLabel bg;
	JLabel idlepos,dance,books,laptop,sofa,HomeBtn;
	JLabel homebtn,bathroombtn,bedroombtn,playgroundbtn,kitchenbtn;
	private JLabel brush;
	private JLabel bathtub,backToidle ;
	private JLabel litter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					bathroom frame = new bathroom();
	}

	/**
	 * Create the frame.
	 */
	public bathroom() {
		setUndecorated(true);
		setBounds(10, 10, 1920, 900);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1600, 900);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		//Main character
		idlepos = new JLabel("");
		idlepos.setBounds(823, 598, 230, 230);
		panel.add(idlepos);
		idlepos.setIcon(new ImageIcon(MainApp.class.getResource("images/idlebathroom.gif")));
		
		
		backToidle = new JLabel("");
		backToidle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idlepos.setVisible(true);
				idlepos.setBounds(823, 598, 230, 230);
				idlepos.setIcon(new ImageIcon(MainApp.class.getResource("images/idlebathroom.gif")));
				brush.setVisible(true);
				bathtub.setIcon(new ImageIcon(MainApp.class.getResource("images/bathtub.png")));
			}
		});
		backToidle.setBounds(54, 686, 1153, 203);
		panel.add(backToidle);
		
		
		//Home
		homebtn = new JLabel("Home");
		homebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainApp a = new MainApp();
				a.setVisible(true);
				bathroom.this.dispose();
			}
		});
		homebtn.setBounds(318, 44, 98, 40);
		panel.add(homebtn);
		
		//Bathroom
		bathroombtn = new JLabel("Bathroom");
		bathroombtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
				bathroom.this.dispose();
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
				bathroom.this.dispose();
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
				bathroom.this.dispose();
				}
				});
				kitchenbtn.setBounds(962, 44, 98, 40);
				panel.add(kitchenbtn);


		
		//Brush Button
		brush = new JLabel("");
		brush.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idlepos.setBounds(256, 325, 230, 230);
				idlepos.setIcon(new ImageIcon(MainApp.class.getResource("images/catbrush.gif")));
				brush.setVisible(false);
				idlepos.setVisible(true);
				bathtub.setIcon(new ImageIcon(MainApp.class.getResource("images/bathtub.png")));
				
			}
		});
		brush.setBounds(256, 390, 251, 163);
		brush.setIcon(new ImageIcon(MainApp.class.getResource("images/brush.png")));
		panel.add(brush);
		
		//Bathtub Button
		bathtub = new JLabel("");
		bathtub.setIcon(new ImageIcon(MainApp.class.getResource("images/bathtub.png")));
		bathtub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idlepos.setVisible(false);
				brush.setVisible(true);
				bathtub.setIcon(new ImageIcon(MainApp.class.getResource("images/naliligo.gif")));
				
			}
		});
		bathtub.setBounds(592, 430, 470, 298);
		
		panel.add(bathtub);
		
		//Litter Button
		litter = new JLabel("");
		litter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idlepos.setVisible(true);
				bathtub.setIcon(new ImageIcon(MainApp.class.getResource("images/bathtub.png")));
				idlepos.setIcon(new ImageIcon(MainApp.class.getResource("images/onLitter.gif")));
				idlepos.setBounds(1280, 600, 230, 158);
			}
		});
		litter.setBounds(1280, 635, 230, 158);
		panel.add(litter);
		
		
		
		//Main Background
		bg = new JLabel("");
		bg.setBounds(0, 0, 1600, 900);
		panel.add(bg);
		bg.setIcon(new ImageIcon(MainApp.class.getResource("images/bathroom.png")));
		

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

