public class BullDog {
       String name;
       public static void main (String[] args) {

       	      BullDog dog1 = new BullDog();
	      dog1.bark();
	      dog1.name = "Bart";

	      BullDog[] myDogs = new BullDog[3];

	      myDogs[0] = new BullDog();
	      myDogs[1] = new BullDog();
	      myDogs[2] = dog1;

	      myDogs[0].name = "Fred";
	      myDogs[1].name = "Marge";

	      System.out.print("last dog's name is ");
	      System.out.println(myDogs[2].name);

	      int x = 0;
	      while(x < myDogs.length) {
		  myDogs[x].bark();
		      x = x + 1;
	       }
	}

		public void bark() {
		       System.out.println(name + " says Ruff!");
		}

		public void eat() { }
		public void chaseCat() { }
}
