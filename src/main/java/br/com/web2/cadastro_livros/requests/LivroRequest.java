package br.com.web2.cadastro_livros.requests;

public class LivroRequest {

    private String titulo;
    private String resumo;
    private int quantidadeDePaginas;
    private String autores;
    private String categoria;

    public LivroRequest() {

    }

    public LivroRequest(String titulo, String resumo, int quantidadeDePaginas, String autores, String categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.quantidadeDePaginas = quantidadeDePaginas;
        this.autores = autores;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getQuantidadeDePaginas() {
        return quantidadeDePaginas;
    }

    public void setQuantidadeDePaginas(int quantidadeDePaginas) {
        this.quantidadeDePaginas = quantidadeDePaginas;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
