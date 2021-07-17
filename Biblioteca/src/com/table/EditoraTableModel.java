package com.table;

import com.model.Editora;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class EditoraTableModel extends AbstractTableModel {
    public static final int COL_CODIGO = 0;
    public static final int COL_NOME = 1;

    public ArrayList<Editora> lista;

    public EditoraTableModel(ArrayList<Editora> l) {
        lista = new ArrayList<Editora>(l);
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
        Editora editora = lista.get(linha);
        if(coluna == COL_CODIGO) return editora.getCodigo();
        if(coluna == COL_NOME) return editora.getNome();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if(coluna == COL_CODIGO) return "Código";
        if(coluna == COL_NOME) return "Nome";
        return "";
    }
}
