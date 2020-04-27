package artvault;
import java.util.Scanner;

public class Menuapp {
	public static void main(String[] args) {
		Vault vault=new Vault();
		Scanner in=new Scanner(System.in);
		String input="-1";
		while(!input.equals("0")){
			System.out.println("Please enter the number of the operation you want to perform");
			System.out.println("1) Print the lists \n2) Search the vault \n3) Trade \n0) Exit");
			input = in.nextLine();
			if(input.equals("1")) {
				System.out.println("Please choose the list:");
				System.out.println("1) Print the list of artists");
				System.out.println("2) Print the list of architects");
				System.out.println("3) Print the list of paintings");
				System.out.println("4) Print the list of sculptures");
				System.out.println("5) Print the list of architectures");
				System.out.println("0) Exit");
				input=in.nextLine();
				if(input.equals("1")) {
					System.out.println("Please choose the sorting method");
					System.out.println("1) Sort by name");
					System.out.println("2) Sort by birthday");
					System.out.println("3) Sort by nationality");
					input=in.nextLine();
					if(input.equals("1")) {
						vault.sortArtists(1); //sort by name
					}
					else if(input.equals("2")) { // first sort default then by artist birthday
						vault.defaultSort();
						vault.sortArtists(2);
					}
					else if(input.equals("3")) {//first sort defalt then by artist nationality
						vault.defaultSort();
						vault.sortArtists(3);
					}
					else if(input.equals("0")) {
						break;
					}
				}
				else if(input.equals("2")) {
					System.out.println("Please choose the sorting method");
					System.out.println("1) Sort by name");
					System.out.println("2) Sort by birthday");
					System.out.println("3) Sort by naionality");
					System.out.println("0) Exit");
					input=in.nextLine();
					if(input.equals("1")) { //Sort architects by name
						vault.sortArchitects(1);
					}
					else if(input.equals("2")) {//first sort them by default then sort by architect birthday
						vault.defaultSort();
						vault.sortArchitects(2);
					}
					else if(input.equals("3")) {//first sort them by default then sort by architect 
						vault.defaultSort();
						vault.sortArchitects(3);
					}
					else if(input.equals("0")) {
						break;
					}
				}
				else if(input.equals("3")) {
					System.out.println("Please choose the sorting method");
					System.out.println("1) Sort by name");
					System.out.println("2) Sort by style");
					System.out.println("3) Sort by artist");
					System.out.println("0) Exit");
					input=in.nextLine();
					if(input.equals("1")) { //sort paintings by name
						vault.sortPaintings(1);	
					}
					else if(input.equals("2")) {//first sort default then sort by paintings style
						vault.defaultSort();
						vault.sortPaintings(2);		
					}
					else if(input.equals("3")) {//first sort default then sort by artist of paintings
						vault.defaultSort();
						vault.sortPaintings(3);		
					}
					else if(input.equals("0")) {
						break;
					}
				}
				else if(input.equals("4")) {
					System.out.println("Please choose the sorting method");
					System.out.println("1) Sort by name");
					System.out.println("2) Sort by style");
					System.out.println("3) Sort by artist");
					System.out.println("4) Sort by material");
					System.out.println("0) Exit");
					input=in.nextLine();
					if(input.equals("1")) { //Sort sculptures by name
						vault.sortSculptures(1);
					}
					else if(input.equals("2")) {//First sort sculptures default then sort by sculpture style
						vault.defaultSort();
						vault.sortSculptures(2);
					}
					else if(input.equals("3")) {//First sort sculptures default then sort by sculpture artist
						vault.defaultSort();
						vault.sortSculptures(3);
					}
					else if(input.equals("4")) {//First sort sculptures default then sort by sculpture material
						vault.defaultSort();
						vault.sortSculptures(4);
					}
					else if(input.equals("0")) {
						break;
					}
				}
				else if(input.equals("5")) {
					System.out.println("Please choose the sorting method");
					System.out.println("1) Sort by name");
					System.out.println("2) Sort by style");
					System.out.println("0) Exit");
					input=in.nextLine();
					if(input.equals("1")) { //Sort by name
						vault.sortArchitectures(1);
					}
					else if(input.equals("2")) { //First sort default then sort architectures by style
						vault.defaultSort();
						vault.sortArchitectures(2);
					}
					
					else if(input.equals("0")) {
						break;
					}
				}
			}
			else if(input.equals("2")) {
				System.out.println("Enter the keyword");
				input=in.nextLine();
				vault.defaultSort(); //first sort them
				vault.searchKeyword(input); //then find keyword in artworks
			}
			else if(input.equals("3")) {
				Trade trade=new Trade();
				trade.startTrade(); // start strade process
			}
		}
	}
}
