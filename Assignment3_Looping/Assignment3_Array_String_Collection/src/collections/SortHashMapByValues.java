package collectionsPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortHashMapByValues {

	public static void main(String[] args) {
		Map<Integer, String> mp = new LinkedHashMap<>();

        mp.put(3, "Orange");
        mp.put(1, "Apple");
        mp.put(4, "Mango");
        mp.put(2, "Banana");

        System.out.println("Before sorting : " + mp);

        List<String> li = new ArrayList<>(mp.values());

        Collections.sort(li);

        System.out.println("After Sorting by Values :");

        for (String value : li) 
        {

            for (Map.Entry<Integer, String> x : mp.entrySet()) 
            {

                if (x.getValue().equals(value))
                {

                    System.out.println(x.getKey() + " = " + x.getValue());
                }
            }
        }

	}

}
