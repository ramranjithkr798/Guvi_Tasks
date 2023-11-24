import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

	public static void main(String[] args) {
		
		ArrayList<String> al=new ArrayList<String>(); //creating the Array List
		Scanner scan=new Scanner(System.in);
		int choice=0;
		boolean flage=true;
		while(flage) {
			System.out.println("Enter the option which need to perform in the Array List \n1. Add in list"
					+ "\n2. Delete in List \n3. Delete All element in the list \n4. Display the Array List \n"
					+ "5. To Conver the Array List to Array \n6. Exit from the Program");
			choice=scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter the String to add in a ArrayList");
				al.add(scan.nextLine()); //adding the data in the array list
				break;
			case 2:
				System.out.println(al);
				System.out.println("Enter the index of the element of Array list to be removed \nNote:index start's with 0");
				al.remove(scan.nextInt()); //removing a element based on index
				break;
			case 3:
				al.removeAll(al);// remove all the data in the array list
				System.out.println("All the data present in the ArrayList has deleted now...");
				break;
			case 4:
				System.out.println("Below are the data avaliable in the ArrayList");
				for(String s:al) { //accessing the array list by using for each
					System.out.println(s);
				}
				break;
			case 5:
				System.out.println("Below are the data of an array transfered from ArrayList:");
				Object st[]=al.toArray(); // converting the array list into to array of objects
				for(Object s:st) {
					System.out.println(s);
				}
				break;
			case 6:
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

}
