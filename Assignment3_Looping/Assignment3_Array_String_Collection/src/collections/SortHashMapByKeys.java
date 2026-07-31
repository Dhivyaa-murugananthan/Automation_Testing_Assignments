package collectionsPrograms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortHashMapByKeys {

	public static void main(String[] args) {
		 Map<Integer, String> map = new LinkedHashMap<>();

	        map.put(3, "Orange");
	        map.put(1, "Apple");
	        map.put(4, "Mango");
	        map.put(2, "Banana");

	        System.out.println("Before Sorting : " + map);

	        Map<Integer, String> sortedMap = new TreeMap<>(map);

	        System.out.println("After Sorting by Keys : " + sortedMap);

	}

}
