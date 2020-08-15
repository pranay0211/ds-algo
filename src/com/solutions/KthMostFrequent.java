package com.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/***
 * Given a list of strings, write a function to get the kth most frequently
 * occurring string.
 * 
 * @author pranay
 *
 */
public class KthMostFrequent {

	public String kTHmostFreqElement(String[] strings, int k) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String s : strings) {
			Integer x = map.get(s);
			if (x == null)
				x = 0;
			map.put(s, ++x);
		}

		List lStr = new ArrayList<>(map.entrySet());

		Collections.sort(lStr, new Comparator() {

			public int compare(Object o1, Object o2) {
				Integer x1 = (Integer) ((Map.Entry) o1).getValue();
				Integer x2 = (Integer) ((Map.Entry) o2).getValue();
				return x1.compareTo(x2);
			}
		});

		if (k > lStr.size())
			return null;
		else
			return (String) ((Entry)(lStr.get(k))).getKey();
	}

	public static void main(String... strings) {
		System.out.println(new KthMostFrequent()
				.kTHmostFreqElement("pranay pranay pranay aa aa k y cddd cddd cddd cddd".split("\\ "), 2));
	}

}
