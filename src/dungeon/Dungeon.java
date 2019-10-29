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
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ieva
 */
public class Dungeon {
    private Scanner reader = new Scanner(System.in);
    private Vampire vampire;
    private Player player = new Player();
    private List <Vampire> livingVampires = new ArrayList<Vampire>();
    
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    
    private int a;
    private int b;
    
    public Dungeon() {
        
    }
 
    public Dungeon(int length, int height, int vampires, int moves, 
            boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        // initiate vampires:
        for (int n=0; n<this.vampires; n++) {
            this.vampire = new Vampire();
            livingVampires.add(vampire);
            vampire.move(new Random().nextInt(this.length), new Random().nextInt(this.height));    
        } 
        
        this.a = player.getX();
        this.b = player.getY(); 
    }
    
    public void run() {
        //System.out.println("w -> UP\ns -> DOWN\na -> LEFT\nd -> DOWN\nx -> END GAME\n");
        while (moves > 0) {
            System.out.println(moves+"\n");
            printLocations();
            System.out.println();
            System.out.print(this);
            System.out.println();
            String directions = reader.nextLine();
            playerMoves(directions);
            player.move(a, b);
            gameUpdate();
            moves--;
            
            if (livingVampires.isEmpty()) {
                System.out.println("YOU WIN");
                break;
            } else if (!livingVampires.isEmpty() && moves == 0){
                System.out.println("YOU LOSE");
                break;
            } else if (directions.equals("x")) {
                break;
            }
        }
    }
    
    public String printLocations() {
        System.out.println(player);
        for (Vampire living: livingVampires) {
            System.out.println(living); 
        }
        return "";
    }
    
    public void gameUpdate() {
        for (int v=0; v<livingVampires.size(); v++) {
            if (livingVampires.get(v).vampireKilled(a, b)) {
                ArrayList<Vampire> deadVampires = new ArrayList<Vampire>();
                deadVampires.add(livingVampires.get(v));
                livingVampires.removeAll(deadVampires);
            }
        }
        if (!livingVampires.isEmpty() && vampiresMove) {
            for (Vampire living: livingVampires) {
                living.move(new Random().nextInt(this.length), new Random().nextInt(this.height));
            }
        }
    }
    
    public String toString() {
        for (int i=0; i<length; i++) {
            for (int j=0; j<height; j++) {
                String x = ".";
                for (Vampire living: livingVampires) {
                    if (living.getX() == i && living.getY() == j) {
                        x = "v";
                    }
                }
                if (a==j && b==i) {
                    x = "@";
                }
                System.out.print(x);
            }
            System.out.println();
        } 
        return "";
    }
    
    public void playerMoves(String directions) {
        for (int i=0; i<directions.length(); i++) {
            switch (directions.charAt(i)) {
                case 'd':
                    this.a +=1;
                    if (!insideDungeon(a,b)) {
                        this.a-=1;
                    }   break;
                case 'a':
                    this.a-=1;
                    if (!insideDungeon(a,b)) {
                        this.a +=1;
                    }   break;
                case 'w':
                    this.b-=1;
                    if (!insideDungeon(a,b)) {
                        this.b+=1; 
                    }   break;
                case 's':
                    this.b+=1;
                    if (!insideDungeon(a,b)) {
                        this.b-=1;
                    }   break;
                default:
                    break;
            }
        }    
    }
    
    public boolean insideDungeon(int n, int m) {
        return (n >= 0 && n <= length-1) && (m >= 0 && m <= height-1); 
    }  
    
    public int getLength() {
        return this.length;
    }
    
    public int getHeight() {
        return this.height;
    }
}
