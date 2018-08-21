package com.monsanto.mbt.Shipment;

import java.util.Comparator;

public class SortByCreation implements Comparator<Widget> {

	public int compare(Widget o1, Widget o2) {
		if(o1.getProductionDate().before(o2.getProductionDate())){
			return -1;
		}else if(o1.getProductionDate().after(o2.getProductionDate())){
			return 1;
		}else{
			return 0;
		}
	}

}
