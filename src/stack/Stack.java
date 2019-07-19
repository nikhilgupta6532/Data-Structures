package stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Stack<E> {

	private E[] elements;
	private int top = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		//elements = new E[DEFAULT_INITIAL_CAPACITY];
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public Function<E,Integer> pushToStack = (node) -> {
		this.ensureCapacity.accept(node);
		elements[top++] = node;
		return top;
	};
	
	public Supplier<E> popFromStack = () -> {
		if(top == 0) throw new EmptyStackException();
		 E result = elements[--top];
		 elements[top] = null; // Eliminating obsolete reference
		 return result;
	};
	
	public Consumer<E> ensureCapacity = (node) -> {
		if(elements.length == top) 
			elements = Arrays.copyOf(elements, 2*top+1);
	};
	
	public Supplier<Integer> getTop = () -> this.top;
	
}
