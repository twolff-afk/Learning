package sharedData;

import java.util.ArrayList;
import java.util.HashMap;

public class CounterList_NEW {
	
	private HashMap<Integer, ArrayList<Boolean>> list;
	
	public CounterList_NEW() {
		this.list = new HashMap<Integer, ArrayList<Boolean>>();
	}
	
	/**
	 * Checks whether the item is already on the list or not.
	 * If it exists than call method updateItem
	 * If not than create new ArrayList<Boolean> and add the entry
	 * 
	 * @param itemKey
	 */
	public synchronized void addItemToList(int itemKey) {
		
		if (checkItem(itemKey)) {
			
			updateItem(itemKey);
			
		} else {
			
			System.out.println("Add item to List");
			
			ArrayList<Boolean> waitingThreads = new ArrayList<Boolean>();
			waitingThreads.add(true);
			this.list.put(itemKey, waitingThreads);
			
		}
		
	}
	
	public synchronized void updateItem(int itemKey) {
		
		ArrayList<Boolean> itemList = list.get(itemKey);
		itemList.add(true);
		list.put(itemKey, itemList);
		
	}
	
	public synchronized boolean checkItem(int itemKey) {
		
		boolean result = false;
		
		if (list.containsKey(itemKey)) {
			result = true;
		}
		
		return result;
		
	}
}
