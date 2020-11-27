
public class Queue {
	/*IMPLEMENTAZIONE DELLA CODA USANDO LISTA DI NODI anzich� array*/
	/*DEFINIZIONE:La coda � un struttura dati che segue un sistema FIFO(FIRST IN FIRST OUT) in cui inserimento avviene in cima ed estrazione in testa .
		 L'implemetazione da noi studiata prevede un contenuto di tipo primitivo int degli elementi*/
	
	Node first;//puntatore al primo nodo della coda
	Node last;//puntatore ad ultimo nodo della coda
	
	public Queue() {//costruttore di una coda vuota
		first = null;
		last = null;
	}
	
	public void push(int x) {//inserimento di un elemento di contenuto x
		Node l = new Node(x, null);//si crea un nuovo nodo di contenuto x e successivo null
		if (first == null) {//se il primo posto della coda � vuoto
			first = l;      // il nodo da inserire va al primo posto
		}
		else {// se al primo posto della coda � gi� presente un nodo
			last.setNext(l);// si inserisce il nuovo nodo l come successivo dell'ultimo nodo(last) che si aveva prima dell'inserimento
		}
		last = l;//si aggiorna dicendo che dopo inserimento ultimo nodo della cosa coda(last) � il nodo appena inserito
	}
	/*COMPLESSIT� DEL METODO push(int x)
	 * O(1)=complessit� spaziale e temporale di un inserimento dovuto al fatto che si effettua una creazione di un nodo*/
	
	public int pop() {//METODO DI ESTRAZIONE DELLA TESTA DI UNA CODA(ovvero primo elemento inserito)
		if (first == null) {//caso in cui la coda � vuota
			System.out.print("\nErrore: Stack vuoto\n");
			return 0;//parametro da restiruire in caso di impossibilit� di effettuare estrazione essendo pop un metodo che restituisce un intero
		}
		int x = first.getInfo();//si salva la parte informativa del primo elemento in coda prima di effettuare eliminazione
		first = first.getNext();//il nuovo primo elemento � il nodo successivo alla testa che si aveva prima di effettuare eliminazione
		                        //con questa riga si effettua eliminazione della testa dalla cosa
		if (first == null)      //se il nuovo primo elemento � null
			last = null;        // allora anche ultimo elemento sar� null , di conseguenza la pila � vuota. 
		return x;                //restituisce il valore eliminato
	}
	/*COMPLESSIT� DEL METODO pop()
	 * O(1)=complessit� spaziale e temporale di una estrazione dovuto al fatto che si effettua una creazione di una variabile int x e un return di un intero*/

	public String toString() {
		String s = "[";
		if (first != null) 
			s += this.first.toString();
		s += "]";
		return s;
	}

}

private static void print(Node n) {//METODO PRIVATO 
	                   //si deve scandire la coda
	while (n != null) {//fino a quando non si giunge ad un nodo vuoto
		System.out.print(n.getInfo()+" ");// stampa contenuto informativo del nodo
		n = n.getNext();// si punta al nodo successivo
	}
	//usciti dal ciclo si avr� in stampa tutti i contenuti informativi dei nodi dell coda
	System.out.println();
}

public void print() {//METODO DI STAMPA DEI NODI DELLA LISTA
	print(first);//richiama il metodo PRIVATO DI STAMPA
}


