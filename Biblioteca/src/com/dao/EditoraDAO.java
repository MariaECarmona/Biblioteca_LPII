package com.dao;

import com.model.Autor;
import com.model.Editora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EditoraDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Editora> lista = new ArrayList<>();

    public EditoraDAO(){
        conn = new ConnectionFactory().getConexao();
    }

    public void inserir(Editora editora){
        String sql = "INSERT into editora (Nome) VALUES (?)";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, editora.getNome());

            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 2: " + erro);
        }
    }

    public void alterar(Editora editora){
        String sql = "UPDATE editora SET Nome = ? WHERE Codigo = ?";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, editora.getNome());
            stmt.setInt(2, editora.getCodigo());

            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 3: " + erro);
        }
    }

    public void excluir(int codigo){
        String sql = "DELETE FROM editora WHERE Codigo = " + codigo;

        try{
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 4: " + erro);
        }
    }

    public ArrayList<Editora> listarTodos() {
        String sql = "SELECT * FROM editora";

        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                Editora editora = new Editora();
                editora.setCodigo(rs.getInt("Codigo"));
                editora.setNome(rs.getString("Nome"));
                lista.add(editora);
            }

            st.close();
            rs.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 5: " + erro);
        }

        return lista;
    }

    public Editora buscarPorCodigo(int codigo) {
        String sql = "SELECT " + codigo + " FROM editora";
        Editora editora = new Editora();

        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);


            while(rs.next()){
                editora.setCodigo(rs.getInt("Codigo"));
                editora.setNome(rs.getString("Nome"));
            }

            st.close();
            rs.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 6: " + erro);
        }

        return editora;
    }
}