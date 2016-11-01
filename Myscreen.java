package videoGame;

//import graphics library
import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import sun.audio.*;

//class declaration, +JFrame functionality (extends = inheritance)
public class Myscreen extends JFrame{

//constructor method - runs first when class template is instantiated
public Myscreen() {

  this.setTitle("Graphics");
  this.setSize(600,400);
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  this.setVisible(true);
}

//makes class runable
public static void main(String[] args) {

  //instance being created
  Myscreen screen = new Myscreen();
  Mycanvas canvas = new Mycanvas();
  screen.getContentPane().add(canvas);
}

/*public static void playIt() {
  try {
    InputStream in = new FileInputStream("audio.mp3");
    AudioStream as = new AudioStream(in);
    AudioPlayer.player.start(as);
  } catch (IOException e) {
    System.out.println("can not find file");
  }
}*/
}
