package excecoes;

public class ProgramaJaAdicionado extends Exception {
    public ProgramaJaAdicionado() {
        super("Esse programa ja estava cadastrado!");
    }
}
