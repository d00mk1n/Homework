package homeworkFall2015;
import java.io.Serializable;

public class UseXerox {
	
	static class Thing implements Serializable {
		
	}
	
	static class AnotherThing {
		
	}
	public static void main(String[] args) {
		
		
		
		Xerox xerox = new Xerox();
		
		Thing thing = new Thing();
		AnotherThing anotherThing = new AnotherThing();
		
		String s = "Text";
		
		System.out.println(xerox.deepCopy(s));
		System.out.println(xerox.deepCopy(thing));
		System.out.println(xerox.deepCopy(anotherThing));
		
	}

}
