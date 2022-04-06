import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

public class Main {
  static JFrame frame;
  static JFrame frame1;
  public static void main(String[] args) {
    JFrame frame = new JFrame("form1");
    frame.setSize(900,400);
    //frame.add(new MainForm().getMainPanel());
    //frame.add(new Main1().getMainPanel());
    frame.setContentPane(new Main1().getMainPanel());

    /*JFrame frame1 = new JFrame();
    frame1.setSize(900,400);
    //frame.add(new MainForm().getMainPanel());
    frame1.add(new MainForm().getMainPanel());
    frame1.setVisible(true);*/

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    System.out.println(frame.getContentPane().getName());
  }
  public static JFrame getMa(){
    //frame1.setVisible(false);
    return frame;
  }
  public void setv(){
    frame.setVisible(false);
  }
}
