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



public class kitchen extends JFrame {

    JLabel bg,Pusheen,Refrigerator;
	JLabel homebtn,bathroombtn,bedroombtn,playgroundbtn,kitchenbtn;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kitchen frame = new kitchen();
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
	public kitchen() {
		setUndecorated(true);
		setUndecorated(true);
		setBounds(10, 10, 1920, 900);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1920, 1200);
		contentPane.add(panel);
		panel.setLayout(null);
		
	
		 //Main character
          Pusheen= new JLabel("");
         Pusheen.setBounds(400, 580, 230, 230);
         panel.add(Pusheen);
         Pusheen.setIcon(new ImageIcon(MainApp.class.getResource("images\\idlebathroom.gif")));

		//Home
		homebtn = new JLabel("Home");
		homebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainApp a = new MainApp();
				a.setVisible(true);
				kitchen.this.dispose();
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
				kitchen.this.dispose();
			}
		});
		bathroombtn.setBounds(488, 44, 98, 40);
		panel.add(bathroombtn);
		
		//PlayGround
		playgroundbtn = new JLabel("Playground");
		playgroundbtn.setBounds(634, 44, 98, 40);
		panel.add(playgroundbtn);
		
		
		//Bedroom
		bedroombtn = new JLabel("Bedroom");
		bedroombtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bedroom a = new bedroom();
				a.setVisible(true);
				kitchen.this.dispose();
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
				kitchen.this.dispose();
				}
				});
				kitchenbtn.setBounds(962, 44, 98, 40);
				panel.add(kitchenbtn);

            
        //Main Background
        bg = new JLabel("");
        bg.setBounds(0, 0, 1600, 900);
        panel.add(bg);
        bg.setIcon(new ImageIcon(MainApp.class.getResource("images/Kitchens.gif")));
    
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


