import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SupplyStacks
{
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("supply_stacks_input.txt"));

        String[][] space = new String[9][50];
        int[] counts = new int[9];

        int c = 0;
        int c2;
        int x;
        int n;
        int[] numbers = new int[3];
        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            c2 = 0;
            if (c < 8) {
                c2 -= 1;
                x = 0;
                for (String s : line.split("")) {
                    if (c2 % 4 == 0) {
                        if (!s.equals(" ")) {
                            space[x][Math.abs(c - 7)] = s;
                            if (Math.abs(c - 7) > counts[x]) counts[x] = Math.abs(c - 7);
                        }
                        x++;
                    }
                    c2++;
                }
            }
            else if (c > 9)
            {
                for (String s : line.split(" ")) {
                    try { n = Integer.parseInt(s); }
                    catch (Exception e) { n = 0;}
                    if (n != 0) {
                        numbers[c2] = n - 1;
                        c2++;
                    }
                }
                counts[numbers[1]] -= numbers[0] + 1;
                for (int i = 1; i <= numbers[0] + 1; i++) {
                    counts[numbers[2]]++;
                    space[numbers[2]][counts[numbers[2]]] = space[numbers[1]][counts[numbers[1]] + i];
                    space[numbers[1]][counts[numbers[1]] + i] = null;
                }
            }
            c++;
        }

        for (int i = 0; i < 9; i++) result.append(space[i][counts[i]]);
        System.out.println(result);
    }
}