package com.monsanto.mbt.Shipment;

import java.util.ArrayList;
import java.util.Collections;

public class Shipment {

	/**
	 * @param arg
	 */
	public static void main(String arg[]){
		ArrayList<Widget> arr = new ArrayList<Widget>();
		arr.addAll( WidgetUtils.getSampleWidgets());
		int limit = 0;
		if(arr.size()>=10){
			limit = 10;
		}else {
			limit =arr.size();
		}
		sortByCreationDateResult(arr,limit);
		sortByColorResult(arr, limit);
	}
	
	/**
	 * @param arr
	 * @param limit
	 * @return
	 */
	public static ArrayList<Widget> sortByCreationDateResult(ArrayList<Widget> arr, int limit){
		Collections.sort(arr,new SortByCreation());
        System.out.println("\nSorted by Creation Date");
        for (int i=0; i<limit; i++)
            System.out.println(Shipment.toString(arr,i));
        return arr;
	}
	
	/**
	 * @param arr
	 * @param limit
	 * @return
	 */
	public static ArrayList<Widget> sortByColorResult(ArrayList<Widget> arr, int limit){
		 Collections.sort(arr,new SortByColor());
	     System.out.println("\nSorted by Color");
	     for (int i=0; i<limit; i++)
	    	 System.out.println(Shipment.toString(arr, i));
	     return arr;

	}
	
	/**
	 * @param arr
	 * @param i
	 * @return
	 */
	public static String toString(ArrayList<Widget> arr, int i){
		return "Serial Number : "+arr.get(i).getSerialNumber()
				+"\tColor :"+arr.get(i).getColor()
				+"\tProduction Date :"+arr.get(i).getProductionDate();
	}
	
	
}
