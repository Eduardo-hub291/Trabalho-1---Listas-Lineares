package Trabalho_01;

public class FilaAvioes {
    private Nodo inicio	;
	
	public void Lista_Encadeada() {
		inicio = null;
	}
	
	public void inserirInicio(Aviao dado) {
		Nodo novoNodo = new Nodo(dado);
		novoNodo.setProx(inicio);
		inicio = novoNodo;
	}
	
	public void inserirFinal(Aviao dado) {
        Nodo novoNodo = new Nodo(dado);
		if (vazia()) {
			inserirInicio(dado);
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			aux = aux.getProx();
		}
		aux.setProx(novoNodo);
	}
	
	public boolean vazia() {
		return  inicio == null;
	}
	
	public void mostrarLista() {
		if (vazia()) {
			System.out.println("Lista Vazia");
			return;
		}
		
		Nodo aux = inicio;
		while (aux != null) {
			System.out.println(aux.getDado());
			aux = aux.getProx();
		}
	}

	public void removerValor(Aviao valor) {
		if(vazia()) return;
		if(inicio.getDado() == valor) {
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		while(aux.getProx() != null) {
			if(aux.getProx().getDado() == valor) {
			if(aux.getProx().getDado() == valor) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			}
		}
	}
	
    public void moverValorParaInicio(Aviao valor) {
        if (vazia()) return;
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.getDado() == valor) {
                removerValor(valor); 
                inserirInicio(valor);
                return;
            }
            aux = aux.getProx();
        }
     }

    public void passarTurno() {
        if (vazia()) return;

        Nodo aux = inicio;

        while (aux != null) {
            Aviao aviao = aux.getDado();
            if (!aviao.isDecolagem()){            
                aviao.diminuirCombustivel(); 
                Transito.totalTempoEsperaPouso ++;
            } else { 
                Transito.totalTempoEsperaDecolagem ++;
            }

            aviao.aumentarTempoEspera();
            aux = aux.getProx();
        }
     }

     public void mostrarInicio() {
          if (vazia()) {
            System.out.print("Nenhuma movimentação registrada");
            return;
        }
        System.out.print(inicio.getDado().getId()); 
     }

     public void removerInicio() {
         if (!vazia()) {
             inicio = inicio.getProx();
         }
     }
     
     public int size() {
         int count = 0;
         Nodo aux = inicio;
         while (aux != null) {
             count++;
             aux = aux.getProx();
         }
         return count;
     }
     ////// GET AND SETTERS //////////////////////////////////////////////////////////////////////////////////////////////
	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}
//////GET AND SETTERS //////////////////////////////////////////////////////////////////////////////////////////////
	

}
