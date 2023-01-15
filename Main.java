import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        TreeSet<Player> players = new TreeSet<>(new PlayerTimeComparator());
        BufferedReader reader = new BufferedReader(
                new FileReader("data.csv")
        );

        String line = null;
        while((line = reader.readLine()) != null) {
            String[] el = line.split(",");
            Integer index = Integer.parseInt(el[0]);
            List<String> rounds = new ArrayList<>();
            rounds.add(el[4]);
            rounds.add(el[5]);
            rounds.add(el[6]);

            Integer minutesAdded = 0;
            for (int i = 0; i < rounds.size(); i = i + 1) {
                String aux = rounds.get(i);
                for (int j = 0; j < aux.length(); j = j + 1) {
                    if (aux.toCharArray()[j] == 'o') {
                        minutesAdded += 10;
                    }
                }
            }

            String[] time = el[3].split(":");
            Integer product = 1;
            Integer currTime = 0;
            for (int i = time.length - 1; i >= 0; i = i - 1) {
                Integer aux = Integer.parseInt(time[i]);
                currTime += aux * product;
                product *= 60;
            }
            currTime += minutesAdded;

            product = 60;
            String newTime = "";
            while (currTime != 0) {
                Integer aux = currTime % product;
                newTime += aux;
                newTime += ":";
                currTime = (currTime - (currTime % product)) / product;
                product *= 60;
            }

            String newString = newTime.substring(0, newTime.length() - 1);
            String[] auxString = newString.split(":");
            String finalTime = "";
            for (int i = auxString.length - 1; i >= 0; i -= 1) {
                finalTime += auxString[i];
                finalTime += ":";
            }

            finalTime = finalTime.substring(0, finalTime.length() - 1);

            players.add(new Player(index, el[1], el[2], el[3], finalTime, minutesAdded));
        }

        for(int i = 0;i<players.size();i++){
            if(i == 0){
                System.out.println("Winner - " + players.toArray()[i]);
            }else if(i == 1){
                System.out.println("Runner-up - " + players.toArray()[i]);
            }else if(i == 2){
                System.out.println("Third Place - " + players.toArray()[i]);
            }
        }
    }
}
