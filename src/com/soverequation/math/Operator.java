package com.soverequation.math;


public enum Operator {

	/**
	 * Sum operator, represented by &quot;+&quot; symbol.
	 */
	PLUS("+", Operands.DOUBLE, 0) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return f1 + f2;
		}
	},
	/**
	 * Difference operator, represented by &quot;-&quot; symbol.
	 */
	MINUS("-", Operands.DOUBLE, 0) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return f1 - f2;
		}

	},
	/**
	 * Multiplication operator, represented by &quot;*&quot; symbol.
	 */
	TIMES("*", Operands.DOUBLE, 10) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return f1 * f2;
		}

	},
	/**
	 * Division operator, represented by &quot;/&quot; symbol.
	 */
	DIV("/", Operands.DOUBLE, 10) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return f1 / f2;
		}

	},
	/**
	 * Power operator, represented by &quot;^&quot; symbol.
	 */
	POW("^", Operands.DOUBLE, 10) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.pow(f1, f2);
		}

	},
	/**
	 * Division module operator, represented by &quot;%&quot; symbol.
	 */
	MOD("%", Operands.DOUBLE, 10) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return f1 % f2;
		}

	},
	/**
	 * Cosine operator, represented by &quot;cos&quot; function. The angle must
	 * be in radians.
	 * 
	 * @see #RAD
	 */
	COS("cos", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.cos(f1);
		}

	},
	/**
	 * Sine operator, represented by &quot;sin&quot; function. The angle must be
	 * in radians.
	 * 
	 * @see #RAD
	 */
	SIN("sin", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.sin(f1);
		}

	},
	/**
	 * Tangent operator, represented by &quot;tan&quot; function. The angle must
	 * be in radians.
	 * 
	 * @see #RAD
	 */
	TAN("tan", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.tan(f1);
		}

	},
	/**
	 * Arc cosine operator, represented by &quot;acos&quot; function. The return
	 * value is in radians.
	 * 
	 * @see #RAD
	 */
	ACOS("acos", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.acos(f1);
		}

	},
	/**
	 * Arc sine operator, represented by &quot;asin&quot; function. The return
	 * value is in radians.
	 * 
	 * @see #RAD
	 */
	ASIN("asin", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.asin(f1);
		}

	},
	/**
	 * Arc tangent operator, represented by &quot;atan&quot; function. The
	 * return value is in radians.
	 * 
	 * @see #RAD
	 */
	ATAN("atan", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.atan(f1);
		}

	},
	/**
	 * Square root operator, represented by &quot;sqrt&quot; function.
	 */
	SQRT("sqrt", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.sqrt(f1);
		}

	},
	/**
	 * Squared operator, represented by &quot;sqr&quot; function.
	 */
	SQR("sqr", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return f1 * f1;
		}

	},
	/**
	 * Natural logarithm operator, represented by &quot;log&quot; function.
	 */
	LOG("log", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.log(f1);
		}

	},
	/**
	 * Floor operator, represented by &quot;floor&quot; function.
	 */
	FLOOR("floor", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.floor(f1);
		}

	},
	/**
	 * Ceil operator, represented by &quot;ceil&quot; function.
	 */
	CEIL("ceil", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.ceil(f1);
		}

	},
	/**
	 * Absolute operator, represented by &quot;abs&quot; function.
	 */
	ABS("abs", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return Math.abs(f1);
		}

	},
	/**
	 * Negative operator, represented by &quot;neg&quot; function.
	 */
	NEG("neg", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return -f1;
		}

	},
	/**
	 * Random operator, represented by &quot;rnd&quot; function. Returns a
	 * random double between zero and (the given parameter - 0.01).
	 */
	RND("rnd", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) (Math.random() * f1);
		}
	},
	/**
	 * To radians operator, represented by &quot;rad&quot; function.
	 */
	RAD("rad", Operands.SINGLE, 20) {
		@Override
		public Long resolve(Long f1, Long f2) {
			return (long) Math.toRadians(f1);
		}
	}
	;

	private String op;
	private Operands type;
	private int priority;

	private Operator(String op, Operands type, int p) {
		this.op = op;
		this.type = type;
		priority = p;
	}

	/**
	 * Execute this operation with the given numbers.
	 * 
	 * @param f1
	 *            the first number (required)
	 * @param f2
	 *            the second number (required, if this operator's type is
	 *            {@link Operands#DOUBLE DOUBLE})
	 * @return the result of this operation
	 */
	public abstract Long resolve(Long f1, Long f2);
	

	/**
	 * Operator's type.
	 * 
	 * @author Marcos A. Vasconcelos Junior
	 */
	public enum Operands {
		/**
		 * Single operand operation.
		 */
		SINGLE,
		/**
		 * Double operand operation.
		 */
		DOUBLE;
	}

	/**
	 * Gets string representation of this operation.
	 * 
	 * @return the string representation
	 */
	public String getOperator() {
		return op;
	}

	/**
	 * Gets the type of this Operator.
	 * 
	 * @return the operator's type
	 */
	public Operands getType() {
		return type;
	}

	/**
	 * Gets the solve priority value. Higher priorities are resolved first.
	 * 
	 * @return the operator priority
	 */
	public int getPriority() {
		return priority;
	}

}
