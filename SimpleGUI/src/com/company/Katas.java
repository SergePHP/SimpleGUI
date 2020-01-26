package com.company;

import java.util.*;
import java.util.Map.Entry;

import javafx.util.Pair;

public class Katas {

	public static void main(String[] args) {

		System.out.println(listSquared(567, 5545));

	}
	public static String listSquared(long m, long n) {

		List<Pair<Long, Long>> list = new ArrayList<>();
		
		for (long i = m; i <= n; i++) {
			Map<Integer, Integer> canonical = new HashMap<>();

			long value = i; 
			int multiplier = 2;
			
			do {
				if (value == 1) {
					canonical.put(1, 1);
				} else if (value % multiplier == 0) {
					value = value / multiplier;
					canonical.put(multiplier, canonical.get(multiplier) == null ? 1 
							: canonical.get(multiplier) + 1);
					multiplier = 1;
				}
				++multiplier;
			} while (value != 1);

			Set<Map.Entry<Integer, Integer>> set = canonical.entrySet();
			Iterator<Entry<Integer, Integer>> iterator = set.iterator();
			
			SortedSet<Integer> dividers = getDividers(iterator);
			
			
			int a = 0;
		}
		
		return "";
	}
	public static SortedSet<Integer> getDividers(Iterator<Entry<Integer, Integer>> iterator){
		
		
		
		
		return new TreeSet<>();
	}
}
