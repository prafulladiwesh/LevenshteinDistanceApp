package com.app.service;

/**
 * Class to implement Levenshtein Distance Algorithm. Levenshtein distance between two strings 
 * is the minimum number of single-character edits (insertions, deletions or substitutions) 
 * required to change one word into the other. This implementation is case sensitive.
 * 
 * References :
 * 1. https://en.wikipedia.org/wiki/Levenshtein_distance
 * 2. https://dzone.com/articles/the-levenshtein-algorithm-1
 * 3. https://stackoverflow.com/
 * 4. https://stackoverflow.com/questions/30685641/explanation-on-integer-max-value-and-integer-min-value-to-find-min-and-max-value
 * 
 * @author Prafulla Diwesh(prafulladiwesh@gmail.com)
 *
 */
public class LevenshteinDistance {
	
	
	/**
	 * Method to calculate Levenshtein Distance.
	 * 
	 * @param token1
	 * @param token2
	 * @return Distance value as an integer
	 * @throws Exception 
	 */
	public int levenshtein(String token1, String token2) throws Exception {
		// Assign maxDist to a very high number so that it is always greater than any value
		int maxDist = Integer.MAX_VALUE;
		
		// Using MethodOverloading to avoid repetition of same parts of code
		return levenshtein(token1, token2, maxDist);
	}
	
	
	/**
	 * Method to calculate Levenshtein Distance with early exit scenario if
	 * distance exceeds maximum distance.
	 * 
	 * @param token1
	 * @param token2
	 * @param maxDist
	 * @return Distance value as an integer
	 * @throws Exception 
	 */
	public int levenshtein(String token1, String token2, int maxDist) throws Exception {
		
		// Check if the Strings are not null to avoid null pointer exception
		if (token1 == null || token2 == null)
			// Returning value as -1 in case of null
			throw new Exception("token1 or token 2 is Null!!");
		
		
		// Upper bound is at most the length of longer string
		if (token1.isEmpty())
			return token2.length();
		
		if (token2.isEmpty())
			return token1.length();
		
		
		// Distance is zero if and only if the the strings are equal(case sensitive)
		if (token1.equals(token2))
			return 0;
		
		
		return calculateDistance(token1, token2, maxDist);
	}

	
	/**
	 * Method to calculate distance between token1 and token2. Early stopping using maxDist.
	 * The time and space complexity of this method is O(mn) where m and n are the lengths
	 * of token1 and token2 respectively.
	 * 
	 * @param token1
	 * @param token2
	 * @param maxDist
	 * @return Integer distance between token1 and token2
	 */
	private int calculateDistance(String token1, String token2, int maxDist) {
		/*
		 * Cost keys
		 * 
		 * +------------------+
		 * | Replace | Insert |
		 * |---------|--------|
		 * | Delete  |        |
		 * +------------------+
		 * 
		 */
		int v0[] = new int[token2.length() + 1];
		int v1[] = new int[token2.length() + 1];
		int temp[];
		int minVal;
		
		for(int i=0; i <= token2.length(); i++) {
			// Initialize v0 as a empty string with a length of token2
			// Size of v0 is length_of_token2 + 1 with values starting from 0 to length_of_token2
			v0[i] = i;
		}
		
		// Treat each substring of token1 as one string and compare it with token2
		for (int i=0; i < token1.length(); i++) {
			//Set minimum value as first value of current row
			minVal = i + 1;
			// Set first value of current row to current row number
			v1[0] = i + 1;
			
			// Compute distance with token2 for each substring
			for (int j=0; j < token2.length(); j++) {
				
				if (token1.charAt(i) == token2.charAt(j)) {
					// If characters are same then cost is equal to previous replacement cost
					v1[j+1] = v0[j];
				} else {
					// Deletion cost = v0[j+1] + 1 
					// Insertion cost = v1[j] + 1
					// Replacement cost = v0[j] + 1
					v1[j+1] = Math.min(Math.min(v0[j+1], v1[j]), v0[j]) + 1;
				}
				
				// Set minimum value as minimum of first value and last value of current row
				// This checks the distance for each of the token1's substrings and assigns minimum value
				minVal = Math.min(minVal, v1[j+1]);
			}
			
			// Return maxDist + 1 if it is less than minimum value
			if (maxDist < minVal)
				return maxDist + 1;
			
			// Swap v0 with v1
			// Copy v1(current row) to v0(previous row) for next iteration
			temp =  v1;
			v1 = v0;
			v0 = temp;
		}
		
		// Final cost/distance is the value present at the last index of v0 as v1 is swapped with v0
		return v0[token2.length()];
	}
	

	/**
	 * Method to measure time performance of the distance calculation.
	 * Final time is the average of 5 distance calculation to avoid warmup iteration problem.
	 * 
	 * @param token1
	 * @param token2
	 * @throws Exception 
	 */
//	public void measurePerformance(String token1, String token2) throws Exception {
//		long time = 0;
//		for (int i=0; i<5; i++) {
//			long startTime = System.nanoTime();
//			levenshtein(token1, token2);
//			long elapsedTime = System.nanoTime() - startTime;
//			time = time + elapsedTime;
//		}
//        double seconds = ((double)time/5) / 1_000_000_000.0;
//		System.out.println("Levenshtein distance calculation between "+token1+" and "+token2+" "
//				+ "took "+seconds+" seconds.");
//	}
	
	/**
	 * Method to measure time performance of the distance calculation with early stopping value.
	 * Final time is the average of 5 distance calculation to avoid warmup iteration problem.
	 * 
	 * @param token1
	 * @param token2
	 * @param maxDist
	 * @throws Exception 
	 */
//	public void measurePerformanceWithMaxDist(String token1, String token2, int maxDist) throws Exception {
//		long time = 0;
//		for (int i=0; i<5; i++) {
//			long startTime = System.nanoTime();
//			levenshtein(token1, token2, maxDist);
//			long elapsedTime = System.nanoTime() - startTime;
//			time = time + elapsedTime;
//		}
//        double seconds = ((double)time/5) / 1_000_000_000.0;
//		System.out.println("Levenshtein distance calculation between "+token1+" and "+token2+
//				" with early stopping value "+maxDist+" took "+seconds+" seconds.");
//	}

}
