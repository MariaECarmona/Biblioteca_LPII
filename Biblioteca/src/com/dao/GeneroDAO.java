package com.dao;

import com.model.Editora;
import com.model.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GeneroDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Genero> lista = new ArrayList<>();

    public GeneroDAO(){
        conn = new ConnectionFactory().getConexao();
    }

    public void inserir(Genero genero){
        String sql = "INSERT into genero VALUE " + genero.getNome();

        try{
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro ao inserir Genero: " + erro);
        }
    }

    public void alterar(Genero antigo, Genero novo){
        String sql = "UPDATE genero SET Nome = ? WHERE Nome = ?";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, antigo.getNome());
            stmt.setString(2, novo.getNome());

            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro ao alterar Genero: " + erro);
        }
    }

    public void excluir(String nome){
        String sql = "DELETE FROM genero WHERE Nome = " + nome;

        try{
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro ao excluir Genero: " + erro);
        }
    }

    public ArrayList<Genero> listarTodos() {
        String sql = "SELECT * FROM genero";

        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                Genero genero = new Genero();
                genero.setNome(rs.getString("Nome"));
                lista.add(genero);
            }

            st.close();
            rs.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro ao listar todos os Generos: " + erro);
        }

        return lista;
    }

    public Genero buscarPorNome(String nome) {
        String sql = "SELECT " + nome + " FROM genero";
        Genero genero = new Genero();

        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                genero.setNome(rs.getString("Nome"));
            }

            st.close();
            rs.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro ao buscar Genero por nome: " + erro);
        }

        return genero;
    }
}
