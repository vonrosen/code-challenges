package org.hunter;

public class Tester{

	public static void main(String [] args){
		C c = new C();
		c.doit(new A());
		c.doit(new B());

		A x = new B();

		c.doit(x);
	}

	static class A{

	}

	static class B extends A{

	}

	static class C {
		void doit(A a){
			System.out.println("a");
		}

		void doit(B b){
			System.out.println("b");
		}
	}

}
