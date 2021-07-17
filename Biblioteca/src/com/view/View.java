package com.view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;

public class View extends JFrame{
    private JTabbedPane painelAbas;

    private JPanel painelLivros;
    private JPanel painelAutores;
    private JPanel painelEditoras;
    private JPanel painelGeneros;
    private JPanel painelDadosLivros;
    private JPanel painelAcoesLivros;

    private JTextField tituloTxtField;
    private JTextField autorTxtField;
    private JTextField editoraTxtField;
    private JTextField generoTxtField;

    private JFormattedTextField isbnFmtTxtField;
    private JFormattedTextField numPgFmtTxtField;




    public View() throws ParseException {
        super("Manipulando o Banco de Dados");
        setLocation(400, 100);
        setSize(500, 600);
//        setResizable(false);

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
        painelDadosLivros.setLayout(new GridLayout(5, 1, 2, 2));
        painelLivros.add(painelDadosLivros);

        JPanel painelTituloLivro = new JPanel();
        painelTituloLivro.setLayout(new BorderLayout(5, 5));
        painelTituloLivro.add(new JLabel("Título: "), BorderLayout.WEST);
        tituloTxtField = new JTextField();
        tituloTxtField.setPreferredSize(new Dimension(400, 24));
        painelTituloLivro.add(tituloTxtField, BorderLayout.EAST);
        painelDadosLivros.add(painelTituloLivro);

        JPanel painelAutorLivro = new JPanel();
        painelAutorLivro.setLayout(new BorderLayout(5, 5));
        painelAutorLivro.add(new JLabel("Autor: "), BorderLayout.WEST);
        autorTxtField = new JTextField();
        autorTxtField.setPreferredSize(new Dimension(400, 24));
        painelAutorLivro.add(autorTxtField, BorderLayout.EAST);
        painelDadosLivros.add(painelAutorLivro);

        JPanel painelEditoraLivro = new JPanel();
        painelEditoraLivro.setLayout(new BorderLayout(5, 5));
        painelEditoraLivro.add(new JLabel("Editora: "), BorderLayout.WEST);
        editoraTxtField = new JTextField();
        editoraTxtField.setPreferredSize(new Dimension(400, 24));
        painelEditoraLivro.add(editoraTxtField, BorderLayout.EAST);
        painelDadosLivros.add(painelEditoraLivro);

        JPanel painelGeneroLivro = new JPanel();
        painelGeneroLivro.setLayout(new BorderLayout(5, 5));
        painelGeneroLivro.add(new JLabel("Gênero: "), BorderLayout.WEST);
        generoTxtField = new JTextField();
        generoTxtField.setPreferredSize(new Dimension(400, 24));
        painelGeneroLivro.add(generoTxtField, BorderLayout.EAST);
        painelDadosLivros.add(painelGeneroLivro);

        JPanel painelIsbnLivro = new JPanel();
        MaskFormatter mascaraIsbn = new MaskFormatter("#############");
        painelIsbnLivro.add(new JLabel("ISBN: "));
        isbnFmtTxtField = new JFormattedTextField(mascaraIsbn);
        isbnFmtTxtField.setPreferredSize(new Dimension(200, 24));
        painelIsbnLivro.add(isbnFmtTxtField);

        painelIsbnLivro.add(new JLabel("Nº Páginas: "));
        MaskFormatter mascaraNumPg = new MaskFormatter("###");
        numPgFmtTxtField = new JFormattedTextField(mascaraNumPg);
        numPgFmtTxtField.setPreferredSize(new Dimension(150, 24));
        painelIsbnLivro.add(numPgFmtTxtField);
        painelDadosLivros.add(painelIsbnLivro);

        painelLivros.add(painelDadosLivros);
        add(painelAbas);

        painelAcoesLivros = new JPanel();
        painelAcoesLivros.setLayout(new GridLayout(1, 3, 3, 3));
        painelLivros.add(painelAcoesLivros);


    }
}
