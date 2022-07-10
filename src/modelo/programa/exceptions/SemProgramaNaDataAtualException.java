package modelo.programa.exceptions;

public class SemProgramaNaDataAtualException extends Exception{

	public SemProgramaNaDataAtualException () {
		super("Não existem programas para hoje!");
		
	}
}
