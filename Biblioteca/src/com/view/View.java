package com.view;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    private JTabbedPane painelAbas;

    private JPanel painelLivros;
    private JPanel painelAutores;
    private JPanel painelEditoras;
    private JPanel painelGeneros;
    private JPanel painelDadosLivros;

    private JTextField tituloTxtField;
    private JTextField autorTxtField;

    public View(){
        super("Manipulando o Banco de Dados");
        setLocation(300, 300);
        setSize(500, 600);
        setResizable(false);

        painelAbas = new JTabbedPane();
        painelLivros = new JPanel();
        painelAutores = new JPanel();
        painelEditoras = new JPanel();
        painelGeneros = new JPanel();

        painelAbas.add("Livros", painelLivros);
        painelAbas.add("Autores", painelAutores);
        painelAbas.add("Editoras", painelEditoras);
        painelAbas.add("Gêneros", painelGeneros);

        painelDadosLivros = new JPanel();
        painelDadosLivros.setBorder(BorderFactory.createTitledBorder("Dados do Livro"));
        painelLivros.add(painelDadosLivros);

        painelDadosLivros.add(new JLabel("Título: "));
        tituloTxtField = new JTextField();
        tituloTxtField.setPreferredSize(new Dimension(400, 24));

//        painelDadosLivros.add(new JLabel("Autor: "));
//        autorTxtField = new JTextField();
//        autorTxtField.setPreferredSize(new Dimension(400, 24));


        painelDadosLivros.add(tituloTxtField);
//        painelDadosLivros.add(autorTxtField);
        painelLivros.add(painelDadosLivros);
        add(painelAbas);


    }
}
