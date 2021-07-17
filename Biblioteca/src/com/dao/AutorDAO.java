package com.dao;

import com.model.Autor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AutorDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Autor> lista = new ArrayList<>();

    public AutorDAO(){
        conn = new ConnectionFactory().getConexao();
    }

    public void inserir(Autor autor){
        String sql = "INSERT into autor (Nome, DtNasc, LocalNasc) VALUES (?, ?, ?)";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, autor.getNome());
            stmt.setDate(2, (Date) autor.getDtNasc());
            stmt.setString(3, autor.getLocalNasc());

            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 2: " + erro);
        }
    }

    public void alterar(Autor autor){
        String sql = "UPDATE autor SET Nome = ?, DtNasc = ?, LocalNasc = ? WHERE Codigo = ?";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, autor.getNome());
            stmt.setDate(2, (Date) autor.getDtNasc());
            stmt.setString(3, autor.getLocalNasc());
            stmt.setInt(4, autor.getCodigo());

            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 3: " + erro);
        }
    }

    public void excluir(int codigo){
        String sql = "DELETE FROM autor WHERE Codigo = " + codigo;

        try{
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 4: " + erro);
        }
    }

    public ArrayList<Autor> listarTodos() {
        String sql = "SELECT * FROM autor";

        try{
          st = conn.createStatement();
          rs = st.executeQuery(sql);
          while(rs.next()){
              Autor autor = new Autor();
              autor.setCodigo(rs.getInt("Codigo"));
              autor.setNome(rs.getString("Nome"));
              autor.setDtNasc(rs.getDate("DtNasc"));
              autor.setLocalNasc(rs.getString("LocalNasc"));

              lista.add(autor);
          }
          st.close();
          rs.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 5: " + erro);
        }

        return lista;
    }

    public Autor buscarPorCodigo(int isbn) {
        String sql = "SELECT " + isbn + " FROM autor";
        Autor autor = new Autor();

        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);


            while(rs.next()){
                autor.setCodigo(rs.getInt("Codigo"));
                autor.setNome(rs.getString("Nome"));
                autor.setDtNasc(rs.getDate("DtNasc"));
                autor.setLocalNasc(rs.getString("LocalNasc"));
            }

            st.close();
            rs.close();
        }catch(Exception erro){
            throw new RuntimeException("Erro 6: " + erro);
        }

        return autor;
    }
}
