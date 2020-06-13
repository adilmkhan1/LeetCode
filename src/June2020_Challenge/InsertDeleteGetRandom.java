package June2020_Challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRandom {
	
	//Insert , Delete , GetRandom in O(1) time
	
	 HashMap<Integer,Integer> map;
	 List<Integer> list;
	 Random rd;
	
	 
	 public InsertDeleteGetRandom()
	 {
		 map = new HashMap<>();
		 list = new ArrayList<>();
		 rd = new Random();
	 }
	 
	 public boolean insert(int val)
	 {
		 if(!map.containsKey(val))
		 {
			 list.add(val);
			 map.put(val, list.size()-1);
			 return true;
		 }
		 
		 return false;
		
	 }
	 
	 public boolean remove(int val)
	 {
		 if(map.containsKey(val))
		 {
			 int index = map.get(val);

			 //int lastElement = list.get(list.size()-1);
			 //swap last element value with this removed value
			 //Collections.swap(list, index, list.size()-1);
			 
			 list.set(index,list.get(list.size()-1));
			 
			 map.put(list.get(index), index);
			 
			 //then remove last element
			 list.remove(list.size()-1);
			 //also update value in map
			 //map.put(lastElement, index);
			 map.remove(val);
			 return true;
		 }
		 
		 return false;
	 }
	 
	 public int getRandom()
	 {
		 int range = map.size();
		 //return list.get((int)(Math.random() * list.size()));
		 return list.get(rd.nextInt(range));
	 }
	 
	 public void printCollection()
	 {
		 System.out.println(map);
		 System.out.println(list.toString());
	 }
	 
	 
	

	public static void main(String[] args) {
		
		InsertDeleteGetRandom randomSet = new InsertDeleteGetRandom();
		
		System.out.println(randomSet.insert(5));
		System.out.println(randomSet.insert(2));
		
		System.out.println(randomSet.getRandom());
		
		System.out.println(randomSet.insert(3));
		System.out.println(randomSet.insert(1));
		System.out.println(randomSet.insert(3));
		
		randomSet.printCollection();
		
		System.out.println(randomSet.remove(6));
		System.out.println(randomSet.remove(3));
		
		System.out.println(randomSet.getRandom());
		
		randomSet.printCollection();
		
		
		
		

	}

}
