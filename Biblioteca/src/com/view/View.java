package com.view;

import javax.swing.*;

public class View extends JFrame{
    private JTabbedPane painelAbas;
    private JPanel painelLivros;
    private JPanel painelAutores;

    public View(){
        painelAbas = new JTabbedPane();
        painelLivros = new JPanel();
        painelAutores = new JPanel();

        painelAbas.add("Livros", painelLivros);
        painelAbas.add("Autores", painelAutores);

        add(painelAbas);

    }
}
