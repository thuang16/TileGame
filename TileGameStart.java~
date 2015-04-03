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
     
      JLabel intro = new JLabel("Press Start Game to Play");
        intro.setBounds(60,80,200,30);
        panel.add(intro);
        
      startGame = new JButton("Start Game");
      startGame.setBounds(50,110,200,80);
      startGame.addActionListener(this);
      panel.add(startGame);
      
      setTitle("Tile Game");
      setSize(300, 300);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
  }
      
      public void actionPerformed(ActionEvent e)
      {
        if (e.getSource() == startGame)
        {
          Board newGame = new Board();
          this.dispose();
        }
      }
      public boolean getStart()
      {
        return start;
      }
}
          