package com.monsanto.mbt.Shipment;

import java.util.Comparator;

public class SortByColor implements Comparator<Widget> {

	public int compare(Widget o1, Widget o2) {
		return o1.getColor().compareTo(o2.getColor());
	}

}
