import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		TreeMap<Integer, String> tm=new TreeMap<Integer, String>();
		int choice=0,id=0;
		boolean flage=true;
		while(flage) {
			System.out.println("Enter the option which need to perform in the Tree Map \n1. Add in data in Map"
					+ "\n2. Delete in data in Map \n3. Delete All element in the Map \n4. Display the Tree Map \n"
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
				//need to add the code for the display the based on the name (asseding order)
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

}//C:\Users\ramra\git\Guvi_Tasks\.git
