package numberrangesummarizer;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
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
        List<String> groupedRanges = numbers.stream()
                .collect(Collectors.groupingBy(
                        (Integer num) -> num - new ArrayList(numbers).indexOf(num),
                        Collectors.toList()
                ))
                .values()
                .stream()
                .map(group -> {
                    int start = group.get(0);
                    int end = group.get(group.size() - 1);
                    return start == end ? String.valueOf(start) : start + "-" + end;
                })
                .collect(Collectors.toList());

        return groupedRanges.toString();
    }
}