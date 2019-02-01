package com.soverequation.math;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.soverequation.math.Operator.Operands;
/**
 * 
 * @author doglas Lima
 *
 * Codigo responsavel por realização de equações matematicas
 * o codigo foi adaptado para necessidade do porjeto, seguindo como base 
 * o projeto Towel, cujo link segue abaixo.
 * {@link - https://github.com/MarkyVasconcelos/Towel}
 *
 */
public class Expression {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private String expression = null;
	private Map<String, Long> variables = new HashMap<String, Long>();


	/**
	 * Creates an Expression and assigns the math expression string.
	 * 
	 * @param s
	 *            the expression string
	 */
	public Expression(String s) {
		setExpression(s);
	}

	/**
	 * Adds a variable and its value in the Expression.
	 * <p>
	 * Something like this can be done:
	 * 
	 * <pre>
	 * Expression e = new Expression(&quot;(x+4)*x&quot;);
	 * e.setVariable(&quot;x&quot, 7);
	 * </pre>
	 * 
	 * @param v
	 *            the variable name
	 * @param val
	 *            the variable value
	 */
	public void setVariable(String v, Long val) {
		variables.put(v, new Long(val));
	}
	
	public void setVariableLocalDate(String v, LocalDate val) {
		variables.put(v, new Long(val.toEpochDay()));
	}

	/**
	 * Sets the expression.
	 * 
	 * @param s
	 *            the expression string
	 */
	public void setExpression(String s) {
		expression = operatorValidation(s);
	}
	
	public String operatorValidation(String s) {
		s = s.replace( "{" , "(").replaceAll("}", ")").replace("[", "(").replace("]", ")");
		return s;
	}

	/**
	 * Resolve and returns the numerical value of this expression.
	 * 
	 * @return the expression value
	 */
	public Long resolve() {
		if (expression == null)
			return null;

		try {
			return evaluate(new Node(this));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String resolveLocaldate() {
		Long valor = resolve();
		return LocalDate.ofEpochDay(valor).format(formatter);
	}

	private static Long evaluate(Node n) {
		if (n.hasOperator() && n.hasChild()) {
			if (n.getOperator().getType() == Operands.SINGLE)
				n.setValue(n.getOperator().resolve(evaluate(n.getLeft()), null));
			else if (n.getOperator().getType() == Operands.DOUBLE)
				n.setValue(n.getOperator().resolve(evaluate(n.getLeft()),
						evaluate(n.getRight())));
		}
		return n.getValue();
	}

	/***
	 * Gets the variable's value.
	 * 
	 * @param s
	 *            the variable's name
	 * @return the variable's value
	 */
	public Long getVariable(String s) {
		return variables.get(s);
	}

	/**
	 * Converts a string to a double or, if it's not possible, returns the value
	 * of the variable with the given name.
	 * 
	 * @param s
	 *            the string value or the variable name
	 * @return the double value
	 */
	public Long getDouble(String s) {
		if (s == null)
			return null;
		try {
			return new Long(Long.parseLong(s));
		} catch (Exception e) {
			return getVariable(s);
		}
	}

	/**
	 * @return a string representation of this expression
	 */
	public String getExpression() {
		return expression;
	}
}
