package br.com.linecomp.springbootmongodb.services.exception;

public class ObjectNotFoundException extends RuntimeException { // RunTimeException, o compilador nao exige que trate
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
