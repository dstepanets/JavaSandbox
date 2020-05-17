package dstepanets.hackerrank.lotus.r2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;



class Result {
	private static final int SPACE = 32;
	private static final int A = 65;
	private static final int Z = 90;

	public static int parseNum(String encoded, int i, int j) {
		String numStr = encoded.substring(i, j + 1);
		return Integer.parseInt(numStr);
	}

	public static String decode(String encoded) {
		StringBuilder decoded = new StringBuilder();
		encoded = new StringBuilder(encoded).reverse().toString();

		int i = 0, j = 0, num;
		while (i < encoded.length() && j < encoded.length()) {
			j = i + 1;
			num = parseNum(encoded, i, j);
			if (num != SPACE && (num < A || num > Z) && (num < 97 || num > 99)) {
				j = i + 2;
				num = parseNum(encoded, i, j);
			}
			decoded.append(Character.toChars(num));
			i = j + 1;
		}
		return decoded.toString();
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

		String encoded = bufferedReader.readLine();

		String result = Result.decode(encoded);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}

