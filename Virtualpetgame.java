import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Virtualpetgame extends JFrame { 
    private JPanel startPanel;
    private JPanel loadingPanel;
    private JPanel nameEntryPanel;
    private Clip backgroundMusic;
    private Clip clickSound;


    private JPanel[] storylinePanels;
    private String UserName;
    private String Password;

    public Virtualpetgame() {
        setTitle("Virtual Pet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1920, 1200);
        setLayout(new CardLayout());

        preloadClickSound("src\\Sound\\SE.wav");
        
        startPanel = createImagePanel("C:\\Users\\HUAWEI\\Desktop\\PET\\src\\Start\\GoodQualBg.gif");
        loadingPanel = createImagePanel("C:\\Users\\HUAWEI\\Desktop\\PET\\src\\Start\\Loadingss.gif");
        nameEntryPanel = createImagePanel("C:\\Users\\HUAWEI\\Downloads\\PET\\src\\Start\\BGLoading.png");

        // Setup storyline panels
        storylinePanels = new JPanel[9];
        for (int i = 0; i < 9; i++) {
            storylinePanels[i] = new JPanel(new BorderLayout());
            storylinePanels[i].setOpaque(false);
        }

        // Add panels to content pane
        getContentPane().add(startPanel, "Start");
        getContentPane().add(loadingPanel, "Loading");
        getContentPane().add(nameEntryPanel, "NameEntry");
        getContentPane().add(storylinePanels[0], "Storyline1");
        getContentPane().add(storylinePanels[1], "Storyline2");
        getContentPane().add(storylinePanels[2], "Storyline3");
        getContentPane().add(storylinePanels[3], "Storyline4");
        getContentPane().add(storylinePanels[4], "Storyline5");
        getContentPane().add(storylinePanels[5], "Storyline6");
        getContentPane().add(storylinePanels[6], "Storyline7");
        getContentPane().add(storylinePanels[7], "Storyline8");
        getContentPane().add(storylinePanels[8], "Storyline9");

        CardLayout cll = (CardLayout) (getContentPane().getLayout());
        cll.show(getContentPane(), "Start");

        setupStartPanel();
        setupLoadingPanel();
        setupNameEntryPanel();
        setupStorylinePanels();

        // Simulate loading and switch to name entry panel
        simulateLoading();

        playBackgroundMusic("C:\\Users\\HUAWEI\\Downloads\\PET\\src\\Sound\\BGMusic.wav");
    
    }
 private void playBackgroundMusic(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioStream);

            // Loop the background music indefinitely
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
            System.err.println("Error loading background music: " + e.getMessage());
        }
    }

    private void setupStartPanel() {
        JButton startButton = createImageButton("C:\\Users\\HUAWEI\\Downloads\\PET\\src\\Start\\START.png");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), "Loading");
                playButtonClickSound();
            }
        });
        startPanel.add(startButton);
    }
    private void simulateLoading() {
        getContentPane().add(loadingPanel, "Loading");
        revalidate();

        Timer timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), "NameEntry");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    private void setupLoadingPanel() {
        // No additional setup needed
    }

    private void setupNameEntryPanel() {
        JPanel panel = createImagePanel("C:\\Users\\HUAWEI\\Downloads\\PET\\src\\Start\\BGLoading.png");
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
    
        ImageIcon enteraname = new ImageIcon("C:\\Users\\HUAWEI\\Desktop\\PET\\src\\Start\\Enteraname.png\\");
        JLabel enterLabel = new JLabel(enteraname);
        enterLabel.setFont(new Font("Arial", Font.ITALIC, 24));
        enterLabel.setForeground(Color.WHITE);
        panel.add(enterLabel, gbc);
    
        gbc.gridy++;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some vertical spacing
    
        // Create a separate panel for text field and button to manage their layout
         // Adjust width as needed
        
        JTextField nameTextField = new JTextField(1); // Reduce the width to fit better
        nameTextField.setFont(new Font("Arial", Font.ITALIC, 24));
        nameTextField.setHorizontalAlignment(JTextField.CENTER); // Center align text inside the text field
        nameTextField.setPreferredSize(new Dimension(400, 400));
       // Add the text field to the panel
        gbc.fill = GridBagConstraints.BOTH;

        panel.add(nameTextField, gbc);
    
        gbc.gridy++;
        JButton enterButton = createImageButton("C:\\Users\\HUAWEI\\Downloads\\PET\\src\\Start\\Enter.png");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserName = nameTextField.getText();

                playButtonClickSound();
                playSound("src\\Sound\\SE.wav");
                if (!UserName.isEmpty()) {
                    try {
                        FileWriter writer = new FileWriter("Playersname.txt");
                        writer.write(UserName);
                        writer.close();
                        System.out.println("Player name saved: " + UserName);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        System.err.println("Error writing player name to file: " + ex.getMessage());
                    }
                    CardLayout cl = (CardLayout) getContentPane().getLayout();
                    cl.show(getContentPane(), "Storyline1");
                } else {
                    JOptionPane.showMessageDialog(Virtualpetgame.this, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(enterButton, gbc);
    
        gbc.gridy++;
        JCheckBox useExistingNameCheckBox = new JCheckBox("Use Existing Name");
        useExistingNameCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (useExistingNameCheckBox.isSelected()) {
                    // Read the saved name from the file if it exists and set it in the text field
                    try {
                        File file = new File("Playersname.txt");
                        if (file.exists()) {
                            BufferedReader reader = new BufferedReader(new FileReader(file));
                            UserName = reader.readLine();
                            reader.close();
                            if (UserName != null && !UserName.isEmpty()) {
                                nameTextField.setText(UserName);
                            }
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        System.err.println("Error reading player name from file: " + ex.getMessage());
                    }
                } else {
                    // Clear the text field
                    nameTextField.setText("");
                }
            }
        });
        panel.add(useExistingNameCheckBox, gbc);

        getContentPane().add(panel, "NameEntry");
    }

    
        private void setupStorylinePanels() {
            for (int i = 0; i < 9; i++) {
                JPanel panel = storylinePanels[i];
      
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\HUAWEI\\Desktop\\PET\\src\\Storyline\\storyline"  + i + ".gif");
        
                JLabel imageLabel = new JLabel(imageIcon);
                imageLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        
                // Create a layered pane to hold the image and buttons
                JLayeredPane layeredPane = new JLayeredPane();
                layeredPane.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
        
                // Add the image to the layered pane
                layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
        
                // Create and position the buttons
                ImageIcon next = new ImageIcon("C:\\Users\\HUAWEI\\Desktop\\PET\\src\\Start\\NextButtons.png");
                JButton nextButton = new JButton(next);
                nextButton.setBounds(1350, 850, 115, 45); // Adjust the position and size as needed
                nextButton.setBorderPainted(false);
                nextButton.setContentAreaFilled(false);
                ImageIcon skip = new ImageIcon("C:\\Users\\HUAWEI\\Desktop\\PET\\src\\Start\\SkipButtons.png");
                JButton skipButton = new JButton(skip);
                skipButton.setBounds(100, 850, 115, 45); // Adjust the position and size as needed
                skipButton.setBorderPainted(false);
                skipButton.setContentAreaFilled(false);
        
                // Add ActionListener to next button
                final int nextStoryline = i + 2;
                nextButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cl = (CardLayout) getContentPane().getLayout();
                        playButtonClickSound();
                        if (nextStoryline <= 9) {
                            cl.show(getContentPane(), "Storyline" + nextStoryline);
                            System.out.println("next");
                        }
        
                        if (nextStoryline >= 9) {
                            new MainApp();
                            exitFrame();
                        }
                    }
                });
        
                // Add ActionListener to skip button
                skipButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cl = (CardLayout) getContentPane().getLayout();
                        playButtonClickSound();
                        // Show the last storyline panel
                        cl.show(getContentPane(), "Storyline9");
                    }
                });
        
                // Add the buttons to the layered pane
                layeredPane.add(nextButton, JLayeredPane.PALETTE_LAYER);
                layeredPane.add(skipButton, JLayeredPane.PALETTE_LAYER);
        
                // Add the layered pane to the panel
                panel.add(layeredPane); // Added this line
        
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

private void playVoiceNarration(String filePath) {
    try {
        File audioFile = new File(filePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        // Start playing the narration asynchronously
        clip.start();

        // Add a listener to close the clip when playback is complete
        clip.addLineListener(new LineListener() {
            @Override
            public void update(LineEvent event) {
                if (event.getType() == LineEvent.Type.STOP) {
                    event.getLine().close();
                }
            }
        });
    } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
        e.printStackTrace();
        System.err.println("Error playing voice narration: " + e.getMessage());
    }
}


    private JPanel createImagePanel(String imagePath) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon(imagePath).getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
    }

    private JButton createImageButton(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JButton button = new JButton(imageIcon);
        button.setBorder(null);
        button.setContentAreaFilled(false);
        button.setPreferredSize(new Dimension(500, 1500));
        playButtonClickSound();
        return button;
    }
    private void preloadClickSound(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            clickSound = AudioSystem.getClip();
            clickSound.open(audioInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error preloading sound: " + ex.getMessage());
        }
    }
    private void playButtonClickSound() {
        try {
            // Load the sound file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\Sound\\SE.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            // Play the sound
            clip.start();
            // Close the clip after the sound has finished playing
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error playing sound: " + ex.getMessage());
        }
    }
    
    private void playSound(String filePath) {
        try {
            // Load the sound file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            // Play the sound
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error playing sound: " + ex.getMessage());
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Virtualpetgame().setVisible(true);
            }
        });
    }

    void exitFrame(){
       
        this.dispose();
    }
  
    }



