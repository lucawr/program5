package csc220.program5.lucawr;

import csc220.list.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/*
 * CSC 220 5/3/17
    Wil Luca
    Decription: This class draws a bird that is red and has a yellow tail feather.
    It is contructed using parameters of over, down, width and height andalso extedns 
    to the abstract class GameCharacer. In the uper constructor a interval speed of 
    1000 is used, but this is arbitrary and the list that is used is the List class also
    contained in this package. It is initialized with 4 points already with more
    being added later through the List class.
 */

/**
 *
 * @author Wil
 */
//Begin Contructor 
public class Bird extends csc220.program5.GameCharacter {
    
    
public Bird(int over, int down, int width, int height) {   
 super(over, down, width, height, 1000, new csc220.program5.lucawr.List<>());
        this.animationPath.add(new Point(over, down));
        this.animationPath.add(new Point(over + 100, down));
        this.animationPath.add(new Point(over, down + 100));
        this.animationPath.add(new Point(over + 100, down + 100));

 
}
//end constructor

public void draw(Graphics g){



//beak
g.setColor(Color.ORANGE);
g.fillArc(getOver() - getWidth() +5, getDown() + (getHeight()/4), getWidth(),getHeight()/2 ,15, -30);

//tail
g.setColor(Color.RED);
g.fillArc(getOver() + 7*getWidth()/3, getDown() + getHeight()/50, getWidth(), getHeight(), 30, -60);
g.setColor(Color.YELLOW);
g.fillArc(getOver() + 7*getWidth()/3, getDown() + getHeight()/50, getWidth(), getHeight(), 10, -20);

//body
g.setColor(Color.RED);
g.fillOval(getOver() + getWidth()-5 , getDown()-(getHeight()/6) , getWidth()*2, getHeight()+(getHeight()/4));
g.setColor(Color.BLACK);
g.drawOval(getOver() + getWidth()-5 , getDown()-(getHeight()/6) , getWidth()*2, getHeight()+(getHeight()/4));

//Wing
g.setColor(Color.RED);
g.fillArc(getOver() + 3*getWidth()/2, getDown() + getHeight()/4 , getWidth(), getHeight(),180,110);
g.setColor(Color.BLACK);
g.drawArc(getOver() + 3*getWidth()/2, getDown() + getHeight()/4, getWidth(), getHeight(), 180, 110);

//head
g.setColor(Color.RED);
g.fillOval(getOver(), getDown(), getWidth(), getHeight() );
g.setColor(Color.BLACK);
g.fillOval(getOver() + (getWidth()/5), getDown() + (getHeight()/4), getWidth()/4, getHeight()/4 );
g.drawOval(getOver(), getDown(), getWidth(), getHeight() );


}

}

