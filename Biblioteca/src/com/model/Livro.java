package com.model;

import com.dao.AutorDAO;
import com.dao.EditoraDAO;
import com.dao.LivroDAO;

public class Livro {
    private String isbn, nome, genero;
    private int numPaginas, autor, editora;
    private String nomeAutor = null, nomeEditora = null;

    public Livro(){
    }

    public Livro(String isbn, String nome, String genero, int numPaginas, int autor, int editora){
        this.isbn = isbn;
        this.nome = nome;
        this.genero = genero;
        this.numPaginas = numPaginas;
        this.autor = autor;
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getEditora() {
        return editora;
    }

    public void setEditora(int editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor() {
        Autor autor = new AutorDAO().buscarPorCodigo(this.autor);
        this.nomeAutor = autor.getNome();
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora() {
        Editora editora = new EditoraDAO().buscarPorCodigo(this.editora);
        this.nomeEditora = editora.getNome();
    }
}
