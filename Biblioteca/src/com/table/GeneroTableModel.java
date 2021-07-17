package com.table;

import com.model.Genero;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class GeneroTableModel extends AbstractTableModel {
    public static final int COL_NUMERO = 0;
    public static final int COL_NOME = 1;
    public ArrayList<Genero> lista;

    public GeneroTableModel(ArrayList<Genero> l) {
        lista = new ArrayList<Genero>(l);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Genero genero = lista.get(linha);
        if(coluna == COL_NUMERO) return linha;
        if(coluna == COL_NOME) return genero.getNome();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if(coluna == COL_NUMERO) return "";
        if(coluna == COL_NOME) return "Nome";
        return "";
    }
}
