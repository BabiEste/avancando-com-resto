import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

class GerarDado extends JFrame {
  private JLabel imagem;
  private int index;
  String[] imagens = new String[]{"dado1.png", "dado2.png", "dado3.png", "dado4.png", "dado5.png", "dado6.png"};


  public GerarDado() {
    while (true) {
      index = (int) (Math.random()*6);
      if (index == 0) index = 5;
      Icon dadinho = new ImageIcon(imagens[index]);
      imagem = new JLabel(dadinho);
      add(imagem);
      }
    }
  }

public class Dado extends JFrame {
  public static void main(String[] args) {
    GerarDado janela = new GerarDado();

    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setSize(300, 300);
    janela.setVisible(true);
  }
}
