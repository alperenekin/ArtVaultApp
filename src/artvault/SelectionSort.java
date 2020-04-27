package artvault;

import java.util.ArrayList;

public class SelectionSort {

	public void sort(ArrayList a,int numberused,int option) {//Sorts the given array
		int index,indexOfNextSmallest;
		for(index=0;index<numberused-1;index++) {
			indexOfNextSmallest=indexOfSmallest(index,a,numberused,option);
			interchanged(index,indexOfNextSmallest,a);
		}
	}

	private void interchanged(int i, int j, ArrayList  a) {//change 2 elements from list
		IComparable temp;
		temp=(IComparable) a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
	}

	private int indexOfSmallest(int startindex, ArrayList  a, int numberused,int option){//returns the index of minimum in the array list
			IComparable min=(IComparable) a.get(startindex);
			int indexOfmin=startindex;
			int index;
			for(index=startindex+1;index<numberused;index++) {
				if(((IComparable) a.get(index)).compareTo(min,option)<0) {//option string
					min=(IComparable) a.get(index);
					indexOfmin=index;
				}
			}
		return indexOfmin;
	}
}
