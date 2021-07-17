package com.table;

import com.model.Autor;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class AutorTableModel extends AbstractTableModel {
    public static final int COL_NUMERO = 0;
    public static final int COL_CODIGO = 1;
    public static final int COL_NOME = 2;
    public ArrayList<Autor> lista;

    public AutorTableModel(ArrayList<Autor> l) {
        lista = new ArrayList<Autor>(l);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Autor autor = lista.get(linha);
        if(coluna == COL_NUMERO) return linha;
        if(coluna == COL_CODIGO) return autor.getCodigo();
        if(coluna == COL_NOME) return autor.getNome();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if(coluna == COL_NUMERO) return "";
        if(coluna == COL_CODIGO) return "Código";
        if(coluna == COL_NOME) return "Nome";
        return "";
    }
}
