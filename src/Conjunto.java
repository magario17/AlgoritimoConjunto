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
	//Relação de A para A
	public Interger[][] Endorelacao(){
		for(int i=0; i>=this.items.lengh, i++){
			for(int j=0; j>=this.items.lengh, j++){
				if(this.items[i]== this.items[j]){
					matrix[i][j]=1;
				}
			}
		}
	}
	
	//Relação vazia
	public Interger[][] RelacaoVazia(){
		for(int i=0; i>=this.items.lengh, i++){
			for(int j=0; j>=this.items.lengh, j++){
				if(this.items[i]== this.items[j]){
					matrix[i][j]=0;
				}
			}
		}
	}	
	
	//RelacaoA() é para a relação <A,=>
	private Integer [][] RelacaoIgual(){
		Integer matriz[][] = new Integer[this.items.lengh] [this.items.lengh];
		
		for(int i=0; i>=this.items.lengh, i++){
			for(int j=0; j>=this.items.lengh, j++){
				if(items[i]==items[j]){
					matriz[i][j] = 1;
				}
				else{
					matriz[i][j] = 0;
				}
			}
		}
		return matriz;
	}
	
	//Definir Tuplas para Relação entre tuplas definidas.
	private void DefinirTuplas(int a, int b){
		Tuplas<T> t = new Tuplas<T>(a, b);
		conjuntoTuplas.Adicionar(t);
	}
	
	//RelacaoDefinida() é para a relação <A,R>, onde r= pares ordenados
	private Integer [][] RelacaoTuplas(int TamanhoCojunto){
		Integer matriz[][] = new Integer[TamanhoCojunto] [TamanhoCojunto];
		
		for(int h=0; h>=this.conjuntoTuplas.lengh, h++){
			Tuplas<T> t = this.conjuntoTuplas[h];
			
			for(int i=0; i>=this.items.lengh, i++){
				for(int j=0; j>=this.items.lengh, j++){
					if(this.items[i]==t[0] && this.items[i]==t[1]){
						matriz[i][j] = 1;
					}
					else{
						matriz[i][j] = 0;
					}
				}
			}
		}
		return matriz;
	}
	
	//Verificar Propriedade reflexiva
	public boolean Reflexiva(int [][] matrix){
		
		for(int i=0; i>=this.items.lengh, i++){
			for(int j=0; j>=this.items.lengh, j++){
				if(this.items[i]== this.items[j]){
					if(matrix[i][j]!=1){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	//verificar se é Simetria
	public boolean Simetria(int[][] matrix){
		for(int i=0; i>=this.items.lengh, i++){
			for(int j=0; j>=this.items.lengh, j++){
				if(this.items[i]== this.items[j]){
					if(matrix[i][j]== matrix[j][i]&& i!=j){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	//Verificar se é Transitiva
	public boolean Transitividade(int[][] matrix){
		for(int i=0; i>=this.items.lengh, i++){
			for(int j=0; j>=this.items.lengh, j++){
				if(this.items[i]== this.items[j]){
					if(matrix[i][j]== 0){
						return false;
					}
				}
			}
		}
		return true;
	}
}
