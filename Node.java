
public class Node {
	/*DEFINIZONE: è una struttura dati a due componenti : una parte informativa di qualsiasi tipo (nek nostro caso saranno sempre interi), e un puntatore ad un
	 * nodo successivo*/
	private int info;//parte informativa
	private Node next;//collegamento a nodo successivo
	
	public Node(int info) {//costruttore che prende solo parte informativa
		this.info = info;
		this.next = null;
	}
	
	public Node(int info, Node next) {//costruttore che prende parte informativa e nodo successivo
		this.info = info;
		this.next = next;
	}
	//essendo i campi del nodo privati si definiscono dei meodi che permettono di visualizzare tali contenuti
	public int getInfo() { return info; }
	
	public Node getNext() { return next; }

	public void setInfo(int info) { //permette di modificare la parte informativa di un nodo
		this.info = info;
	}

	public void setNext(Node next) { //permette di modificare il nodo successivo di un nodo
		this.next = next;
	}
	
	public String toString() {
		String s = "" + this.info;
		if (this.next == null)
			return s;
		else
			return  s + "," + this.getNext().toString();
	}

}
