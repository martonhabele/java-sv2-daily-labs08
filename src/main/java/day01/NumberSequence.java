package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {
    private List<Integer> numbers = new ArrayList<>();

    public NumberSequence(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public NumberSequence(int count, int minValue, int maxValue) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(minValue, maxValue + 1));
        }
    }

    public List<Integer> closeToAvg(int value) {
        List<Integer> result = new ArrayList<>();
        double avg = calculateAvg();
        for (Integer scopedNumber : numbers) {
            if (Math.abs(scopedNumber - avg) <= value) {
                result.add(scopedNumber);
            }
        }
        return result;
    }

    public double calculateAvg() {
        double sum = 0;
        for (Integer scopedNumber : numbers) {
            sum += scopedNumber;
        }
        return sum / numbers.size();
    }
}