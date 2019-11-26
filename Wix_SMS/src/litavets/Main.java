package litavets;

public class Main {

	public static int solution(String S, int K) {
		int count = 1;
		String[] arr = S.split(" ");
		StringBuilder sms = new StringBuilder(K);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > K)
				return -1;
			if (sms.length() + arr[i].length() <= K) {
				sms.append(arr[i]);
				if (i + 1 < arr.length && (sms.length() + 1 + arr[i + 1].length() <= K)) {
					sms.append(" ");
				}
			} else {
				System.out.println("SMS #" + count + ": " + sms);
				sms.delete(0, K);
				count++;
				sms.append(arr[i]);
				if (i + 1 < arr.length && (sms.length() + 1 + arr[i + 1].length() <= K)) {
					sms.append(" ");
				}
			}
		}
		System.out.println("SMS #" + count + ": " + sms);

		return count;
	}


	public static void main(String[] args) {

		String S = "SMS messages are really short. But that's OK, whatever. Fuck!!!";
		int K = 24;

		int res = solution(S, K);

		System.out.println("Fits into " + res + " SMS.");
	}
}