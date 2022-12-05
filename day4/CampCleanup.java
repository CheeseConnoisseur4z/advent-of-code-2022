import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CampCleanup
{
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("camp_cleanup_input.txt"));

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        String[] split;
        int result = 0;
        
        for (String line : lines) {
            split = line.split(",");
            addNumbers(split, 0, first);
            addNumbers(split, 1, second);
            for (Integer n : first) if (second.contains(n)) {
                result++;
                break;
            }
        }

        System.out.println(result);
    }

    static void addNumbers(String[] split, int i, List<Integer> arrayList) {
        arrayList.clear();
        for (int n = Integer.parseInt(split[i].split("-")[0]); n <= Integer.parseInt(split[i].split("-")[1]); n++) {
            arrayList.add(n);
        }
    }
}
