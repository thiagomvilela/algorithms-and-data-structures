import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class OpenAddressingHashTableEntry {

	private String key;
	private String value;
	
	public OpenAddressingHashTableEntry(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static void main(String[] args) {
//		long somatorio = 0;
//		for (int i = 1; i <= 1000000; i++) {
//			somatorio += i;
//		}
//		System.out.println(somatorio);
		
		Map<String, String> hashMap = new HashMap<String, String>();
		List<String> arrayList = new ArrayList<String>();
		
		int numElements = 1000000;
		
		long startAddList = System.currentTimeMillis();
		for (int i = 0; i < numElements; i++) {
			String string = String.valueOf(i);
			arrayList.add(string);
		}
		long endAddList = System.currentTimeMillis();
		System.out.println("Time adding in the list (Java API): " + (endAddList - startAddList));
		
		long startPutTable = System.currentTimeMillis();
		for (int i = 0; i < numElements; i++) {
			String string = String.valueOf(i);
			hashMap.put(string, string);
		}
		long endPutTable = System.currentTimeMillis();
		System.out.println("Time putting in the table (Java API): " + (endPutTable - startPutTable));
		
		System.out.println();
		
		long startSearchList = System.currentTimeMillis();
		for (int i = 0; i < numElements; i++) {
			String string = String.valueOf(i);
			arrayList.get(i);
		}
		long endSearchList = System.currentTimeMillis();
		System.out.println("Time searching in the list (Java API): " + (endSearchList - startSearchList));
		
		long startSearchTable = System.currentTimeMillis();
		for (int i = 0; i < numElements; i++) {
			String string = String.valueOf(i);
			hashMap.get(string);
		}
		long endSearchTable = System.currentTimeMillis();
		System.out.println("Time searching in the table (Java API): " + (endSearchTable - startSearchTable));
	}
	
}
