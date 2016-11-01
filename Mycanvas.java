package videoGame;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import sun.audio.*;
import java.awt.*;

public class Mycanvas extends Canvas implements KeyListener {
  String[] playlist = new String[]{"fastinvader1.wav","fastinvader2.wav","fastinvader3.wav","fastinvade4.wav"};
  Image img = Toolkit.getDefaultToolkit().getImage("invader.png");
  int xpos = 0;
  int ypos = 0;
  Rectangle screenrect = new Rectangle(600,400,600,400);
  Rectangle playerrect = new Rectangle(xpos,ypos,100,100);

  public Mycanvas() {
    this.setSize(600,400);
    this.setFocusable(true);
    this.addKeyListener(this);
    //playIt("spaceinvaders2.wav");
  }
  public void paint(Graphics g) {
    g.drawImage(img,xpos,ypos,100,100,this);
    g.fillRect((int)screenrect.getX(),(int)screenrect.getY(),(int)screenrect.getWidth(),(int)screenrect.getHeight());
    g.fillRect(xpos,ypos,100,100);
  }
  public static void playIt(String filename) {
    try {
      InputStream in = new FileInputStream(filename);
      AudioStream move = new AudioStream(in);
      AudioPlayer.player.start(move);
    } catch (IOException e) {
      System.out.println("can not find file");
    }
  }

  public static void playMove(String[] playlist){
    int random = (int) (Math.random() * 3);
    try {
      InputStream in = new FileInputStream(playlist[random]);
      AudioStream move = new AudioStream(in);
      AudioPlayer.player.start(move);
      System.out.println(random);
    } catch (IOException e) {
      System.out.println("can not find file");
    }
  }

  public void moveIt(int direction) {
    int speed = 10;
    if (!screenrect.contains(playerrect)){
    	xpos =10;
        ypos =10;
        repaint();
        return;
    }
    if (screenrect.contains(xpos,ypos)){
      xpos =10;
      ypos =10;
      repaint();
      return;
    }
    if (xpos > this.getWidth() - speed * 2){
      xpos = xpos - speed;
      return;
    } else if (xpos < 0 - speed * 2){
      xpos = xpos + speed;
      return;
    }
    if (ypos > this.getHeight() - speed * 2){
      ypos = ypos - speed;
      return;
    } else if (ypos < 0 - speed * 2){
      ypos = ypos + speed;
      return;
    }
    if (direction == 38) {
      ypos = ypos - speed;
      playMove(playlist);
    } else if (direction == 39) {
      xpos = xpos + speed;
      playMove(playlist);
    } else if (direction == 37) {
      xpos = xpos - speed;
      playMove(playlist);
    } else if (direction == 40) {
      ypos = ypos + speed;
      playMove(playlist);
    }
  }
  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println(e.getKeyChar());
    System.out.println(e.getKeyCode());
    moveIt(e.getKeyCode());
    repaint();
  }
  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println("released");
  }
  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println("typed");
  }
}
