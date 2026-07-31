package collectionsPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOfElements {

	public static void main(String[] args) {
		List<String> li = new ArrayList<>();

        li.add("Apple");
        li.add("Banana");
        li.add("Apple");
        li.add("Orange");
        li.add("Banana");
        li.add("Apple");
        System.out.println("The list of the given elements: "+li);

        Map<String, Integer> mp = new HashMap<>();

        for (String x : li)
        {

            if (mp.containsKey(x))
            {

                mp.put(x, mp.get(x) + 1);

            } 
            else 
            {

                mp.put(x, 1);
            }
        }

        System.out.println("Frequency of Elements :");

        for (String key : mp.keySet()) 
        {

            System.out.println(key + " = " + mp.get(key));
        }

	}

}
