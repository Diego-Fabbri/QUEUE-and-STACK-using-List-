
public class Stack {
	/*IMPLEMENTAZIONE DELLA PILA USANDO LISTA DI NODI anzichè array*/
	/*DEFINIZIONE:La pila è un struttura dati che segue un sistema LIFO(LAST IN FIRST OUT) in cui inserimento ed estrazione avvengo in cima .
	 L'implemetazione da noi studiata prevede un contenuto di tipo primitivo int degli elementi*/

	public Stack() {//costruttore
		head = null;//inizialmente la pila è vuota
	}
	
	public void push(int x) {//METODO DI INSERIMENTO DI UN NODO DI CONTENUTO X IN CIMA ALLA PILA
		Node l = new Node(x, head);//crea un nuovo nodo di contenuto x inserendo in testa e passandogli come successivo la vecchia testa prima dell'inserimento
		head = l;                 //aggiorna dicendo che la nuova testa è il nodo l appena inserito
	}
	/*COMPLESSITà DEL METODO push(int x)
	 * O(1)=complessità spaziale e temporale di un inserimento dovuto al fatto che si effettua una creazione di un nodo*/
	
	public int pop() {//METODO DI ESTRAZIONE DI UN NODO DALLA CIMA DELLA PILA(ovvero ultimo elemento inserito)
		
		if (head == null) {//se la testa è vuota ,estrazione non possibile
			System.out.println("\nErrore: Stack vuoto\n");
			return 0;
			// System.exit(-1);
		}
		//altrimenti se la testa non è vuota
		int x = head.getInfo();//si salva contenuto informativo della testa
		head = head.getNext();// il nuovo primo elemento è il successivo del vecchio primo elemento(ovvero la testa che si aveva prima dell'estrazione)
		                      //con questa modifica del primo elemento si effettua estrazione
		return x;              //restituisce contenuto informativo eliminato dalla testa
		/*GESTIONE ECCEZIONI
		try {
			int x = head.getInfo();
			head = head.getNext();
			return x;			
		}
        catch(ArithmeticException e)
        {
            System.out.println("Empty stack");
            System.exit(-1);
        }
        */
	}
	/*COMPLESSITà DEL METODO pop()
	 * O(1)=complessità spaziale e temporale di una estrazione dovuto al fatto che si effettua una creazione di una variabile int x e un return di un intero*/
	
	public String toString() {
		String s = "[";
		if (head != null) 
			s += this.head.toString();
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
	//usciti dal ciclo si avrà in stampa tutti i contenuti informativi dei nodi dell coda
	System.out.println();
}

public void print() {//METODO DI STAMPA DEI NODI DELLA LISTA
	print(head);//richiama il metodo PRIVATO DI STAMPA
}

