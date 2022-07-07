package excecoes;

public class ApresentadorJaCadastrado extends Exception {
    public ApresentadorJaCadastrado() {
        super("Apresentador ja cadastrado");
    }
}
