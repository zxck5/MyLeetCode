package leetCode;

public class Person {
	
	Baby first = new Baby("First baby");
	
	
	class Baby {
		String name;
		Baby next;
		
		Baby(String a) {
			name = a;
		}
	}
	
	void makeBaby(String name) {
//		if (first == null) {
//			first = new Baby(name);
//		} else {
			Baby testBaby = first;
			System.out.println(testBaby.name = "Hello baby");
			System.out.println("first name: " + first.name);
			System.out.println(testBaby);
			System.out.println(first);
			while (testBaby.next != null) {
				testBaby = testBaby.next;
			}
			testBaby = null;
			testBaby = new Baby("New born baby");
			System.out.println("f="+first);
			System.out.println(testBaby);
			
			
			
//		}

	}
	
	public static void main(String[] args) {
		Person p = new Person();
		p.makeBaby("Jiwon");
	}
}
