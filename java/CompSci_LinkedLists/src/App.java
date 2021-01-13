
import java.io.*;
import java.util.LinkedList;

public class App {
	
	public LinkedList<String> loadData(File file) {
		
		LinkedList<String> list = new LinkedList<>();
		
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);){
			String line;
			
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void print(LinkedList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public LinkedList<String> search(String term, LinkedList<String> list) {
		LinkedList<String> results = new LinkedList<>();
		
		for (String string : list) {
			if (string.contains(term)) {
				results.add(string);
			}
		}
		
		return results;
		
	}
	
	public App()  {
		File file = new File("data.txt");
		
		LinkedList<String> list = loadData(file);
		
		print(list);
		System.out.println();
		
		LinkedList<String> list2 = search("data1", list);
		print(list2);
		
		
	}
	
	public static void main(String[] args) {
		new App();
	}
	
}
