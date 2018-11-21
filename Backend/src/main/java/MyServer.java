import java.util.ArrayList;
import java.util.List;

public class MyServer {
    private int id;
    private List<Fight> fights = new ArrayList<Fight>();

    public MyServer() {}

    public void createFight(Rooster rooster1){
        Rooster computerRooster = new Rooster();
        new Fight(rooster1, computerRooster);
    }
}
