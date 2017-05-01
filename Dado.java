import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

class GerarDado extends JFrame {
  private JLabel imagem;

  public GerarDado() {
    Icon dadinho = new ImageIcon("dado1.png");
    imagem = new JLabel(dadinho);
    add(imagem);
  }
}

public class Dado extends JFrame {
  public static void main(String[] args) {
    GerarDado janela = new GerarDado();

    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setSize(800, 600);
    janela.setVisible(true);
  }
}
