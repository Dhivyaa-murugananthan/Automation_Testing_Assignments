package collectionsPrograms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromArrayList {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();

        li.add(10);
        li.add(20);
        li.add(30);
        li.add(10);
        li.add(20);

        Set<Integer> set = new LinkedHashSet<>(li);

        li.clear();
        li.addAll(set);

        System.out.println("After remove the duplicate elements from the list is: "+li);
	}

}
