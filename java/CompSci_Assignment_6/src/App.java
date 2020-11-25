// Finn Lestrange 15/11/2020
// Computer Science HL - Assignment 6

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class App {
	
	// Data generated with google sheets randomint function
	public static int[][] s = {{7046,12829,7619,9408,12784,10544,5821,8434,10874,11639,9953,8181},
			{9956,5122,11146,9796,9530,9031,5220,10985,7399,9156,9954,10532},
			{9941,5799,6369,10915,8348,10637,11377,9952,12581,11689,5294,10017},
			{11826,7606,6143,7829,12520,12243,8169,12581,5627,9230,12426,7776},
			{11201,8999,7456,11790,11644,10869,6754,9269,12439,6968,6057,7608},
			{6969,12922,11688,7281,9166,6566,5109,12178,5919,9041,7814,9431},
			{7483,12353,10352,8594,5052,6631,7395,10811,12259,12833,9476,6711},
			{10879,9808,5306,10825,5407,9196,8823,6872,5831,10400,5658,12699},
			{11023,8885,6011,5010,9876,8081,8833,9473,5348,11375,8104,5666},
			{12024,11854,5501,8843,6851,9685,6001,7398,10542,9966,9741,6376}};
	
	private static String months(int m) {
		String out = "";
		switch (m) {
		case 0:
			out = "January";
			break;
		case 1:
			out = "February";
			break;
		case 2:
			out = "March";
			break;
		case 3:
			out = "April";
			break;
		case 4:
			out = "May";
			break;
		case 5:
			out = "June";
			break;
		case 6:
			out = "July";
			break;
		case 7:
			out = "August";
			break;
		case 8:
			out = "September";
			break;
		case 9:
			out = "October";
			break;
		case 10:
			out = "November";
			break;
		case 11:
			out = "December";
			break;
		} return out;
	}
	
	private static void minMaxSales(int[][] s) {
		int[] values = new int[12];
		
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				values[j] = values[j] + s[i][j];
			}
		}
		
		int max = 0;
		int min = 0;
		
		for (int i = 0; i < values.length; i++) {
			if (values[i] < min) {
				min = i;
			} else if (values[i] > max) {
				max = i;
			}
		}
		
		System.out.println(months(max) + ", had the most sales!");
		System.out.println(months(min) + ", had the least sales :(");
	}
	
	private static void zoneTotal(int z, int[][] s) {
		if (z < 0 || z > 10) {
			System.out.println("INVALID ZONE");
		} else {
			int total = 0;
			for (int i = 0; i < 12; i++) {
				total = total + s[z-1][i];
			}
			System.out.println("The total sales for zone: " + z + " was: " + total);
		}
	}
	
	private static void betterSales(int[][] s) {
		Queue<Integer> zones = new LinkedList<>();
		
		int[] first = new int[12];
		int[] second = new int[12];
		
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < 6; j++) {
				first[i] = first[i] + s[i][j];
			}
		}
		
		for (int i = 0; i < s.length; i++) {
			for (int j = 6; j < 12; j++) {
				second[i] = second[i] + s[i][j];
			}
		}
		
		for (int i = 0; i < first.length; i++) {
			if (second[i] > first[i]) {
				zones.add(i+1);
			}
		}
		
		while (!zones.isEmpty()) {
			System.out.println("Zone " + zones.poll() + " had better sales in the second half of the year!");
		}
	}

	private static int monthAvg(int[][] s, int m) {
		int total = 0;
		for (int i = 0; i < s.length; i++) {
			total = total + s[i][m];
		}
		
		return (total / 10);
	}
	
	private static void avgSales(int[][] s) {
		Stack<Integer> zones = new Stack<>();
		Stack<Integer> months = new Stack<>();
		
		for (int i = 0; i < 12; i++) {
			int monthAvg = monthAvg(s, i);
			//System.out.println(monthAvg);// Debug line
			for (int j = 0; j < s.length; j++) {
				//System.out.println(j);
				if (s[j][i] < monthAvg) {
					zones.push(j);
					months.push(i);
				}
			}
		}
		
		while (!zones.isEmpty()) {
			System.out.println(months(months.pop()) + " " + (zones.pop() + 1));
		}
		
	}

	private static void salesReport(int[][] s) {
		int[] sales = new int[10];
		int[] zones = new int[10];
		
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				sales[i] = sales[i] + s[i][j];
			}
			zones[i] = i;
		}
		
		for (int i = 0; i < sales.length; i++) {
			for (int j = i+1; j < sales.length; j++) {
				if (sales[i] < sales[j]) {
					int temp = sales[i];
					int temp1 = zones[i];
					sales[i] = sales[j];
					zones[i] = zones[j];
					sales[j] = temp; 
					zones[j] = temp1;
				}
			}
		}
		
		for (int i = 0; i < sales.length; i++) {
			System.out.println("Zone " + (zones[i] + 1) + ": " + sales[i]);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		minMaxSales(s);
		zoneTotal(8, s);
		betterSales(s);
		avgSales(s);
		salesReport(s);
	}

	
}
