import java.util.List;

public class Player {
    Integer id;
    String name;
    String country;
    String initialTime;
    String finalTime;
    Integer faultTime;

    Player(Integer id, String name, String country, String initialTime, String finalTime, Integer faultTime){
        this.id = id;
        this.name = name;
        this.country = country;
        this.initialTime = initialTime;
        this.finalTime = finalTime;
        this.faultTime = faultTime;
    }

    Integer getId(){
        return id;
    }

    String getName(){
        return name;
    }

    String getInitialTime(){
        return  initialTime;
    }
    String getFinalTime(){ return finalTime;}

    String getCountry(){
        return country;
    }
    Integer getFaultTime(){ return  faultTime;}

    @Override
    public String toString() {
        return  name + " " + finalTime + " (" + initialTime + " + " + faultTime + ")";
    }
}
