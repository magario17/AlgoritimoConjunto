
public class teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Conjunto<Integer> a = new Conjunto<Integer>("A");
	    a.Adicionar(1);
	    a.Adicionar(2);
	    a.Adicionar(3);
	    a.Adicionar(0);
	    a.Adicionar(4);
	    a.Adicionar(6);
	    
	    a.Imprimir();
	    
	    a.CountSort().Imprimir();
	}

	public static void Imprimir(Object out){
		System.out.println(out);
	}
}
