package collectionsPrograms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HighestOccurringElement {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();

        li.add(10);
        li.add(20);
        li.add(10);
        li.add(30);
        li.add(20);
        li.add(10);
        System.out.println("The given Elements are: "+li);
        System.out.println();

        Map<Integer, Integer> mp = new LinkedHashMap<>();

        for (Integer x : li) 
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

        int maxFreq = 0;
        int maxElement = 0;

        for (Integer key : mp.keySet()) 
        {

            if (mp.get(key) > maxFreq) 
            {

            	maxFreq = mp.get(key);
            	maxElement = key;
            }
        }

        System.out.println("Highest Occurring Element : " + maxElement);
        System.out.println("Frequency : " + maxFreq);

	}

}
