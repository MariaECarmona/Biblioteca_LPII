package com.dao;

import com.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LivroDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Livro> lista = new ArrayList<>();

    public LivroDAO(){
        conn = new ConnectionFactory().getConexao();
    }

    public void inserir(Livro livro){
        String sql = "INSERT into livro (Isbn, Nome, NumPaginas, Autor, Editora, Genero) VALUES (?, ?, ?, ?, ?, ?)";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, livro.getIsbn());
            stmt.setString(2, livro.getNome());
            stmt.setInt(3, livro.getNumPaginas());
            stmt.setInt(4, livro.getAutor());
            stmt.setInt(5, livro.getEditora());
            stmt.setString(6, livro.getGenero());

            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro ao inserir Livro: " + erro);
        }
    }

    public void alterar(Livro livro){
        String sql = "UPDATE livro SET Nome = ?, NumPaginas = ?, Autor = ?, Editora = ?, Genero = ? WHERE Isbn = ?";

        try{
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, livro.getNome());
            stmt.setInt(2, livro.getNumPaginas());
            stmt.setInt(3, livro.getAutor());
            stmt.setInt(4, livro.getEditora());
            stmt.setString(5, livro.getGenero());
            stmt.setString(6, livro.getIsbn());

            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro ao alterar Livro: " + erro);
        }
    }

    public void excluir(int isbn){
        String sql = "DELETE FROM livro WHERE Isbn = " + isbn;

        try{
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro ao excluir Livro: " + erro);
        }
    }

    public ArrayList<Livro> listarTodos() {
        String sql = "SELECT * FROM livro";

        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                Livro livro = new Livro();

                AutorDAO autorDAO = new AutorDAO();
                EditoraDAO editoraDAO = new EditoraDAO();
                GeneroDAO generoDAO = new GeneroDAO();


                livro.setIsbn(rs.getString("Isbn"));
                livro.setNome(rs.getString("Nome"));
                livro.setNumPaginas(rs.getInt("NumPaginas"));
                livro.setAutor(rs.getInt("Autor"));
                livro.setEditora(rs.getInt("Editora"));
                livro.setGenero(rs.getString("Genero"));

                lista.add(livro);
            }
            st.close();
            rs.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro ao listar todos os Livros: " + erro);
        }

        return lista;
    }

    public ArrayList<Livro> listarTodosFormatado() {
        String sql = "SELECT * FROM livro";

        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                Livro livro = new Livro();

                EditoraDAO editoraDAO = new EditoraDAO();
                Editora editora = editoraDAO.buscarPorCodigo(rs.getInt("Editora"));

                AutorDAO autorDAO = new AutorDAO();
                Autor autor = autorDAO.buscarPorCodigo(rs.getInt("Autor"));

                livro.setIsbn(rs.getString("Isbn"));
                livro.setNome(rs.getString("Nome"));
                livro.setNumPaginas(rs.getInt("NumPaginas"));

                livro.setAutor(rs.getInt("Autor"));
                livro.setNomeAutor(autor.getNome());

                livro.setEditora(rs.getInt("Editora"));
                livro.setNomeEditora(editora.getNome());

                livro.setGenero(rs.getString("Genero"));

                lista.add(livro);
            }
            st.close();
            rs.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro ao listar todos os livros formatados: " + erro);
        }

        return lista;
    }
}
