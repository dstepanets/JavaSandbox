package dstepanets.hackerrank.lotus.ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;



class Result {

	/*
	 * Complete the 'oddNumbers' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. INTEGER l
	 *  2. INTEGER r
	 */

	public static List<Integer> oddNumbers(int l, int r) {
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = l; i <= r; i++) {
			if (i % 2 != 0) {
				res.add(i);
			}
		}
		return res;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int l = Integer.parseInt(bufferedReader.readLine().trim());

		int r = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> result = Result.oddNumbers(l, r);

		bufferedWriter.write(
				result.stream()
						.map(Object::toString)
						.collect(joining("\n"))
						+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}
}

