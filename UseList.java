package homeworkFall2015;

import java.util.Iterator;

public class UseList {
	
	public static void main(String[] args) {
		
		MyListIterators<String> list = new MyListIterators<String>() {
			{
			add("one");
			add("two");
			add("three");
			}
		};
		
		for (String item : list) {
			System.out.println(item);
		}
		
		Iterator<String> it0 = list.iterator();
		Iterator<String> it1 = list.new InnerIterator();
		Iterator<String> it2 = list.localIterator();
		
		
		while (it0.hasNext()) {
			String item = it0.next();
			System.out.println(item);
		}
		while (it1.hasNext()) {
			String item = it1.next();
			System.out.println(item);
		}
		while (it2.hasNext()) {
			String item = it2.next();
			System.out.println(item);
		}
		
//		Iterator<String> it3 = list.iterator();
//		System.out.println(it3.next());
//		System.out.println(it3.next());
//		
//		Iterator<String> it4 = list.iterator();
//
//		System.out.println(it3.next());
		
	}
	
}