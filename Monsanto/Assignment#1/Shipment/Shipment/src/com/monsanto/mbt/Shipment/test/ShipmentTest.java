package com.monsanto.mbt.Shipment.test;


import java.util.ArrayList;

import org.junit.Test;

import com.monsanto.mbt.Shipment.Shipment;
import com.monsanto.mbt.Shipment.Widget;
import com.monsanto.mbt.Shipment.WidgetUtils;

import junit.framework.TestCase;


public class ShipmentTest extends TestCase {

	ArrayList<Widget> arr = new ArrayList<Widget>();
	
	@Test
	public void testShipment_Sorted_By_Date() {
		arr.addAll(WidgetUtils.getSampleWidgets());
		ArrayList<Widget> arrResult = Shipment.sortByCreationDateResult(arr, 10);
		assertTrue(WidgetUtils.stringToDateConverter("09-01-2005").equals(arrResult.get(0).getProductionDate()));
	}

	@Test
	public void testShipment_Sorted_By_Color() {
		arr.addAll(WidgetUtils.getSampleWidgets());
		ArrayList<Widget> arrResult = Shipment.sortByColorResult(arr, 10);
		assertTrue("Blue".equals(arrResult.get(0).getColor()));

	}

}
