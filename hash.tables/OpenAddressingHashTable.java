
public class OpenAddressingHashTable {

	private OpenAddressingHashTableEntry[] table ;
	
	private int size;
	
	public OpenAddressingHashTable() {
		this.table = new OpenAddressingHashTableEntry[10];
		this.size = 0;
	}
	
	public void put(String key, String value) {
		int index = getIndex(key);
		
		if (this.table[index] == null) {
			this.table[index] = new OpenAddressingHashTableEntry(key, value);
			this.size++;
			
			if (this.size == this.table.length) {
				rehash();
			}
		} else {
			this.table[index].setValue(value);
		}
	}
	
	private void rehash() {
		OpenAddressingHashTableEntry[] oldTable = this.table;
		this.table = new OpenAddressingHashTableEntry[this.table.length * 2];
		
		for (OpenAddressingHashTableEntry entry : oldTable) {
			if (entry != null) {
				put(entry.getKey(), entry.getValue());
			}
		}
	}

	public String get(String key) {
		int index = getIndex(key);
		
		if (this.table[index] == null) {
			return null;
		}
		
		return this.table[index].getValue();
	}

	private int getIndex(String key) {
		int index = key.hashCode() % this.table.length;
		
		while (this.table[index] != null 
				&& this.table[index].getKey() != key) {
			if (index < this.table.length - 1) {
				index++;
			} else {
				index = 0;
			}
		}
		return index;
	}
	
	
	public void delete(String string) {
		
	}

	public static void main(String[] args) {
		OpenAddressingHashTable hashTable = new OpenAddressingHashTable();
		LinkedList linkedList = new LinkedList();
		
		int numElements = 1000000;
		
		long startAddList = System.currentTimeMillis();
		for (int i = 0; i < numElements; i++) {
			String string = String.valueOf(i);
			linkedList.add(string);
		}
		long endAddList = System.currentTimeMillis();
		System.out.println("Time adding in the list: " + (endAddList - startAddList));
		
		long startPutTable = System.currentTimeMillis();
		for (int i = 0; i < numElements; i++) {
			String string = String.valueOf(i);
			hashTable.put(string, string);
		}
		long endPutTable = System.currentTimeMillis();
		System.out.println("Time putting in the table: " + (endPutTable - startPutTable));
		
		System.out.println();
		
		long startSearchList = System.currentTimeMillis();
		for (int i = 0; i < numElements; i++) {
			String string = String.valueOf(i);
			linkedList.get(i);
//			System.out.print(linkedList.get(i) + ", ");
		}
		long endSearchList = System.currentTimeMillis();
		System.out.println("Time searching in the list: " + (endSearchList - startSearchList));
		
		long startSearchTable = System.currentTimeMillis();
		for (int i = 0; i < numElements; i++) {
			String string = String.valueOf(i);
			hashTable.get(string);
//			System.out.print(hashTable.get(string) + ", ");
		}
		long endSearchTable = System.currentTimeMillis();
		System.out.println("Time searching in the table: " + (endSearchTable - startSearchTable));
	}
	
}
