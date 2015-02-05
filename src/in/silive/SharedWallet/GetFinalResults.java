package in.silive.SharedWallet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GetFinalResults {
	public static void main(String args[]) throws IOException {
		int a[] = new int[100];
		int give[] = new int[100];
		int i, sum = 0, ind = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of persons");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter the amount for each person ");
		for (i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			sum += a[i];
		}
		ind = sum / n;
		System.out.println(ind);
		for (i = 0; i < n; i++) {
			give[i] = a[i] - ind;

		}
		for (i = 0; i < n; i++) {
			if (give[i] > 0) {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						if (give[j] < 0) {
							if (Math.abs(give[j]) >= Math.abs(give[i])) {
								System.out.println((i + 1) + "take  Rs "
										+ Math.abs(give[i]) + " from "
										+ (j + 1));

								give[j] = give[j] + give[i];
								give[i] = 0;
							} else {
								System.out.println((i + 1) + " take  Rs "
										+ Math.abs(give[j]) + " from "
										+ (j + 1));
								give[i] = give[i] + give[j];
								give[j] = 0;

							}
						}
					} else {
						continue;
					}
				}

			} else {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						if (give[j] > 0) {
							if (Math.abs(give[j]) > Math.abs(give[i])) {
								System.out.println((j + 1) + "take  Rs "
										+ Math.abs(give[i]) + " from "
										+ (i + 1));

								give[j] = give[j] + give[i];
								give[i] = 0;
							} else {
								System.out.println((j + 1) + " take  Rs "
										+ Math.abs(give[j]) + " from "
										+ (i + 1));
								give[i] = give[i] + give[j];
								give[j] = 0;

							}
						}
					} else {
						continue;
					}
				}

			}
		}
	}
}