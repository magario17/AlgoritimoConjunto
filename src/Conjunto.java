import java.util.ArrayList;
import java.util.List;

public class Conjunto<T> {
	public List<T> items;
	public String name;
	
	public Conjunto(String name) { 
		this.items = new ArrayList<T>();
		this.name = name; 
	}
	
	public void Imprimir(){
		String out = name + " = {";
		int cont = 0;
		for(T item: this.items){
			if(cont > 0){
				out += ", ";
			}
			out += item.toString();
			cont++;
		}
		out += "}";
		
		System.out.println(out);
	}

	public void Adicionar(T valor){ 
		items.add(valor); 
	}
	public void Adicionar(List<T> items){
		this.items.addAll(items);
	}
	public boolean Remover(T valor){
		try {
			items.remove(valor);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean Pertinencia(T valor) { 
		if( items.contains(valor) ){
			return true;
		}
		return false;
	}
	public boolean Continencia(Conjunto<T> conjunto){
		for(T item: conjunto.items){
			if(!this.Pertinencia(item)){
				return false;
			}
		}
		return true;
	}
	public Conjunto<T> Uniao(Conjunto<T> conjunto){
		Conjunto<T> uniao = new Conjunto<T>(this.name + " U " + conjunto.name);
		uniao.Adicionar(this.items);
		for(T item: conjunto.items){
			if(!uniao.Pertinencia(item)){
				uniao.Adicionar(item);
			}
		}		
		return uniao;
	}
	public Conjunto<T> Interseccao(Conjunto<T> conjunto){
		Conjunto<T> inter = new Conjunto<T>(this.name + " ^ " + conjunto.name);
		
		for(T item: conjunto.items){
			if(this.Pertinencia(item)){
				inter.Adicionar(item);
			}
		}
		
		return inter;
	}
	public Conjunto<T> Diferenca(Conjunto<T> conjunto){
		Conjunto<T> diferenca = new Conjunto<T>(this.name + " - " + conjunto.name);

		for(T item: this.items){
			if(!conjunto.Pertinencia(item)){
				diferenca.Adicionar(item);
			}
		}
		
		/*for(T item: conjunto.items){
			if(!this.Pertinencia(item)){
				diferenca.Adicionar(item);
			}
		}*/
		
		return diferenca;
	}
	public Conjunto<T> Complemento(Conjunto<T> universo){	
		return this.Diferenca(universo);
	}
	public Conjunto<Tuplas<T>> Cartesiano(Conjunto<T> conjunto){
		Conjunto<Tuplas<T>> produto = new Conjunto<Tuplas<T>>(this.name + " x " + conjunto.name);
		for(T item: this.items){
			for(T item2: conjunto.items){
				Tuplas<T> t = new Tuplas<T>(item, item2);
				produto.Adicionar(t);
			}
		}
		return produto;
	}
	
	public boolean EhVazio(){
		if(this.items.size() == 0){
			return true;
		}
		return false;
	}
	public void Limpar(){
		this.items.clear();
	}
	public int Cadinalidade() {
		return items.size(); 
	}
	
	protected int Max(){
		int max = 0;
		for(int i=0 ; i< this.Cadinalidade() ; i++){
			if(Integer.parseInt(this.items.get(i).toString()) > max){
				max = pInt(this.items.get(i));
			}
		}
		return max;
	}
	
	public int pInt(Object n){
		return Integer.parseInt(n.toString());
	}
	
	public Conjunto<Integer> CountSort(){
		int [] cnt = new int [this.Max() + 1];
		int [] b = new int [this.Cadinalidade()];
		
		for(int i=0 ; i<this.Cadinalidade() ; i++){
			cnt[pInt(this.items.get(i))] ++;
		}
		
		for(int i=1 ; i<cnt.length ; i++){
			cnt[i]+= cnt[i-1];
		}
		
		for(int i=0 ; i<this.Cadinalidade() ; i++){
			cnt[pInt(this.items.get(i))]--;
			b[cnt[pInt(this.items.get(i))]] = pInt(this.items.get(i));
		}
		
		this.Limpar();

		Conjunto<Integer> B = new Conjunto<Integer>("[Countsort] " + this.name);
				
		for(int i=0 ; i<b.length ; i++){
			B.Adicionar(b[i]);
		}
		
		return B;
	}
}