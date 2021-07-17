package com.table;

import com.model.Livro;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class LivroTableModel extends AbstractTableModel {
    public static final int COL_NUMERO = 0;
    public static final int COL_ISBN = 1;
    public static final int COL_NOME = 2;
    public static final int COL_AUTOR = 3;
    public static final int COL_EDITORA = 4;
    public static final int COL_GENERO = 5;
    public static final int COL_NUM_PAGINAS = 6;

    public ArrayList<Livro> lista;

    public LivroTableModel(ArrayList<Livro> l) {
        lista = new ArrayList<Livro>(l);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Livro livro = lista.get(linha);
        if(coluna == COL_NUMERO) return linha;
        if(coluna == COL_ISBN) return livro.getIsbn();
        if(coluna == COL_NOME) return livro.getNome();
        if(coluna == COL_AUTOR) return livro.getNomeAutor();
        if(coluna == COL_EDITORA) return livro.getNomeEditora();
        if(coluna == COL_GENERO) return livro.getGenero();
        if(coluna == COL_NUM_PAGINAS) return livro.getNumPaginas();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if(coluna == COL_NUMERO) return "";
        if(coluna == COL_ISBN) return "ISBN";
        if(coluna == COL_NOME) return "Nome";
        if(coluna == COL_AUTOR) return "Autor";
        if(coluna == COL_EDITORA) return "Editora";
        if(coluna == COL_GENERO) return "Gênero";
        if(coluna == COL_NUM_PAGINAS) return "Num. de Páginas";
        return "";
    }
}
