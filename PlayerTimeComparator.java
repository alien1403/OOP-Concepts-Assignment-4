import java.util.Comparator;

public class PlayerTimeComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2){
        return p1.finalTime.compareTo(p2.finalTime);
    }
}
