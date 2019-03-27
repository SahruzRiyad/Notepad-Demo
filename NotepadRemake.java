import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotepadRemake extends JFrame{
    Container cnt = new Container();
    JLabel lbl1 = new JLabel();
    ImageIcon img;
    JButton read = new JButton("Read");
    JButton exit = new JButton("Exit");
    JButton save = new JButton("Save");
    Cursor crs = new Cursor(Cursor.HAND_CURSOR);
    Font fnt = new Font("Arial",Font.BOLD,14);
    JTextArea Jtx = new JTextArea(15,30);
    JFileChooser fc = new JFileChooser(); 


    NotepadRemake(){
        set_label();
        set_component();
        set_action();
    }
    NotepadRemake(String a){
    	this.setVisible(true);
        this.setBounds(600,200,600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        img = new ImageIcon(getClass().getResource("Reading.jpg"));
        this.setIconImage(img.getImage());
        this.setTitle("READ");
        this.getContentPane().add(Jtx,BorderLayout.CENTER);
        int val = fc.showOpenDialog(this);
        if (val == JFileChooser.APPROVE_OPTION)
        {
            File file = fc.getSelectedFile();
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                Jtx.read(input, "READING FILE ");
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(null,"Eror 404");
            }
        }
        else
        {
            System.out.println("Operation is CANCELLED ");
            dispose();
        }

    }

    void set_component(){
    	cnt = this.getContentPane();
    	img = new ImageIcon(getClass().getResource("download.png"));
    	this.setIconImage(img.getImage());
    	cnt.setBackground(Color.LIGHT_GRAY);
    	cnt.setLayout(null);
        read.setBounds(190,250,100,40);
        exit.setBounds(320,250,100,40);
    	cnt.add(read);
    	cnt.add(exit);
    	exit.setCursor(crs);
    	read.setCursor(crs);
    	read.setFont(fnt);
    	exit.setFont(fnt);

    }
    void set_label(){
        lbl1.setBounds(200,12,300,100);

    }
    void set_action(){
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                NotepadRemake rf = new NotepadRemake("READ");
            }


        });

    }

    public static void main(String[] args) {
        NotepadRemake fr = new NotepadRemake();
        fr.setVisible(true);
        fr.setBounds(600,200,600,600);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(true);
        fr.setTitle("Notepad");
    }
}
