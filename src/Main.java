public class Main {
    public static void main(String[] args) {
        Day1 DayOne = new Day1();
        System.out.println("The result from day1 part1: " + DayOne.firstPart());
        System.out.println("The result from day1 part2: " + DayOne.secondPart());

        Day2 dayTwo = new Day2();
        int resultDayTwoPartOne = dayTwo.solveDay(1);
        System.out.println(resultDayTwoPartOne + " password are valid in day two part one.");

        int resultDayTwoPartTwo = dayTwo.solveDay(2);
        System.out.println(resultDayTwoPartTwo + " password are valid in day two part two.");

        Day3 dayThree = new Day3();
        long resultDayThreePartOne = dayThree.solveDay(1);
        System.out.println(resultDayThreePartOne + " trees were hit by the toboggan");

        long resultDayThreePartTwo = dayThree.solveDay(2);
        System.out.println(resultDayThreePartTwo + " trees were hit by the toboggan");
    }
}

