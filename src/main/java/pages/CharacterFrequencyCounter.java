package pages;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CharacterFrequencyCounter {

    public static void main(String[] args) {
        // Input string
        String str = "aaabbcddd";
        //output string output: a2b2c1d3

        // LinkedHashMap to maintain the order of characters
        Map<Character, Integer> map = new LinkedHashMap<>();

        // Count character frequencies
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Build the output string
        StringBuilder output = new StringBuilder();
        for (Entry<Character, Integer> entry : map.entrySet()) {
            output.append(entry.getKey()).append(entry.getValue());
        }

        // Print the result
        System.out.println(output.toString());
    }
}
