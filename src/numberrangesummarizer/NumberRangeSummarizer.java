package numberrangesummarizer;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class NumberRangeSummarizer implements INumberRangeSummarizer {

    public Collection<Integer> collect(String input) {
        List<Integer> numbers = new ArrayList<>();

        // Split the input string by commas and convert to integers
        String[] tokens = input.split(",");
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return numbers;
    }

    public String summarizeCollection(Collection<Integer> numbers) {
        // Check if the collection is empty
        if (numbers.isEmpty()) {
            return "";
        }
        List<Integer>  listNumbers = new ArrayList(numbers);

        List<String> result = new ArrayList<>();
        int start = listNumbers.get(0);
        int end = listNumbers.get(0);

        // Iterate through the numbers to find and group sequential ranges
        for (int i = 1; i < numbers.size(); i++) {
            if (listNumbers.get(i) == end + 1) {
                end = listNumbers.get(i);
            } else {
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "-" + end);
                }
                start = end = listNumbers.get(i);
            }
        }

        // Add the last range or single number
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "-" + end);
        }

        return result.toString();
    }
}