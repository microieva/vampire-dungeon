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
public class Vampire implements Movable {
    private int x;
    private int y;
    private Player player = new Player();
   
    public Vampire() {
        this.x = x;
        this.y = y;
    }
    
    public void move(int xx, int yy) {
        if (!coordinateCheck(xx, yy)) {
            this.x = xx;
            this.y = yy;
        }
    }
    
    public String toString() {
        return "v "+this.x+" "+this.y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public boolean vampireKilled(int xx, int yy) {
        return this.x == xx && this.y == yy;
    }
    
    public boolean coordinateCheck(int xx, int yy) {
        return (this.x == xx && this.y == yy) || (player.getX() == xx && player.getY() == yy);   
    }
}
