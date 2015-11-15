package aufgabenblatt2;

import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Rechner {
	
	public enum Operation {
		PLUS, MINUS, MAL, GETEILT
	}
	
	private HashMap<Operation, BinaryOperator<Double>> operationMap;
	
	public Rechner() {
		operationMap = new HashMap<Operation, BinaryOperator<Double>>();
		operationMap.put(Operation.PLUS, (x,y) -> x+y);
		operationMap.put(Operation.MINUS, (x,y) -> x-y);
		operationMap.put(Operation.MAL, (x,y) -> x*y);
		operationMap.put(Operation.GETEILT, (x,y) -> {if(y!=0.0){return x/y;}; throw new IllegalArgumentException("Division durch Null");});
	}
	
	public double berechne(Operation operation, double zahl1, double zahl2){
		return operationMap.get(operation).apply(zahl1, zahl2);
	}

}
