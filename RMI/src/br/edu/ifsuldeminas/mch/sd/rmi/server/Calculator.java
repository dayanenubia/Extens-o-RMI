package br.edu.ifsuldeminas.mch.sd.rmi.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;

public class Calculator implements Operations {
	private List<String> lastOperations = new ArrayList<String>();

	public Number sum(Number x, Number y) {
		Number result = x.doubleValue() + y.doubleValue();
		log(x, "+", y, result);
		return result;
	}

	public Number sub(Number x, Number y) {
		Number result = x.doubleValue() - y.doubleValue();
		log(x, "-", y, result);
		return result;
	}

	public Number mul(Number x, Number y) {
		Number result = x.doubleValue() * y.doubleValue();
		log(x, "*", y, result);
		return result;
	}

	public Number div(Number x, Number y) {
		Number result = Double.NaN;
		if (y.doubleValue() != 0)
			result = x.doubleValue() / y.doubleValue();
		log(x, "/", y, result);
		return result;
	}

	public Number root(Number x, int degree) {
        Number result = Double.NaN;
        if (degree > 0)
            result = Math.pow(x.doubleValue(), 1.0 / degree);
        log(x, "√" , degree, result);
        return result;
    }
	
	public Number power(Number x, int exponent) {
        Number result = Math.pow(x.doubleValue(), exponent);
        log(x, "^" , exponent, result);
        return result;
    }
	
	public Number percentage(Number total, Number percentage) {
        Number result = (total.doubleValue() * percentage.doubleValue()) / 100.0;
        log(percentage, "% of", total, result);
        return result;
    }
	
	 public Number mod(Number x, Number y) {
	        Number result = x.doubleValue() % y.doubleValue();
	        log(x, "%", y, result);
	        return result;
	    }
	 
	 public Number factorial(Number x) {
		    double n = x.doubleValue();
		    if (n < 0 || n != Math.floor(n)) { // Verifica se o número é negativo ou não inteiro
		        log(x, "!", n, Double.NaN); // Retorna NaN para valores inválidos
		        return Double.NaN;
		    }

		    double result = 1;
		    for (int i = 2; i <= n; i++) {
		        result *= i;
		    }

		    log(x, "!", n, result);
		    return result;
		}
	
	public List<String> lastOperations(int howMany) {
		if (lastOperations.size() < howMany)
			return lastOperations();
		return new ArrayList<String>(lastOperations.subList(lastOperations.size() - howMany, lastOperations.size()));
	}

	public List<String> lastOperations() {
		return lastOperations;
	}

	private void log(Number operatorOne, String operation, Number operatorTwo, Number result) {

		String formattedOperation = String.format("%s %s %s = %s", operatorOne.toString(), operation,
				operatorTwo.toString(), result.toString());
		lastOperations.add(formattedOperation);
		System.out.printf("%s at %s\n", formattedOperation, new Date());
	}

}