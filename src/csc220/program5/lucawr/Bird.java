
import csc220.list.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wil
 */
//Begin Contructor 
public class Bird extends csc220.program5.GameCharacter {
    
    private Color feather, feather2;
    
public Bird(int over, int down, int width, int height, Color f, Color g) {   
 super(over, down, width, height, 500, new List<Point>() );
    f = feather;
    g = feather2;
 
}
//end constructor

public void draw(Graphics g){



//beak
g.setColor(Color.ORANGE);
g.fillArc(getOver() - getWidth() +5, getDown() + (getHeight()/4), getWidth(),getHeight()/2 ,15, -30);

//tail
g.setColor(feather);
g.fillArc(getOver() + 7*getWidth()/3, getDown() + getHeight()/50, getWidth(), getHeight(), 30, -60);
g.setColor(feather2);
g.fillArc(getOver() + 7*getWidth()/3, getDown() + getHeight()/50, getWidth(), getHeight(), 10, -20);

//body
g.setColor(feather);
g.fillOval(getOver() + getWidth()-5 , getDown()-(getHeight()/6) , getWidth()*2, getHeight()+(getHeight()/4));
g.setColor(Color.BLACK);
g.drawOval(getOver() + getWidth()-5 , getDown()-(getHeight()/6) , getWidth()*2, getHeight()+(getHeight()/4));

//Wing
g.setColor(feather);
g.fillArc(getOver() + 3*getWidth()/2, getDown() + getHeight()/4 , getWidth(), getHeight(),180,110);
g.setColor(Color.BLACK);
g.drawArc(getOver() + 3*getWidth()/2, getDown() + getHeight()/4, getWidth(), getHeight(), 180, 110);

//head
g.setColor(feather);
g.fillOval(getOver(), getDown(), getWidth(), getHeight() );
g.setColor(Color.BLACK);
g.fillOval(getOver() + (getWidth()/5), getDown() + (getHeight()/4), getWidth()/4, getHeight()/4 );
g.drawOval(getOver(), getDown(), getWidth(), getHeight() );


}

}

