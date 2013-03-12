public class Tuplas<T>{
  public T t1;
	public T t2;
	
	public Tuplas(T t1, T t2) {
		super();
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public String toString() {
		return "(" + t1.toString() + ", " + t2.toString() + ")";
	}
}
