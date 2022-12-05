import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CalorieCounting
{
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("calorie_counting_input.txt"));

        List<Integer> topCalories = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) topCalories.add(0);

        AtomicInteger topCaloriesTotal = new AtomicInteger();
        int calories = 0;

        for (String line : lines) {
            if (!line.isEmpty()) calories += Integer.parseInt(line);
            else {
                for (int topCalorie : topCalories) if (calories > topCalorie) {
                    replaceLowest(topCalories, calories);
                    break;
                }
                calories = 0;
            }
        }

        topCalories.forEach(topCaloriesTotal::addAndGet);
        System.out.println(topCaloriesTotal);
    }

    public static void replaceLowest(List<Integer> topCalories, int replaceWith) {
        final Integer[] lowest = {topCalories.get(0)};
        topCalories.forEach(calorie -> lowest[0] = Math.min(lowest[0], calorie));
        topCalories.remove(lowest[0]);
        topCalories.add(replaceWith);
    }
}
