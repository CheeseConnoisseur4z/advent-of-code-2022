package tom.adventOfCode.day2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RockPaperScissorsTournament {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\tomsa\\git\\tom\\chess\\src\\main\\java\\tom\\adventOfCode\\day2\\rock_paper_scissors_input.txt"));
        int points = 0;
        int[] choicePoints = {2, 3, 1}, resultPoints = {0, 3, 6};
        for (String line : lines) points += resultPoints[line.charAt(2) - 88] + (line.charAt(0) - 65 + choicePoints[line.charAt(2) - 88]) % 3 + 1;
        System.out.println(points);
    }
}