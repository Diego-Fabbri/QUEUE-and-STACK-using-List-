
public class UsaLista {

	public static void main(String[] args){
		
		Lista L1 = new Lista();	
		L1.insertI(3);
		System.out.println(L1);// tale scrittura è valida poichè si è definito metodo toString
		L1.insertR(1);
		System.out.println(L1);
		L1.insertI(6);
		System.out.println(L1);
		L1.insertR(4);
		System.out.println(L1);
		L1.insertI(2);
		System.out.println(L1);
		
		System.out.println(4 + " " + L1.deleteI(4));
		System.out.println(L1);
		System.out.println(1 + " " + L1.deleteR(1));
		System.out.println(L1);
		System.out.println(4 + " " + L1.deleteI(4));
		System.out.println(L1);
		System.out.println(5 + " " + L1.deleteR(5));
		System.out.println(L1);
		
		/*
		Stack L1 = new Stack();
		System.out.println(L1);
		L1.push(1);
		System.out.println(L1);
		L1.push(2);
		System.out.println(L1);
		L1.push(3);
		System.out.println(L1);
		L1.push(4);
		System.out.println(L1);
		L1.push(5);
		System.out.println(L1);
		System.out.println("deleted " + L1.pop());		
		System.out.println(L1);
		System.out.println("deleted " + L1.pop());		
		System.out.println(L1);
		System.out.println("deleted " + L1.pop());		
		System.out.println(L1);
		System.out.println("deleted " + L1.pop());		
		System.out.println(L1);
		System.out.println("deleted " + L1.pop());		
		System.out.println(L1);
		System.out.println("deleted " + L1.pop());	
		System.out.println(L1);
		L1.push(1);
		System.out.println(L1);
		*/
	}
}
