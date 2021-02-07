package hangman;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Game implements ActionListener{
static int k;
static{ k = 0;}
JFrame frame;
JLabel S, M, I, L, E;
JTextField guess;
WrongAnswer wrongcount;

class WrongAnswer extends JPanel{
int a;

WrongAnswer(){
a = 0;
}

void setA(int k){
a = k;
}

protected void paintComponent(Graphics g){
super.paintComponent(g);
switch(a){
case 7: g.drawLine(100, 100, 100, 130);//hanged :(
case 6: g.drawLine(100, 170, 85, 220);// left hand
case 5: g.drawLine(100, 170, 115, 220);//right hand
case 4: g.drawLine(100, 250, 85, 300);//left leg
case 3: g.drawLine(100, 250, 115, 300);//right leg
case 2: g.drawLine(100, 160, 100, 250);//body
case 1: g.fillOval(85, 130, 30, 30);//head
case 0: g.drawLine(10, 320, 90, 320);
g.drawLine(50, 320, 50, 100);
g.drawLine(50, 100, 100, 100);
}
}

}

public Game(){
frame = new JFrame("HANGMAN!");
frame.setLayout(new FlowLayout(FlowLayout.CENTER, 70, 50));
frame.setSize(800,600);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
S = new JLabel("-");
M = new JLabel("-");
I = new JLabel("-");
L = new JLabel("-");
E = new JLabel("-");
guess = new JTextField("type a letter!");
guess.addActionListener(this);
wrongcount = new WrongAnswer();
wrongcount.setPreferredSize(new Dimension(300, 600));
frame.add(wrongcount);
frame.add(S);
frame.add(M);
frame.add(I);
frame.add(L);
frame.add(E);
frame.add(guess);
frame.add(wrongcount);
frame.setVisible(true);
}

public void actionPerformed(ActionEvent ae){
String letter = guess.getText();
switch(letter){
case"s" : S.setText("S");break;
case"m" : M.setText("M");break;
case"i" : I.setText("I");break;
case"l" : L.setText("L");break;
case"e" : E.setText("E");break;
case"S" : S.setText("S");break;
case"M" : M.setText("M");break;
case"I" : I.setText("I");break;
case"L" : L.setText("L");break;
case"E" : E.setText("E");break;
default: wrongcount.setA(++k);wrongcount.repaint();
}
if(k == 7){
frame.getContentPane().removeAll();
ImageIcon gameover = new ImageIcon("C:\\Users\\user\\Pictures\\game over.jpg");
JLabel no = new JLabel("GAME OVER :(", gameover, JLabel.CENTER);
frame.getContentPane().add(no);
frame.getContentPane().add(wrongcount);
frame.pack();
frame.repaint();
}
if(S.getText() == "S" && M.getText() == "M" && I.getText() == "I" && L.getText() == "L" && E.getText() == "E"){
frame.getContentPane().removeAll();
ImageIcon smilee = new ImageIcon("C:\\Users\\user\\Pictures\\smile.jpg");
JLabel yes = new JLabel("yes! it is smile!", smilee, JLabel.CENTER);
frame.getContentPane().add(yes);
frame.pack();
frame.repaint();
}
}

public static void main(String args[]){
new Game();
}
}