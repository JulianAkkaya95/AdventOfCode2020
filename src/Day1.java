import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day1 {

    public static void main(String[] args) {
        List<Integer> input = getInput();
    }

    public int firstPart() {
        List<Integer> input = getInput();
        int firstNumber = -1;
        int secondNumber = -1;

        for (int x : input) {
            firstNumber = x;
            secondNumber = input.stream()
                    .filter(x1 -> 2020 - x == x1)
                    .findFirst()
                    .orElse(-1);
            if (secondNumber != -1) {
                break;
            }
        }
        return (firstNumber * secondNumber);
    }

    public int secondPart() {
        List<Integer> input = getInput();
        int firstNumber = -1;
        int secondNumber = -1;
        int thirdNumber = -1;

        for (int x : input) {
            firstNumber = x;
            List<Integer> possibleResults = input.stream()
                    .filter(x1 -> 2020 - x >= x1)
                    .collect(Collectors.toList());
            for (int x1 : possibleResults) {
                secondNumber = x1;
                thirdNumber = possibleResults.stream()
                        .filter(x2 -> 2020 - x - x1 == x2)
                        .findFirst()
                        .orElse(-1);
                if (thirdNumber != -1) {
                    break;
                }
            }
            if (thirdNumber != -1) break;
        }
        return (firstNumber * secondNumber * thirdNumber);
    }

    public static List<Integer> getInput() {
        List<Integer> input = new ArrayList<>();
        try {
            File file = new File("input/day1.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                input.add(Integer.parseInt(inputLine));
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return input;
    }
}