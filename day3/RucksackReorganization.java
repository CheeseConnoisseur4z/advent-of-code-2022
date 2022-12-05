import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RucksackReorganization
{
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("rucksack_reorganization_input.txt"));
        List<Character> charactersOfLine = new ArrayList<>();
        List<Character> groupType= new ArrayList<>();
        int total = 0;
        int count = 2;
        char group;

        for (String line : lines) {
            count++;
            
            if (count % 3 == 0) {
                charactersOfLine.clear();
                for (int i = 0; i < line.length(); i++) if (!charactersOfLine.contains(line.charAt(i))) 
                    charactersOfLine.add(line.charAt(i));
                }
                groupType = new ArrayList<>(charactersOfLine);
            } 
            else 
            {
                for (Character character : charactersOfLine) if (!line.contains(character + "")) 
                    groupType.remove(character);
                }
                if (groupType.size() == 1) {
                    group = groupType.get(0);
                    if (!Character.isUpperCase(group)) total += group - 96;
                    else {
                        total += group - 38;
                    }
                }
            }
        }

        System.out.println(total);
    }
}
