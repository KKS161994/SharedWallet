package in.silive.SharedWallet;

import java.io.IOException;

import android.util.Log;

public class calculation {
	public String[] get(int a[], int n, String b[]) throws IOException {
		String fa[]=new String[1000];
		int give[] = new int[100];
		int i, sum = 0, ind = 0,u=0;
		for (i = 0; i < n; i++)
			sum += a[i];
		ind = sum / n;
		for (i = 0; i < n; i++) {
			give[i] = a[i] - ind;

		}
		for (i = 0; i < n; i++) {
			if (give[i] > 0) {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						if (give[j] < 0) {
							if (Math.abs(give[j]) >= Math.abs(give[i])) {
								if (give[i] != 0) {
									fa[u++]=b[i] + " take  Rs "
											+ Math.abs(give[i]) + " from "
											+ b[j] + "\n";

									Log.d("Getting fa","fa="+fa[u-1]);
								}
								give[j] = give[j] + give[i];
								give[i] = 0;
							} else {
								if (give[j] != 0)
								{									fa[u++]=b[i] + " take  Rs "
										+ Math.abs(give[j]) + " from "
										+ b[j] + "\n";
								Log.d("Getting fa","fa="+fa[u-1]);
								}
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
								if (give[i] != 0)
									{fa[u++]=b[j] + " take  Rs "
											+ Math.abs(give[i]) + " from "
											+ b[i] + "\n";
									Log.d("Getting fa","fa="+fa[u-1]);
									}
								give[j] = give[j] + give[i];
								give[i] = 0;
							} else {
								if (give[j] != 0)
								{	fa[u++]=b[j] + " take  Rs "
										+ Math.abs(give[j]) + " from "
										+ b[i] + "\n";
								Log.d("Getting fa","fa="+fa[u-1]);
								}
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
		return fa;
	}

}
