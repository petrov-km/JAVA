import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main1 {

  private JPanel pan1;
  private JTextField textField1;
  private JTextField textField2;
  private JButton button1;

  public JPanel getMainPanel(){
    return pan1;
  }

  public Main1(){
    button1.addActionListener(new Action() {
      @Override
      public Object getValue(String key) {
        return null;
      }

      @Override
      public void putValue(String key, Object value) {

      }

      @Override
      public void setEnabled(boolean b) {

      }

      @Override
      public boolean isEnabled() {
        return false;
      }

      @Override
      public void addPropertyChangeListener(PropertyChangeListener listener) {

      }

      @Override
      public void removePropertyChangeListener(PropertyChangeListener listener) {

      }

      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame frame1 = new JFrame();
        frame1.setSize(900, 400);
        //frame.add(new MainForm().getMainPanel());
        frame1.add(new MainForm().getMainPanel());
        frame1.setVisible(true);

        new Main().setv();
      //  JFrame frame3 = Main.getMa();
        //frame3.setVisible(false);
      }
    });
  }


}
