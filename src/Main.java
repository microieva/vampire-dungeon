import dungeon.Dungeon;
import dungeon.ui.UserInterface;
import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args) {
        new Dungeon(10,10,5,14,true).run();
        //SwingUtilities.invokeLater(new UserInterface(new Dungeon(10,10,5,14,true)));
    }
    // 1) length;
    // 2) height;
    // 3) number of vampires;
    // 4) number of turns; 
    // 5) vampires move/not move each turn;
}
