public class Autor implements Valida {
    private String nome;
    private String email;
    private String instituicao;

    public Autor(String nome, String email, String instituicao) {
        this.nome = nome;
        validarEmail(email);
        this.instituicao = instituicao;
    }

    @Override
    public boolean validarEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", instituicao='" + instituicao + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    
}
