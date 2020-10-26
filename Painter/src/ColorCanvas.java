import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.Color;

public class ColorCanvas {

    JFrame cnv_frame;
    JPanel cnv_panel;

    ColorCanvas() {
 
        cnv_frame = new JFrame();
        cnv_panel = new JPanel();

        // Setting up Frame
        cnv_frame.setSize(1500,900);
        cnv_frame.setLocationRelativeTo(null);
        cnv_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cnv_frame.add(cnv_panel);
        cnv_frame.setResizable(true);

        // Icon for top-left corener of Frame
        ImageIcon img = new ImageIcon("C:/Users/nfade/OneDrive/Desktop/Painter/assets/image_icon.png");
        cnv_frame.setIconImage(img.getImage());

        // Setting up Panel
        cnv_panel.setBackground(Color.white);
        cnv_panel.setLayout(null);

        // Adding Border Decoration
        Border cnv_border = new LineBorder(Color.BLACK, 12, false);
        cnv_panel.setBorder(cnv_border);

        // Uses ColorTool class to enable drawing.
        new OptionsTabs(cnv_panel);

        cnv_frame.setVisible(true);

    }

    class OptionsTabs {

        JButton option_draw;
        JButton option_erase;
        JButton option_colorRed;
        JButton option_colorPurple;
        JButton option_colorGreen;

        ImageIcon option_draw_image = new ImageIcon
                ("C:/Users/nfade/OneDrive/Desktop/Painter/assets/option_draw.png");

        ImageIcon option_erase_image = new ImageIcon
                ("C:/Users/nfade/OneDrive/Desktop/Painter/assets/option_erase.png");

        ImageIcon option_colorRed_image = new ImageIcon
                ("C:/Users/nfade/OneDrive/Desktop/Painter/assets/option_colorRed.png");

        ImageIcon option_colorPurple_image = new ImageIcon
                ("C:/Users/nfade/OneDrive/Desktop/Painter/assets/option_colorPurple.png");

        ImageIcon option_colorGreen_image = new ImageIcon
                ("C:/Users/nfade/OneDrive/Desktop/Painter/assets/option_colorGreen.png");

        void optionDraw() {

            option_draw = new JButton();
            option_draw.setIcon(option_draw_image);
            option_draw.setBounds(20,20,20,53);
            option_draw.setFocusPainted(false);
            option_draw.setBorderPainted(false);
            option_draw.setBackground(Color.white);
            cnv_panel.add(option_draw);

        }

        void optionErase() {

            option_erase = new JButton();
            option_erase.setIcon(option_erase_image);
            option_erase.setBounds(65,27,26,43);
            option_erase.setFocusPainted(false);
            option_erase.setBorderPainted(false);
            option_erase.setBackground(Color.white);
            cnv_panel.add(option_erase);

        }

        void colorRed() {

            option_colorRed = new JButton();
            option_colorRed.setIcon(option_colorRed_image);
            option_colorRed.setBounds(20, 90, 20, 53);
            option_colorRed.setFocusPainted(false);
            option_colorRed.setBorderPainted(false);
            option_colorRed.setBackground(Color.white);
            cnv_panel.add(option_colorRed);

        }

        void colorPurple() {

            option_colorPurple = new JButton();
            option_colorPurple.setIcon(option_colorPurple_image);
            option_colorPurple.setBounds(20, 160, 20, 53);
            option_colorPurple.setFocusPainted(false);
            option_colorPurple.setBorderPainted(false);
            option_colorPurple.setBackground(Color.white);
            cnv_panel.add(option_colorPurple);

        }

        void colorGreen() {

            option_colorGreen = new JButton();
            option_colorGreen.setIcon(option_colorGreen_image);
            option_colorGreen.setBounds(20, 230, 20, 53);
            option_colorGreen.setFocusPainted(false);
            option_colorGreen.setBorderPainted(false);
            option_colorGreen.setBackground(Color.white);
            cnv_panel.add(option_colorGreen);

        }

        OptionsTabs(JPanel cnv_panel) {

            optionDraw();
            optionErase();
            colorRed();
            colorPurple();
            colorGreen();

            ColorTool coloring = new ColorTool(cnv_panel);

            option_draw.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == option_draw) {
                        coloring.setImageIcon(0);
                        cnv_panel.repaint();
                    }}});

            option_erase.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == option_erase) {
                        coloring.setImageIcon(1);
                        cnv_panel.repaint();
                    }}});

            option_colorRed.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == option_colorRed) {
                        coloring.setImageIcon(2);
                        cnv_panel.repaint();
                    }}});

            option_colorPurple.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == option_colorPurple) {
                        coloring.setImageIcon(3);
                        cnv_panel.repaint();
                    }}});       
            
            option_colorGreen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == option_colorGreen) {
                        coloring.setImageIcon(4);
                        cnv_panel.repaint();
                    }}});  

        }

    }

    class ColorTool {

        ImageIcon drawed_image = new ImageIcon
                ("C:/Users/nfade/OneDrive/Desktop/Painter/assets/drawed_image_black.png");

        ImageIcon drawed_image_red = new ImageIcon
                ("C:/Users/nfade/OneDrive/Desktop/Painter/assets/drawed_image_red.png");

        ImageIcon drawed_image_purple = new ImageIcon
                ("C:/Users/nfade/OneDrive/Desktop/Painter/assets/drawed_image_purple.png");

        ImageIcon drawed_image_green = new ImageIcon
                ("C:/Users/nfade/OneDrive/Desktop/Painter/assets/drawed_image_green.png");

        ImageIcon erased_image = new ImageIcon
                ("C:/Users/nfade/OneDrive/Desktop/Painter/assets/erased_image.png");

        ImageIcon baseIcon = new ImageIcon();

        void setImageIcon(int x) {
            if (x==0) {
                baseIcon = drawed_image;
            }
            else if (x==1) {
                baseIcon = erased_image;
            }
            else if (x==2) {
                baseIcon = drawed_image_red;
            }
            else if (x==3) {
                baseIcon = drawed_image_purple;
            }
            else if (x==4) {
                baseIcon = drawed_image_green;
            }
        }

        ColorTool(JPanel cnv_panel) {

            int index = 0;

            // Draws 20x20 pixel when clicked
            cnv_panel.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    JLabel x = new JLabel();  x.setIcon(baseIcon);
                    if (baseIcon == erased_image) {x.setBounds(e.getX()-15,e.getY()-15,30,30);
                    cnv_panel.add(x,index);  cnv_panel.repaint();}
                    else {x.setBounds(e.getX()-5,e.getY()-5,10,10);
                    cnv_panel.add(x,index);  cnv_panel.repaint();}
                    }});

            // Draws 20x20 pixels when dragged
            cnv_panel.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    JLabel x = new JLabel();  x.setIcon(baseIcon);
                    if (baseIcon == erased_image) {x.setBounds(e.getX()-15,e.getY()-15,30,30);
                        cnv_panel.add(x,index);  cnv_panel.repaint();}
                    else {x.setBounds(e.getX()-5,e.getY()-5,10,10);
                        cnv_panel.add(x,index);  cnv_panel.repaint();}
                }});

        }

    }

    public static void main(String[] args) {
        new ColorCanvas();
    }

}