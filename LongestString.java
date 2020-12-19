package com.wipro.javapractice;

import java.util.ArrayList;

public class BrainPuzzles {
	static void brainPuzzlers(int input, int K) {
		StringBuilder builder = new StringBuilder(Integer.toString(input));
		if (builder.reverse() == new StringBuilder(input)) {
			System.out.println(1);
		} else {
			char[] charArr = Integer.toString(input).toCharArray();
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			for (char c : charArr) {
				arrayList.add(Character.getNumericValue(c) * 5);
			}
//			System.out.println(arrayList);
			ArrayList<Integer> PrimeSumList = new ArrayList<Integer>();
			for (int i = 0; i < arrayList.size(); i++) {
				int primeSum = 0;
				for (int j = 1; j < arrayList.get(i); j++) {
					int primeCount = 0;
					for (int k = 1; k <= j; k++) {
						if (j % k == 0) 
							primeCount++;
					}
					if (primeCount == 2) {
						int var = (2 * j) + 1;
						if (var < arrayList.get(i))
							primeSum += var;
					}
				}
				PrimeSumList.add(primeSum);
			}
			System.out.println(PrimeSumList);
			int Kdiv=0;
			for (int i = 0; i < PrimeSumList.size(); i++) {
				for (int j = i + 1; j < PrimeSumList.size(); j++) {
					if ((PrimeSumList.get(i) + PrimeSumList.get(j)) % K == 0)
						Kdiv++;
				}
			}
			System.out.println(Kdiv);
		}
	}

	public static void main(String[] args) {
		brainPuzzlers(46333, 3);
	}

}
