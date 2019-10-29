/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author ieva
 */
public class Player implements Movable {
    
    private int x;
    private int y;
    
    public Player() {
        this.x = 0;
        this.y = 0;
    }
    
    public void move(int xx, int yy) {
        this.x = xx;
        this.y = yy;
    }
    
    public String toString() {
        return "@ "+this.x+" "+this.y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}
