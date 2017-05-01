import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.event.MouseInputListener;
import java.awt.geom.Rectangle2D;

class Pintor extends JPanel {
    public int x = 680, y = 500, i = 0, indice = 0; //indice é indice dos numeros e retangulos

    public static int v[] = new int[44];
    public static Rectangle ret[] = new Rectangle[44];
    String a;

    public void paintComponent(Graphics g) { //cria o mapa
        super.paintComponent(g);
        g.drawString ("INICIO", x, y);

        for (i = 0; i < 11; i++) {
            ret[indice] = new Rectangle (x, y, 50, 50);
            draw(g, ret[indice]);
            x = x - 50;
        }

        for (i=0;i<9;i++) {
           ret[indice] = new Rectangle (x, y, 50, 50);
            draw (g, ret[indice]);
            y = y - 50;
        }

        for (i=0;i<11;i++) {
            ret[indice] = new Rectangle (x, y, 50, 50);
            draw (g, ret[indice]);
            x = x + 50;
        }

        for (i=0;i<6;i++) {
            ret[indice] = new Rectangle (x, y, 50, 50);
            draw (g, ret[indice]);
            y = y + 50;
        }

        for (i = 0; i < 6; i++) {
            ret[indice] = new Rectangle (x, y, 50, 50);
            draw(g, ret[indice]);
            x = x - 50;
        }

        g.drawString ("FIM", x, y);

        //botao de rodar
        Rectangle rodo = new Rectangle (20, 50, 70, 50);
        g.drawRect (rodo.x, rodo.y, rodo.width, rodo.height);
        g.setColor (Color.blue);
        g.fillRect (rodo.x, rodo.y, rodo.width, rodo.height);
        g.setColor (Color.white);
        drawCenteredString (g, "Rodar", rodo, g.getFont());

    }

    public void draw(Graphics g, Rectangle r) { //desenha um retangulo com um texto dentro
        g.drawRect(r.x, r.y, r.width, r.height);
        v[indice] = (int) (Math.random()*100);
        String a = Integer.toString (v[indice++]);
        drawCenteredString (g, a, r, g.getFont());
    }

    public void drawCenteredString(Graphics g, String text, Rectangle r, Font font) {
    // Get the FontMetrics
    FontMetrics metrics = g.getFontMetrics(font);
    // Determine the X coordinate for the text
    int x = r.x + (r.width - metrics.stringWidth(text)) / 2;
    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
    int y = r.y + ((r.height - metrics.getHeight()) / 2) + metrics.getAscent();
    // Set the font
    g.setFont(font);
    // Draw the String
    g.drawString(text, x, y);
}


}

class mouse implements MouseInputListener {

    int pmouseX, pmouseY, mouseX, mouseY, numerodado;
    boolean mousePressed;

    void mouse(MouseEvent e) {
                pmouseX = mouseX;
                pmouseY = mouseY;
                mouseX = e.getX();
                mouseY = e.getY();
            }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouse(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouse(e);
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouse(e);
        mousePressed = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) { 
        if (e.getX() >=20 && e.getX() <=90 && e.getY() >=75 && e.getY()<=125 ) {
        numerodado = (int) (Math.random()*6); //TENTA ENFIAR AQUI AS IMAGENS 
        if (numerodado == 0) numerodado = 6;
        System.out.println ("Qual é o resto de " + Pintor.v[PP.posicao] + " dividido por " + numerodado + "? ");  
    } 
}

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }   
}

public class PP extends JFrame { 
    public static int posicao = 0;

    public static void main(String[] args) { //main
        JFrame window = new JFrame();

        mouse mouse = new mouse();
     
        window.addMouseListener(mouse);
        window.addMouseMotionListener(mouse);

        window.add(new Pintor ());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //faz a janela ser fechável
        window.setSize(800, 600);
        window.setVisible(true);
    }

}
