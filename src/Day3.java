import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {
    int requestedPart;
    int currentPositionX = 0;
    int counterTrees = 0;
    int tobogganConfigMoveDownSize;
    int tobogganConfigMoveRightSize;

    int[][][] slopes = {
            {
                {3, 1}
            },
            {
                {1, 1},
                {3, 1},
                {5, 1},
                {7, 1},
                {1, 2},
            }
    };

    public static void main(String[] args) {
    }

    public long solveDay(int part) {
        requestedPart = part;
        List<char[]> map = getInput();
        long result = 1;

        for (int i = 0; i < slopes[part - 1].length; i++){
            configureToboggan(slopes[part - 1][i]);
            useToboggan(map);
            result *= counterTrees;
            counterTrees = 0;
            currentPositionX = 0;
        }

        return result;
    }

    private void useToboggan(List<char[]> map) {
        for (int i = tobogganConfigMoveDownSize; i < map.size();) {
            moveRight();
            int abstractYPosition =  getAbstractYPosition(map.get(i).length);
            analyseLocation(map.get(i)[abstractYPosition]);
            i += tobogganConfigMoveDownSize;
        }
    }

    private void configureToboggan(int[] configurations) {
        tobogganConfigMoveRightSize = configurations[0];
        tobogganConfigMoveDownSize = configurations[1];
    }

    private int getAbstractYPosition(int mapLengthX) {
        return currentPositionX % mapLengthX;
    }

    private void moveRight() {
        currentPositionX += tobogganConfigMoveRightSize;
    }

    private void analyseLocation(char location) {
        if(location == '#') {
            counterTrees++;
        }
    }

    private List<char[]> getInput() {
        List<char[]> input = new ArrayList<>();

        try {
            File file = new File("input/day3.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                input.add(inputLine.toCharArray());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return input;
    }
}
