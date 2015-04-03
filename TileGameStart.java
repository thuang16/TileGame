import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TileGameStart extends JFrame implements ActionListener
{
  private JButton startGame;
  private boolean start;
  
  public TileGameStart()
  {
     JPanel panel = new JPanel();
      getContentPane().add(panel);    
      panel.setLayout(null);
     
      JLabel intro = new JLabel("Sliding Tile Game by Tingxuan Huang. Press Start Game to Play");
        intro.setBounds(90,30,100,30);
        panel.add(intro);
        
      startGame = new JButton("Start Game");
      startGame.setBounds(120,80,200,80);
      startGame.addActionListener(this);
      panel.add(startGame);
      
      setTitle("Tile Game");
      setSize(400, 400);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
  }
      
      public void actionPerformed(ActionEvent e)
      {
        if (e.getSource() == startGame)
        {
          start = true;
        }
      }
      
      public boolean getStart()
      {
        return start;
      }
}
          