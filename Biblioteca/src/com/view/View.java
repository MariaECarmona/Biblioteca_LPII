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
    private JPanel painelBusca;
    private JPanel painelDadosLivros;
    private JPanel painelAcoesLivros;

    private JTextField tituloTxtField;
    private JTextField autorTxtField;
    private JTextField editoraTxtField;
    private JTextField generoTxtField;
    private JTextField nomeAutorTxtField;
    private JTextField localNascAutorTxtField;

    private JFormattedTextField isbnFmtTxtField;
    private JFormattedTextField numPgFmtTxtField;
    private JFormattedTextField dtNascAutorTxtField;

    private JButton btnCriar;
    private JButton btnDeletar;
    private JButton btnEditar;

    private JButton btnCriarAutor;
    private JButton btnDeletarAutor;
    private JButton btnEditarAutor;

    private JTable tabelaLivros;
    private JTable tabelaAutores;

    public View() throws ParseException {
        super("Manipulando o Banco de Dados");
        setLocation(400, 100);
        setSize(520, 500);
//        setResizable(false);

        painelAbas = new JTabbedPane();
        painelLivros = new JPanel();
        painelAutores = new JPanel();
        painelEditoras = new JPanel();
        painelGeneros = new JPanel();
        painelBusca = new JPanel();

        painelAbas.add("Busca", painelBusca);
        painelAbas.add("Livros", painelLivros);
        painelAbas.add("Autores", painelAutores);
        painelAbas.add("Editoras", painelEditoras);
        painelAbas.add("Gêneros", painelGeneros);

        painelDadosLivros = new JPanel();
        painelDadosLivros.setBorder(BorderFactory.createTitledBorder("Dados do Livro"));
        painelDadosLivros.setLayout(new GridLayout(5, 1, 2, 2));
        painelDadosLivros.setPreferredSize(new Dimension(500, 180));
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

        painelAcoesLivros = new JPanel();
        painelAcoesLivros.setLayout(new GridLayout(1, 3, 50, 0));
        btnCriar = new JButton("Criar");
        painelAcoesLivros.add(btnCriar);
        btnDeletar = new JButton("Deletar");
        painelAcoesLivros.add(btnDeletar);
        btnEditar = new JButton("Editar");
        painelAcoesLivros.add(btnEditar);

        JPanel painelListaLivros = new JPanel();
        painelListaLivros.setBorder(BorderFactory.createTitledBorder("Lista de Livros"));
        painelListaLivros.setPreferredSize(new Dimension(500, 300));

        String [] colunas = {"", "ISBN", "Título", "Autor", "Editora", "Gênero", "Nº Páginas"};
        Object [][] dados = {
                {"", "ISBN", "Título", "Autor", "Editora", "Gênero", "Nº Páginas"},
                {"", "ISBN", "Título", "Autor", "Editora", "Gênero", "Nº Páginas"},
                {"", "ISBN", "Título", "Autor", "Editora", "Gênero", "Nº Páginas"},
                {"", "ISBN", "Título", "Autor", "Editora", "Gênero", "Nº Páginas"},
                {"", "ISBN", "Título", "Autor", "Editora", "Gênero", "Nº Páginas"},
                {"", "ISBN", "Título", "Autor", "Editora", "Gênero", "Nº Páginas"},
        };

        tabelaLivros = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabelaLivros);
        scrollPane.setPreferredSize(new Dimension(480, 160));
        painelListaLivros.add(scrollPane);

        painelLivros.add(painelDadosLivros);
        painelLivros.add(painelAcoesLivros);
        painelLivros.add(painelListaLivros);

        JPanel painelDadosAutores = new JPanel();
        painelDadosAutores.setBorder(BorderFactory.createTitledBorder("Dados do Autor"));
        painelDadosAutores.setLayout(new GridLayout(2, 1, 2, 2));
        painelDadosAutores.setPreferredSize(new Dimension(500, 85));

        JPanel painelNomeAutor = new JPanel();
        painelNomeAutor.setLayout(new BorderLayout(5, 5));
        painelNomeAutor.add(new JLabel("Nome: "), BorderLayout.WEST);
        nomeAutorTxtField = new JTextField();
        nomeAutorTxtField.setPreferredSize(new Dimension(400, 24));
        painelNomeAutor.add(nomeAutorTxtField, BorderLayout.EAST);
        painelDadosAutores.add(painelNomeAutor);

        JPanel painelDtNascAutor = new JPanel();
        MaskFormatter mascaraDtNasc = new MaskFormatter("##/##/####");
        painelDtNascAutor.add(new JLabel("Data de Nascimento:"));
        dtNascAutorTxtField = new JFormattedTextField(mascaraDtNasc);
        dtNascAutorTxtField.setPreferredSize(new Dimension(70, 24));
        painelDtNascAutor.add(dtNascAutorTxtField);

        painelDtNascAutor.add(new JLabel("Local de Nascimento:"));
        localNascAutorTxtField = new JTextField();
        localNascAutorTxtField.setPreferredSize(new Dimension(160, 24));
        painelDtNascAutor.add(localNascAutorTxtField);
        painelDadosAutores.add(painelDtNascAutor);

        JPanel painelAcoesAutores = new JPanel();
        painelAcoesAutores.setLayout(new GridLayout(1, 3, 50, 0));
        btnCriarAutor = new JButton("Criar");
        painelAcoesAutores.add(btnCriarAutor);
        btnDeletarAutor = new JButton("Deletar");
        painelAcoesAutores.add(btnDeletarAutor);
        btnEditarAutor = new JButton("Editar");
        painelAcoesAutores.add(btnEditarAutor);

        JPanel painelListaAutores = new JPanel();
        painelListaAutores.setBorder(BorderFactory.createTitledBorder("Lista de Autores"));
        painelListaAutores.setPreferredSize(new Dimension(500, 300));

        String [] colunasAutores = {"Código", "Nome", "Data de Nascimento", "Local de Nascimento"};
        Object [][] dadosAutores = {
                {"Código", "Nome", "Data de Nascimento", "Local de Nascimento"},
                {"Código", "Nome", "Data de Nascimento", "Local de Nascimento"},
                {"Código", "Nome", "Data de Nascimento", "Local de Nascimento"},
                {"Código", "Nome", "Data de Nascimento", "Local de Nascimento"},
                {"Código", "Nome", "Data de Nascimento", "Local de Nascimento"},
        };

        tabelaAutores = new JTable(dadosAutores, colunasAutores);
        JScrollPane scrollPaneAut = new JScrollPane(tabelaAutores);
        scrollPaneAut.setPreferredSize(new Dimension(480, 250));
        painelListaAutores.add(scrollPaneAut);

        painelAutores.add(painelDadosAutores);
        painelAutores.add(painelAcoesAutores);
        painelAutores.add(painelListaAutores);

        add(painelAbas);

    }
}
