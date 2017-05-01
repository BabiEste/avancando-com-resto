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

        //botao de rodar
        g.drawRect (20,50, 70, 50);
        g.setColor (Color.blue);
        g.fillRect (20, 50, 70, 50);
        g.setColor (Color.white);
        drawCenteredString (g, "Rodar", 50, 70, 20, 50, g.getFont());

    }

    public void draw(Graphics g) { //desenha um retangulo com um texto dentro
        g.drawRect(x, y, 50, 50);
        v[indice] = (int) (Math.random()*100);
        String a = Integer.toString (v[indice]);
        drawCenteredString (g, a, 50, 50, x, y, g.getFont());
    }

    public void drawCenteredString(Graphics g, String text, int altura, int comprimento, int xret, int yret, Font font) {
    // Get the FontMetrics
    FontMetrics metrics = g.getFontMetrics(font);
    // Determine the X coordinate for the text
    int xmeio = xret + (comprimento - metrics.stringWidth(text)) / 2;
    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
    int ymeio = yret + ((altura - metrics.getHeight()) / 2) + metrics.getAscent();
    // Set the font
    g.setFont(font);
    // Draw the String
    g.drawString(text, xmeio, ymeio);
}


}

class PP extends JFrame { //main

    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.add(new Pintor ());

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //faz a janela ser fechável

        window.setSize(800, 600);
        window.setVisible(true);
    }
}