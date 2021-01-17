import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
	
	private Scanner sc = new Scanner(System.in);
	
	public LinkedList readStringsFile() {
		
		System.out.println("Please Input a file name containing data to be read: ");
		String file = sc.nextLine();
		
		LinkedList<String> list = new LinkedList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + file);
			System.out.println("Please try again!");
			readStringsFile();
		} catch (IOException e) {
			System.out.println("Error reading file: " + file);
			System.out.println("Please try again!");
			readStringsFile();
		}
		
		return list;
	}
	
	
	
	public App() {
		
		LinkedList<String> stringList = new LinkedList<String>();
		stringList.add("It Worked!");
		System.out.println(stringList.get(0));
		
		LinkedList<Integer> intList = new LinkedList<Integer>();
		intList.add(0);
		intList.add(1);
		intList.add(2);
		intList.add(3);
		
		for (int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}
		
		intList.insert(111, 4);
		
		System.out.println();
		for (Integer integer : intList) {
			System.out.println(integer);
		}
		
		LinkedList<String> list1 = readStringsFile();
		
		for (String string : list1) {
			System.out.println(string);
		}
		
		
	}
	
	public static void main(String[] args) {
		new App();
	}
}
