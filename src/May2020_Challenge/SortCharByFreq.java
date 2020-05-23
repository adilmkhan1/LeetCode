package May2020_Challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharByFreq {

	// Ascii value of A - 65 ----90
	// Ascii value of a - 97 ----122

	public static String frequencySort(String str) {
		if (str == null || str.length() == 0)
			return str;

		HashMap<Character, Integer> freqMap = new HashMap<>();

		for (Character c : str.toCharArray()) {
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}

		List<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> a, Entry<Character, Integer> b) {

				return b.getValue() - a.getValue();
			}

		});

		StringBuilder sb = new StringBuilder(list.size());

		for (Map.Entry<Character, Integer> es : list) {
			for (int i = 0; i < es.getValue(); i++) {
				sb.append(es.getKey());
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		String str = "Aabb";

		String str1 = "tree";

		//System.out.println(frequencySort(str));

		System.out.println(frequencySort(str1));

	}

}
