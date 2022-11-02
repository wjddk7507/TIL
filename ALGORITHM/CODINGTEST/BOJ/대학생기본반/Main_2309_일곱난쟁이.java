package com.junga.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {
	static int N, sum;
	
	public static void main(String[] args) throws Exception {
		N = 9;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[N];
		sum = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		sum -= 100;
		Arrays.sort(arr);
		int a = 0, b = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i]+arr[j] == sum) {
					a = i;
					b = j;
					break;
				}
			}
			if(a!=0 && b!=0) break;
		}
		for(int i = 0; i < N; i++) {
			if(i != a && i != b) System.out.println(arr[i]);
		}
	}
}
