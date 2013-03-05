
public class teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Conjunto<String> a = new Conjunto<String>("A");
		a.Adicionar("a");
		a.Adicionar("b");
		a.Adicionar("c");
		a.Adicionar("d");
		a.Imprimir();
		
		Conjunto<String> b = new Conjunto<String>("B");
		b.Adicionar("c");
		b.Adicionar("d");
		b.Adicionar("e");
		b.Adicionar("f");
		b.Imprimir();
		
		Conjunto<String> c = a.Uniao(b);
		c.Imprimir();

		Conjunto<String> d = a.Interseccao(b);
		d.Imprimir();
		
		Conjunto<String> e = a.Diferenca(b);
		e.Imprimir();
	}

	public static void Imprimir(Object out){
		System.out.println(out);
	}
}
