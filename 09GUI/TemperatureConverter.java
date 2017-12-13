import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame implements ActionListener{
  private Container pane;

  private JTextField text;
  private JButton FtoCbutton;
  private JButton CtoFbutton;

  public TemperatureConverter(){
    this.setTitle("Temperature Converter");
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());

    text = new JTextField(20);
    FtoCbutton = new JButton("Convert to Fahrenheit");
    CtoFbutton = new JButton("Convert to Celsius");

    text.addActionListener(this);
    FtoCbutton.addActionListener(this);
    CtoFbutton.addActionListener(this);

    pane.add(text);
    pane.add(FtoCbutton);
    pane.add(CtoFbutton);
  }

  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    System.out.println(s);
  }

  public static void main(String[]args){
    TemperatureConverter g = new TemperatureConverter();
    g.setVisible(true);
  }
}
