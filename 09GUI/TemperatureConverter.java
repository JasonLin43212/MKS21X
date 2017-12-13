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
    if (s.equals("Convert to Fahrenheit")){
      double newTemp = CtoF(Double.parseDouble(text.getText()));
      text.setText(newTemp+"");
    }
    if (s.equals("Convert to Celsius")){
      double newTemp = FtoC(Double.parseDouble(text.getText()));
      text.setText(newTemp+"");
    }
  }

  public static void main(String[]args){
    TemperatureConverter g = new TemperatureConverter();
    g.setVisible(true);
  }

  public static double CtoF(double celsius){
    return (9.0/5)*celsius + 32;
  }

  public static double FtoC(double fahrenheit){
    return (5.0/9)*(fahrenheit -32);
  }
}
