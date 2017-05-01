import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class Pintor extends JPanel {
	public int x = 680, y = 500, i = 0, indice = 0; //indice é indice dos strings

    int v[] = new int[40];
    String a;

    public void paintComponent(Graphics g) { //cria o mapa // e se usasse só paint?
        super.paintComponent(g);
        g.drawString ("INICIO", x, y);

        for (i = 0; i < 11; i++) {
            draw(g);
            x = x - 50;
        }
        for (i=0;i<9;i++) {
            draw (g);
            y = y - 50;
        }
        for (i=0;i<11;i++) {
            draw (g);
            x = x + 50;
        }
        for (i=0;i<6;i++) {
            draw (g);
            y = y + 50;
        }
        for (i = 0; i < 6; i++) {
            draw(g);
            x = x - 50;
        }

        g.drawString ("FIM", x, y);
        g.drawRect (50,50, 50, 50);

    }

    public void draw(Graphics g) { //desenha um retangulo com um texto dentro
        g.drawRect(x, y, 50, 50);
        v[indice] = (int) (Math.random()*100);
        String a = Integer.toString (v[indice]);
        g.drawString (a, x+25, y+25);
    }




}

class Dado extends JFrame { //Imagem aleatória gerada para o dado
	String[] imagens = new String[]{"/img/dado1.png", "/img/dado2.png", "/img/dado3.png", "/img/dado4.png", "/img/dado5.png", "/img/dado6.png"}; //Vetor de imagens

	public iniciar(){
		
	}
	ImageIcon icone = createImageIcon();

}

class PP extends JFrame { //main

    public static void main(String[] args) {
        JPanel f = new JPanel();
        JFrame window = new JFrame();
        f.setLayout (new FlowLayout());
        JPanel esquerda = new JPanel (new FlowLayout());
        f.add(new Pintor ());
        JButton botao = new JButton("Rodar");

        esquerda.add(botao);

        window.setLayout(new BorderLayout());

        window.add(f, BorderLayout.WEST);
        window.add(esquerda, BorderLayout.EAST);
        window.pack();



        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setSize(800, 600);
        window.setVisible(true);
    }
}
