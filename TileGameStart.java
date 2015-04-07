import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TileGameStart extends JFrame implements ActionListener
{
  private JButton startGame;
  private boolean start;
  
  public TileGameStart() // adds text and start button to panel
  {
     JPanel panel = new JPanel();
      getContentPane().add(panel);    
      panel.setLayout(null);
     
      JLabel intro = new JLabel("Press Start Game to Play");
        intro.setBounds(60,80,200,30);
        panel.add(intro);
        
      JLabel gameName = new JLabel("Sliding Tiles Game");
        gameName.setBounds(60,20,200,20);
        panel.add(gameName);
        
        JLabel myName = new JLabel("By Tingxuan Huang");
        myName.setBounds(60,40,200,20);
        panel.add(myName);
        
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
        if (e.getSource() == startGame) // when start game is clicked, creates a new Board and closes the start screen
        {
          Board newGame = new Board();
          this.dispose();
        }
      }
}
          