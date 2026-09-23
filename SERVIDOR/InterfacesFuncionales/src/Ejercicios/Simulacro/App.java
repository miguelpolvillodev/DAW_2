package Ejercicios.Simulacro;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App {

	public static void main(String[] args) {

		Supplier<String> lambda1a = () -> "Hola Mundo";
		Supplier<String> lambda1b = () -> {
			return "Hola Mundo";
		};

		BiFunction<Integer, Integer, Integer> lambda2a = (a, b) -> a + b;
		BiFunction<Integer, Integer, Integer> lambda2b = (Integer a, Integer b) -> {
			return a + b;
		};

		Predicate<String> lambda3a = str -> str.length() > 5;
		Predicate<String> lambda3b = (String str) -> {
			return str.length() > 5;
		};
		
		BiFunction<String, String, Integer> lambda4a = (x, y) -> x.compareTo(y);
		BiFunction<String, String, Integer> lambda4b = (String x, String y) -> {
			return x.compareTo(y);
		};
		
		//1. ¿Qué relación hay entre un Consumer y un BiConsumer?
		//Pon un ejemplo de BiConsumer.
		// - Que el Consumer solo recibe un parametro y el BiConsumer 2
		
		//2. ¿Qué relación hay entre un Predicate y un BiPredicate?
		//Pon un ejemplo de BiPredicate.
		// - Los dos devuelve un boolean
		
		// ¿Con que otro Built-In Functional Interface relacionarías UnaryOperator
		//y cual es la relación?
		// - Con el BinaryOperator ya que el dato que entra por parametro es 
		// del mismo tipo que el que sale.

	}

}
