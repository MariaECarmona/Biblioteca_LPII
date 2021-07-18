package com.table;

import com.model.Autor;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class AutorTableModel extends AbstractTableModel {
    public static final int COL_NUMERO = 0;
    public static final int COL_CODIGO = 1;
    public static final int COL_NOME = 2;
    public static final int COL_DATA_NASCIMENTO = 3;
    public static final int COL_LOCAL_NASCIMENTO = 4;

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
        return 5;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Autor autor = lista.get(linha);
        if(coluna == COL_NUMERO) return linha;
        if(coluna == COL_CODIGO) return autor.getCodigo();
        if(coluna == COL_NOME) return autor.getNome();
        if(coluna == COL_DATA_NASCIMENTO) return autor.getDtNasc();
        if(coluna == COL_LOCAL_NASCIMENTO) return autor.getLocalNasc();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if(coluna == COL_NUMERO) return "";
        if(coluna == COL_CODIGO) return "Código";
        if(coluna == COL_NOME) return "Nome";
        if(coluna == COL_DATA_NASCIMENTO) return "Data de Nascimento";
        if(coluna == COL_LOCAL_NASCIMENTO) return "Local de Nascimento";
        return "";
    }
}
