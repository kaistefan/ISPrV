package aufgabe3;

public class Token<E> {
	E token;
	
	public Token(E e){
		token=e;
	}
	
	public boolean compare(Token e){
		return (this.token==e.token);
	}
}
