
public class Lista {
	/*DEFINIZIONE DI UNA LISTA:è una struttura dati formata da una sequenza di nodi.Ogni nodo è costituito da un campo che contine una parte informativa di tipo primitivo(come nei casi che studieremo)
	 * o tipo orientato agli oggetti e un campo che contiene un riferimento ad un nodo successivo.
	 * Tale struttura dati , di contenuto informativo con intero, è organizzata in modo che I SUOI ELEMENTI SIANO DISPOSTI IN MANIERA CRESCENTE.
	 * n= dimensione della lista
	   */
	
	Node head;
	
	public Lista() {//costruttore
		head = null;
	}
		
	public void insertI(int x) {//METODO ITERATIVO DI INSERIMENTO DI UN NODO DI CONTENUTO X
		if (head == null || head.getInfo() >= x) //se la lista è vuota o il contenuto della testa è maggiore del contenuto , si fa inserimento in testa della lista
			// Inserimento in testa
			head = new Node(x,head);//si crea nuova testa di contenuto x e collegamento al nodo successivo alle vecchia testa prima dell'inserimento
		else {
			// Inserimento in coda
			Node p = head;// nodo precedente , è un puntatore che parte dalla testa
			Node c = head.getNext();//nodo corrente , è un puntatore che punta al nodo succesivo di p
			while (c != null && c.getInfo() < x) {//fino a quando il contenuto del nodo corrente è minore del contenuto da inserire
				p = c;         //i due puntatori si spostano verso destra scorrendo la lista
				c = c.getNext();
			}
			//usciti dal ciclo si è trovata la posizione in cui inserire in nuovo nodo di contenuto informativo x, che è nel mezzo tra i puntatori p e c
			p.setNext(new Node(x,c)); // si imposta il successivo del puntatore p , il nodo di contenuto x , e come suo successivo il nodo puntato da c 
			                          // così facendo si effettua inserimento
		}
	}
	
	/*COMPLESSITA' DEL METODO insertI(int x)
	 * O(1)= complessità spaziale del caso peggiore e migliore , poichè si crea solo un nodo
	 * O(n)= complessità temporale del caso peggiore poichè si deve effettuare una scansione su tutta la lista per effettuare inserimento
	 * O(1)=complessità temporale del caso migliore , si effettua inserimento in testa poichè lista è vuota o contenuto della testa è maggiore del contenuto da inserire 
	 * */
	
	private static void insertR(Node p, int x) {// NB: METODO RICORSIVO PRIVATO
		if (p.getNext() != null && p.getNext().getInfo() < x) //se in nodo ha successivo con parte informativa minore del contenuto x da inserire
			insertR(p.getNext(),x);//si richiama ricorsivamente la funzione PRIVATA puntando al nodo successivo, si scandisce la lista
		else {//CASO BASE: avviene inserimento
			p.setNext(new Node(x,p.getNext()));//si imposta al nodo successivo di p un nuovo nodo ,di contenuto x e nodo successivo il nodo che era il successivo di p prima dell'inserimento
		}
	}
	
	public void insertR(int x) {//METODO RICORSIVO DI INSERIMENTO DI UN NODO DI CONTENUTO X
		if (head == null || head.getInfo() >= x)//se la pila è vuota o la parte informativa della testa ha contenuto maggiore del contenuto x da inserire
			// Inserimento in testa
			head = new Node(x,head);// la nuova testa avrà contenuto x e tale nodo punterà alla vecchia testa 
		else// inserimento va fatto all'interno della lista
			// Inserimento in coda
			insertR(head,x);// il metodo chiama un metodo di inserimento PRIVATO ricorsivo che prende in input i parametri del nodo testa e il contenuto x da inserire
	}
	/*COMPLESSITA DEL METODO insertR
	 * O(n)= complessità temporale del caso peggiore, si deve scandire tutta la lista
	 * O(n)=complessità spaziale del caso peggiore , dovedo scandire tutta la lista, il metodo primato search effettuerà n chiamate a se stessa(ricorsioni) 
	 * aprendo altrettanti record di attivazione in memoria*/
	
	public boolean searchI(int x) { //METODO ITERATIVO DI RICERCA DI UN NODO DI CONTENUTO X
		Node p = head;//è un puntatore serve a scandire la lista
		while (p != null && p.getInfo() <= x) {//fino a quando tali condizioni sono verificate ,ovvero che p punta ad un nodo non null il cui contenuto è minore o uguale del contenuto da inserire
			p=p.getNext();                     //si scandisce la lista facendo avanzare il puntatore
		          }
			//usciti dal ciclo ci sono due possibilità
		if (p.getInfo() == x && p!=null)
			//il puntatore trova elemento o punta a null , quindi elemento non c'è
				return true;
		else// elemento non trovato
			return false;
	}
	/*COMPLESSITA' DEL METODO serchI(int x)
	 * O(1)= complessità spaziale del caso peggiore e migliore , poichè si restituisce un booleano
	 * O(n)= complessità temporale del caso peggiore poichè si deve effettuare una scansione su tutta la lista per effettuare verifica
	 * O(1)=complessità temporale del caso migliore , si effettua verifica in testa poichè lista è vuota o contenuto della testa è maggiore del contenuto da inserire (elemento non presente)
	 * */
	
	
	
	private boolean searchR(Node p, int x) {// NB: METODO RICORSIVO PRIVATO
		//CASI BASE
	/*caso 1*/if (p == null || p.getInfo() > x)//se il nodo su cui si cerca è null o ha contenuto informativo maggiore del contenuto ricercato
			             return false;                // elemento non presente 
    /*caso 2*/if (p.getInfo() == x)             // se parte informativa del nodo su cui si cerca coincide con ciò che si cerca
			             return true;                  // elemento trovato
		
              else {return searchR(p.getNext(),x); }   //se nessuna delle due base è verificata , si richiama ricorsivamente la funzione a se stessa per ricondursi ad uno dei due casi base 
                                                      // scandendo la lista
	}
	
	public boolean searchR(int x) {//METODO RICORSIVO DI RICERCA DI UN NODO DI CONTENUTO X 
		return searchR(head,x);// il metodo chiama un metodo di ricerca PRIVATO ricorsivo che prende in input i parametri del nodo testa e il contenuto x da ricercare
	}
	
	/*COMPLESSITA' DEL METODO searchR
	 * O(n)= complessità temporale del caso peggiore in cui si avranno n ricorsioni se si deve scandire tutta la lista
	 * O(n)=complessità spaziale del caso peggiore , dovendo scandire tutta la lista  si avranno n-1 ricorsioni del metodo privato, che dovrà scandire la lista dalla testa in poi
	 * (quindi m+1 record di attivazione) e 1 allocazione di memoria dovuta allo spazio di search pubblico=O(1)+O(n-1)
	 */
	
	
	public boolean deleteI(int x) {//METODO ITERATIVO DI ELIMINAZIONE DI UN NODO DI CONTENUTO X
		if (head == null)// se la lista è vuota (il nodo testa punta a null
			return false;
		if (head != null && head.getInfo() == x) {// se la lista non è vuota e la parte informativa della testa è proprio uguale al contenuto da eliminare
			head = head.getNext();//la nuova testa diventa il nodo successivo alla testa iniziale (quella prima di effettuare eliminazione)
			                     // modificando il puntatore head, si elimina il nodo in testa
			return true;
		}
		//altrimenti , se il nodo da eliminare è contenuto nella lista , si adoperano due puntatori ai nodi p e c , che partono entrambi dalla testa
		//questi serviranno a scandire la lista e trovare la posizione del nodo da eliminare (nel caso ci sia)
		//
		Node c = head;//NB: procedendo con la scansione della lista il puntatore c , punta sempre al nodo successivo puntato dal puntatore p
		Node p = head;
		while (c != null && c.getInfo() < x) {//fino a quando il puntatore c punta ad un nodo non null il cui contenuto è minore del contenuto da eliminare
			                                  //i due puntatori si spostano verso destra per scorrere la lista
			p = c;
			c = c.getNext();
		}
		//usciti dal ciclo il nodo c punta o al nodo di contenuto ricercato o oppure no. Nel secondo caso si conlude che elemento x non è eliminabile 
		if (c != null && c.getInfo() == x) {// se c punta al nodo di contenuto da eliminare
			p.setNext(c.getNext());// il nodo successivo di p , diventa il nodo successivo puntato da c . Così facendo il nodo puntato da c viene eliminato dalla struttura dati
			return true;
		}
		return false; // caso in cui eliminazione non può avvenire poichè tale contenuto x non è presente nella lista 
	}
	
	/*COMPLESSITA' DEL METODO deleteI
	 * O(1)=complessità spaziale del caso migliore e peggiore non vengo fatte operazioni di new
	 * O(n)=complessità temporale del caso peggiore poichè si è costretti a scandire tutta la lista per effettuare eliminazione
	 * O(1)=complessità temporale del caso migliore, ovvero quando la lista è vuota o il contenuto da eliminare è in testa . 
	 * */

	private static boolean deleteR(Node p, int x) {//NB: METODO RICORSIVO PRIVATO
		/*caso base 1*/if (p.getNext() == null || p.getNext().getInfo() > x)//se il nodo puntato p è null o il contento informativo del suo successivo è maggiore del contenuto x da eliminare
			              return false; // il contenuto x non è presente nella lista essendo questa ordinata in modo crescente, non avviene alcuna eliminazione
		/*caso base 2*/if (p.getNext().getInfo() == x) {//se la parte informativa del nodo successivo puntato da p è pari al contenuto da eliminare, si effettua eliminazione
			              p.setNext(p.getNext().getNext());//il nuovo successivo del nodo p diventa il successivo del successivo del nodo p .
			                return true;
		}
		return deleteR(p.getNext(),x);//la funzione richima se stessa ricorsivamente passando in imput il nodo successivo di p
	}

	public boolean deleteR(int x) {//METODO RICORSIVO DI ELIMINAZIONE DI UN NODO DI CONTENUTO X
		/*caso base 1*/if (head == null || head.getInfo() > x)//se la lista è vuota o il contenuto della testa è maggiore del contenuto da eliminare
			               return false;// eliminazione non avviene , elemento x non presente nella lista essendo quest'ultima ordinata in modo crescente
		/*caso base 2*/if (head.getInfo() == x) {//se il contenuto da eliminare si trova in testa avviene eliminazione
			              head = head.getNext();// la nuova testa sarà il nodo successivo alla testa che si aveva prima di effettuare eliminazione
			                return true;
		}
		//caso in cui in nodo cercato è all'interno della lista
		return deleteR(head,x);// il metodo chiama un metodo di eliminazione PRIVATO ricorsivo che prende in input i parametri del nodo testa e il contenuto x da eliminare
	}
	
	/*COMPLESSITA' DEL METODO delete
	 * O(n)=compessità spaziale e temporale del caso peggiore in cui si deve scandire tutta la lista.
	 * In tale istanza ci saranno n ricorsioni del metodo privato che chiama se stesso per effetuare tale scansione*/
	
	public String toString() {
		String s = "[";
		if (head != null) 
			s += this.head.toString();
		s += "]";
		return s;
	}

}

private static void print(Node n) {//NB: METODO PRIVATO PER LA STAMPA
	//si deve scandire la lista
	while (n != null) {//fino a quando non si giunge ad un nodo vuoto
		System.out.print(n.getInfo()+" "); // stampa contenuto informativo del nodo
		n = n.getNext();// si punta al nodo successivo
	}
	//usciti dal ciclo si avrà in stampa tutti i contenuti informativi dei nodi dell lista
	System.out.println();
}

public void print() {// METODO DI STAMPA DELLA LISTA
	print(head);// funzione chiama un metodo PRIVATO per effettuare la stampa
}
