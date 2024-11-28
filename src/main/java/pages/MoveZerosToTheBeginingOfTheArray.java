package pages;

import java.util.Arrays;

public class MoveZerosToTheBeginingOfTheArray {

	public static void main(String[] args) {
		/*TODO Auto-generated method stu  {4,5,6,-8,0,-6,7,-3,0,9,-5}, 
	    Output: {0,0,4,5,6,-8,-6,7,-3,9,-5} */
		
		int no[]={4,5,6,-8,0,-6,7,-3,0,9,-5};
		
		int temp[]=new int[no.length];
		int index=0;
		
		for (int i = 0; i < no.length; i++) {
			if(no[i]==0) {
				temp[index]=no[i];
				index++;
			}
		}
		for (int i = 0; i < no.length; i++) {
			if(no[i]!=0) {
				temp[index]=no[i];
				index++;
			}
		}
		System.out.println(Arrays.toString(temp));

	}

}
