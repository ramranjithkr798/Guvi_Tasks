import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		TreeMap<Integer, String> tm=new TreeMap<Integer, String>();
		int choice=0,id=0;
		boolean flage=true;
		while(flage) {
			System.out.println("Enter the option which need to perform in the Tree Map \n1. Add in data in Map"
					+ "\n2. Delete in data in Map \n3. Delete All element in the Map \n4. Display the data in Tree Map as a sorted manner\n"
					+ "5. Exit from the Program");
			choice=scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter the Employee name:");
				tm.put(id++, scan.nextLine());
				break;
			case 2:
				System.out.println(tm);
				System.out.println("Enter the id to delete employee record");
				tm.remove(scan.nextInt());
				break;
			case 3:
				System.out.println("All the data has removed from the from the Map");
				tm.clear();
				break;
			case 4:
				Map sortedMap = valueSort(tm);
				 Set set = sortedMap.entrySet(); 
				  
			        // Get an iterator 
			        Iterator i = set.iterator(); 
			  
			        while (i.hasNext()) 
			        { 
			            Map.Entry mp = (Map.Entry)i.next(); 
			  
			            System.out.print(mp.getKey() + ": "); 
			  
			            System.out.println(mp.getValue()); 
			        } 
				break;
			case 5:
				System.out.println("Thanks you ...!!!");
				flage=false;
				scan.close();
				break;
			default:
				System.out.println("Please enter the correct option to perfrom the operation...");
				break;
			}
		}
	}
	
	public static <K, V extends Comparable<V> > Map<K, V> 
    valueSort(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() 
        { 
              
            public int compare(K k1, K k2) 
            { 
  
                int comp = map.get(k1).compareTo(map.get(k2)); 
  
                if (comp == 0) 
                     return 1; 
  
                else
                     return comp; 
            } 
        }; 
  
        // SortedMap created using the comparator 
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator); 
  
        sorted.putAll(map); 
  
        return sorted; 
	} 

}//C:\Users\ramra\git\Guvi_Tasks\.git
