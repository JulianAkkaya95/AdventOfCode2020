import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    int requestedPart;

    public static void main(String[] args) {

    }

    public int solveDay(int part) {
        int counterValidPassword = 0;
        List<String> inputs = getInput();
        requestedPart = part;

        for (String input : inputs) {
            if (isPasswordValid(input)) {
                counterValidPassword++;
            }
        }

        return counterValidPassword;
    }

    public boolean isPasswordValid(String input) {
        String password;
        char patternChar;
        int patternIntOne;
        int patternIntTwo;

        String[] patternAndPassword = splitStringInPasswordAndPattern(input);
        password = patternAndPassword[1];

        String[] patternCharAndRange = splitPatternInCharAndRange(patternAndPassword[0]);
        patternChar = patternCharAndRange[1].charAt(0);

        int[] patternMinAndMax = splitRangeInMinAndMax(patternCharAndRange[0]);
        patternIntOne = patternMinAndMax[0];
        patternIntTwo = patternMinAndMax[1];

        if (requestedPart == 1) {
            return comparePatternAndPassword(patternIntOne, patternIntTwo, patternChar, password);
        } else {
            return comparePatternAndPasswordPartTwo(patternIntOne, patternIntTwo, patternChar, password);
        }

    }

    public String[] splitStringInPasswordAndPattern(String input) {
        return input.split(": ");
    }

    public String[] splitPatternInCharAndRange(String pattern) {
        return pattern.split(" ");
    }

    public int[] splitRangeInMinAndMax(String patternRange) {
        String[] minAndMaxString = patternRange.split("-");

        return new int[]{Integer.parseInt(minAndMaxString[0]), Integer.parseInt(minAndMaxString[1])};
    }

    public boolean comparePatternAndPassword(int patternIntMin, int patternIntMax, char patternChar, String password) {
        boolean isValidPassword;

        int numberOfValidChars = countValidChars(password.toCharArray(), patternChar);
        isValidPassword = numberOfValidChars >= patternIntMin && numberOfValidChars <= patternIntMax;

        return isValidPassword;
    }

    public boolean comparePatternAndPasswordPartTwo(int patternIntOne, int patternIntTwo, char patternChar, String password) {
        boolean isValidPassword = false;

        boolean isValidPatternCharOne = isValidPasswordChar(--patternIntOne, password, patternChar);
        boolean isValidPatternCharTwo = isValidPasswordChar(--patternIntTwo, password, patternChar);

        if (isValidPatternCharOne || isValidPatternCharTwo) {
            isValidPassword = true;
        }

        if (isValidPatternCharOne && isValidPatternCharTwo) {
            isValidPassword = false;
        }

        return isValidPassword;
    }

    private boolean isValidPasswordChar(int patternInt, String password, char patternChar) {
        boolean isValidChar;

        try {
            isValidChar = password.charAt(patternInt) == patternChar;
        } catch (StringIndexOutOfBoundsException e) {
            isValidChar = false;
        }

        return isValidChar;
    }

    public int countValidChars(char[] password, char patternChar) {
        int counterValidChars = 0;

        for (char onePasswordChar : password) {
            if (onePasswordChar == patternChar) {
                counterValidChars++;
            }
        }

        return counterValidChars;
    }

    public List<String> getInput() {
        List<String> input = new ArrayList<>();

        try {
            File file = new File("input/day2.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                input.add(inputLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return input;
    }
}
