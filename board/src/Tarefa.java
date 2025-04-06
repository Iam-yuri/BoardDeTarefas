public class Tarefa {
    private String titulo;
    private String descricao;
    private Status status;

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = Status.A_FAZER;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "[" + status + "] " + titulo + " - " + descricao;
    }
}
