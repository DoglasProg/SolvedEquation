package com.soverequation.main;

import java.time.LocalDate;

import com.soverequation.math.Expression;

public class main {

	public static void main(String[] args) {
		
		//operações com parametros e valores
		
		Expression exp2 = new Expression("(50)-x-x-x");
		exp2.setVariable("x", 10L);
		System.out.println(exp2.resolve());
		
		//Operações com operadores especiais 
		
		Expression exp = new Expression("y+z*((10+10)+cos(10)-sin(x)*tan(8))");
		exp.setVariable("x", 8L);
		exp.setVariable("y", 10L);
		exp.setVariable("z", 20L);
		System.out.println(exp.resolve());
		
		//Operações com data
		Expression exp3 = new Expression("a+15");
		LocalDate local = LocalDate.now();
		exp3.setVariableLocalDate("a", local);
		System.out.println(exp3.resolveLocaldate());
		

	}

}
