package com.view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.dao.*;
import com.model.Autor;
import com.model.Editora;
import com.model.Genero;
import com.model.Livro;
import com.table.AutorTableModel;
import com.table.EditoraTableModel;
import com.table.GeneroTableModel;
import com.table.LivroTableModel;

public class View extends JFrame {
    private JTabbedPane painelAbas;

    private JPanel painelLivros;
    private JPanel painelAutores;
    private JPanel painelEditoras;
    private JPanel painelGeneros;

    private JTextField tituloTxtField;
    private JTextField autorTxtField;
    private JTextField editoraTxtField;
    private JTextField generoTxtField;
    private JTextField nomeAutorTxtField;
    private JTextField localNascAutorTxtField;
    private JTextField nomeEditoraTxtField;
    private JTextField nomeGeneroTxtField;
    private JTextField numPgTxtField;

    private JFormattedTextField isbnFmtTxtField;
    private JFormattedTextField dtNascAutorTxtField;

    private JButton btnCriar;
    private JButton btnDeletar;
    private JButton btnEditar;
    private JButton btnCriarAutor;
    private JButton btnDeletarAutor;
    private JButton btnEditarAutor;
    private JButton btnCriarEditora;
    private JButton btnDeletarEditora;
    private JButton btnEditarEditora;
    private JButton btnCriarGenero;
    private JButton btnDeletarGenero;
    private JButton btnEditarGenero;

    private JTable tabelaLivros;
    private JTable tabelaAutores;
    private JTable tabelaEditoras;
    private JTable tabelaGeneros;

    private Genero generoAntigo;
    private Editora editoraPre;

    private int autorCodigo;
    private int abaSelecionada;

    public View() throws ParseException {
        super("Manipulando o Banco de Dados");
        setLocation(400, 100);
        setSize(520, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Eventos evt = new Eventos();

        painelAbas = new JTabbedPane();
        painelLivros = new JPanel();
        painelAutores = new JPanel();
        painelEditoras = new JPanel();
        painelGeneros = new JPanel();

        painelAbas.add("Livros", painelLivros);
        painelAbas.add("Autores", painelAutores);
        painelAbas.add("Editoras", painelEditoras);
        painelAbas.add("Gêneros", painelGeneros);

        //ABA LIVROS
        JPanel painelDadosLivros = new JPanel();
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
        numPgTxtField = new JTextField();
        numPgTxtField.setPreferredSize(new Dimension(150, 24));
        painelIsbnLivro.add(numPgTxtField);
        painelDadosLivros.add(painelIsbnLivro);

        JPanel painelAcoesLivros = new JPanel();
        painelAcoesLivros.setLayout(new GridLayout(1, 3, 50, 0));
        btnCriar = new JButton("Criar");
        painelAcoesLivros.add(btnCriar);
        btnCriar.addActionListener(evt);
        btnDeletar = new JButton("Deletar");
        painelAcoesLivros.add(btnDeletar);
        btnDeletar.addActionListener(evt);
        btnEditar = new JButton("Editar");
        painelAcoesLivros.add(btnEditar);
        btnEditar.addActionListener(evt);

        JPanel painelListaLivros = new JPanel();
        painelListaLivros.setBorder(BorderFactory.createTitledBorder("Lista de Livros"));
        painelListaLivros.setPreferredSize(new Dimension(500, 200));

        tabelaLivros = new JTable();
        tabelaLivros.setModel(new LivroTableModel(new LivroDAO().listarTodosFormatado()));
        JScrollPane scrollPane = new JScrollPane(tabelaLivros);
        scrollPane.setPreferredSize(new Dimension(480, 160));
        painelListaLivros.add(scrollPane);

        ListSelectionModel modelLivros = tabelaLivros.getSelectionModel();
        modelLivros.addListSelectionListener(new Eventos());

        painelLivros.add(painelDadosLivros);
        painelLivros.add(painelAcoesLivros);
        painelLivros.add(painelListaLivros);

        //ABA AUTORES
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
        btnCriarAutor.addActionListener(evt);
        btnDeletarAutor = new JButton("Deletar");
        painelAcoesAutores.add(btnDeletarAutor);
        btnDeletarAutor.addActionListener(evt);
        btnEditarAutor = new JButton("Editar");
        painelAcoesAutores.add(btnEditarAutor);
        btnEditarAutor.addActionListener(evt);

        JPanel painelListaAutores = new JPanel();
        painelListaAutores.setBorder(BorderFactory.createTitledBorder("Lista de Autores"));
        painelListaAutores.setPreferredSize(new Dimension(500, 300));

        tabelaAutores = new JTable();
        tabelaAutores.setModel(new AutorTableModel(new AutorDAO().listarTodos()));
        JScrollPane scrollPaneAut = new JScrollPane(tabelaAutores);
        scrollPaneAut.setPreferredSize(new Dimension(480, 250));
        painelListaAutores.add(scrollPaneAut);

        ListSelectionModel modelAutores = tabelaAutores.getSelectionModel();
        modelAutores.addListSelectionListener(new Eventos());

        painelAutores.add(painelDadosAutores);
        painelAutores.add(painelAcoesAutores);
        painelAutores.add(painelListaAutores);

        //ABA EDITORAS
        JPanel painelDadosEditoras = new JPanel();
        painelDadosEditoras.setBorder(BorderFactory.createTitledBorder("Dados da Editora"));
        painelDadosEditoras.setPreferredSize(new Dimension(500, 55));

        painelDadosEditoras.add(new JLabel("Nome: "));
        nomeEditoraTxtField = new JTextField();
        nomeEditoraTxtField.setPreferredSize(new Dimension(430, 24));
        painelDadosEditoras.add(nomeEditoraTxtField);

        JPanel painelAcoesEditoras = new JPanel();
        painelAcoesEditoras.setLayout(new GridLayout(1, 3, 50, 0));
        btnCriarEditora = new JButton("Criar");
        painelAcoesEditoras.add(btnCriarEditora);
        btnCriarEditora.addActionListener(evt);
        btnDeletarEditora = new JButton("Deletar");
        painelAcoesEditoras.add(btnDeletarEditora);
        btnDeletarEditora.addActionListener(evt);
        btnEditarEditora = new JButton("Editar");
        painelAcoesEditoras.add(btnEditarEditora);
        btnEditarEditora.addActionListener(evt);

        JPanel painelListaEditoras = new JPanel();
        painelListaEditoras.setBorder(BorderFactory.createTitledBorder("Lista de Autores"));
        painelListaEditoras.setPreferredSize(new Dimension(500, 330));

        tabelaEditoras = new JTable();
        tabelaEditoras.setModel(new EditoraTableModel(new EditoraDAO().listarTodos()));
        JScrollPane scrollPaneEdi = new JScrollPane(tabelaEditoras);
        scrollPaneEdi.setPreferredSize(new Dimension(480, 250));
        painelListaEditoras.add(scrollPaneEdi);

        ListSelectionModel modelEditoras = tabelaEditoras.getSelectionModel();
        modelEditoras.addListSelectionListener(new Eventos());

        painelEditoras.add(painelDadosEditoras);
        painelEditoras.add(painelAcoesEditoras);
        painelEditoras.add(painelListaEditoras);

        //ABA GÊNEROS
        JPanel painelDadosGeneros = new JPanel();
        painelDadosGeneros.setBorder(BorderFactory.createTitledBorder("Dados do Gênero"));
        painelDadosGeneros.setPreferredSize(new Dimension(500, 55));

        painelDadosGeneros.add(new JLabel("Gênero: "));
        nomeGeneroTxtField = new JTextField();
        nomeGeneroTxtField.setPreferredSize(new Dimension(430, 24));
        painelDadosGeneros.add(nomeGeneroTxtField);

        JPanel painelAcoesGeneros = new JPanel();
        painelAcoesGeneros.setLayout(new GridLayout(1, 3, 50, 0));
        btnCriarGenero = new JButton("Criar");
        painelAcoesGeneros.add(btnCriarGenero);
        btnCriarGenero.addActionListener(evt);
        btnDeletarGenero = new JButton("Deletar");
        painelAcoesGeneros.add(btnDeletarGenero);
        btnDeletarGenero.addActionListener(evt);
        btnEditarGenero = new JButton("Editar");
        painelAcoesGeneros.add(btnEditarGenero);
        btnEditarGenero.addActionListener(evt);

        JPanel painelListaGeneros = new JPanel();
        painelListaGeneros.setBorder(BorderFactory.createTitledBorder("Lista de Gêneros"));
        painelListaGeneros.setPreferredSize(new Dimension(500, 330));

        tabelaGeneros = new JTable();
        tabelaGeneros.setModel(new GeneroTableModel(new GeneroDAO().listarTodos()));
        JScrollPane scrollPaneGen = new JScrollPane(tabelaGeneros);
        scrollPaneGen.setPreferredSize(new Dimension(480, 280));
        painelListaGeneros.add(scrollPaneGen);

        ListSelectionModel modelGeneros = tabelaGeneros.getSelectionModel();
        modelGeneros.addListSelectionListener(new Eventos());

        painelGeneros.add(painelDadosGeneros);
        painelGeneros.add(painelAcoesGeneros);
        painelGeneros.add(painelListaGeneros);

        painelAbas.addChangeListener(e -> {
            abaSelecionada = painelAbas.getSelectedIndex();
        });

        add(painelAbas);
    }

    private class Eventos implements ActionListener, ListSelectionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand() == "Criar") {
                if (abaSelecionada == 0) {
                    if(!isbnFmtTxtField.getText().equals("") && !tituloTxtField.getText().equals("") &&
                            !generoTxtField.getText().equals("") && !numPgTxtField.getText().equals("") &&
                            !autorTxtField.getText().equals("") && !editoraTxtField.getText().equals("")) {

                        Livro livro = new Livro(isbnFmtTxtField.getText(),
                                tituloTxtField.getText(),
                                generoTxtField.getText(),
                                Integer.parseInt(numPgTxtField.getText()),
                                Integer.parseInt(autorTxtField.getText()),
                                Integer.parseInt(editoraTxtField.getText())
                        );

                        new LivroDAO().inserir(livro);
                        tabelaLivros.setModel(new LivroTableModel(new LivroDAO().listarTodos()));

                        isbnFmtTxtField.setText("");
                        tituloTxtField.setText("");
                        generoTxtField.setText("");
                        numPgTxtField.setText("");
                        autorTxtField.setText("");
                        editoraTxtField.setText("");
                    }

                } else if (abaSelecionada == 1){
                    if(!nomeAutorTxtField.getText().equals("") && !localNascAutorTxtField.getText().equals("") && !dtNascAutorTxtField.getText().equals("")) {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = new Date();

                        try {
                            date = formatter.parse(dtNascAutorTxtField.getText());

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        Autor autor = new Autor(nomeAutorTxtField.getText(),
                                localNascAutorTxtField.getText(),
                                new java.sql.Date(date.getTime())
                        );

                        new AutorDAO().inserir(autor);
                        tabelaAutores.setModel(new AutorTableModel(new AutorDAO().listarTodos()));

                        nomeAutorTxtField.setText("");
                        localNascAutorTxtField.setText("");
                        dtNascAutorTxtField.setText("");
                    }

                } else if (abaSelecionada == 2) {
                    if(!nomeEditoraTxtField.getText().equals("")) {
                        Editora editora = new Editora(nomeEditoraTxtField.getText());

                        new EditoraDAO().inserir(editora);
                        tabelaEditoras.setModel(new EditoraTableModel(new EditoraDAO().listarTodos()));

                        nomeEditoraTxtField.setText("");
                    }

                } else if (abaSelecionada == 3){
                    if(!nomeGeneroTxtField.getText().equals("")) {
                        Genero genero = new Genero(nomeGeneroTxtField.getText());

                        new GeneroDAO().inserir(genero);
                        tabelaGeneros.setModel(new GeneroTableModel(new GeneroDAO().listarTodos()));

                        nomeGeneroTxtField.setText("");
                    }
                }

            } else if (evt.getActionCommand() == "Editar"){
                if (abaSelecionada == 0){
                    Livro livro = new Livro(isbnFmtTxtField.getText(),
                                                tituloTxtField.getText(),
                                                generoTxtField.getText(),
                                                Integer.parseInt(numPgTxtField.getText()),
                                                Integer.parseInt(autorTxtField.getText()),
                                                Integer.parseInt(editoraTxtField.getText())
                        );

                        new LivroDAO().alterar(livro);
                        tabelaLivros.setModel(new LivroTableModel(new LivroDAO().listarTodos()));

                }else if(abaSelecionada == 1){
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();

                    try {
                        date = formatter.parse(dtNascAutorTxtField.getText());

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    Autor autor = new Autor(nomeAutorTxtField.getText(),
                            localNascAutorTxtField.getText(),
                            new java.sql.Date(date.getTime())
                    );

                    autor.setCodigo(autorCodigo);
                    new AutorDAO().alterar(autor);
                    tabelaAutores.setModel(new AutorTableModel(new AutorDAO().listarTodos()));

                }else if (abaSelecionada == 2){
                    Editora editora = new Editora(nomeEditoraTxtField.getText());

                    editora.setCodigo(editoraPre.getCodigo());

                    new EditoraDAO().alterar(editora);
                    tabelaEditoras.setModel(new EditoraTableModel(new EditoraDAO().listarTodos()));

                }else if (abaSelecionada == 3){
                    Genero genero = new Genero(nomeGeneroTxtField.getText());

                    new GeneroDAO().alterar(generoAntigo, genero);
                    tabelaGeneros.setModel(new GeneroTableModel(new GeneroDAO().listarTodos()));

                }
            } else if (evt.getActionCommand() == "Deletar"){
                if (abaSelecionada == 0){
                    new LivroDAO().excluir(isbnFmtTxtField.getText());

                    tabelaLivros.setModel(new LivroTableModel(new LivroDAO().listarTodos()));

                    isbnFmtTxtField.setText("");
                    tituloTxtField.setText("");
                    generoTxtField.setText("");
                    numPgTxtField.setText("");
                    autorTxtField.setText("");
                    editoraTxtField.setText("");

                } else if(abaSelecionada == 1){
                    new AutorDAO().excluir(autorCodigo);
                    tabelaAutores.setModel(new AutorTableModel(new AutorDAO().listarTodos()));

                    nomeAutorTxtField.setText("");
                    dtNascAutorTxtField.setText("");
                    localNascAutorTxtField.setText("");

                }else if (abaSelecionada == 2){
                    new EditoraDAO().excluir(editoraPre.getCodigo());
                    tabelaEditoras.setModel(new EditoraTableModel(new EditoraDAO().listarTodos()));

                    nomeEditoraTxtField.setText("");

                } else if (abaSelecionada == 3){
                    new GeneroDAO().excluir(nomeGeneroTxtField.getText());
                    tabelaGeneros.setModel(new GeneroTableModel(new GeneroDAO().listarTodos()));

                    nomeGeneroTxtField.setText("");
                }
            }
        }


        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel model = (ListSelectionModel) e.getSource();
            int painelSelecionado = painelAbas.getSelectedIndex();

            if (!model.isSelectionEmpty()) {
                int selected = model.getMinSelectionIndex();

                switch (painelSelecionado) {
                    case 0:
                        ArrayList<Livro> livros = new ArrayList(new LivroDAO().listarTodos());
                        Livro livro = livros.get(selected);

                        tituloTxtField.setText(livro.getNome());
                        autorTxtField.setText(Integer.toString(livro.getAutor()));
                        editoraTxtField.setText(Integer.toString(livro.getEditora()));
                        generoTxtField.setText(livro.getGenero());
                        numPgTxtField.setText(Integer.toString(livro.getNumPaginas()));
                        isbnFmtTxtField.setText(livro.getIsbn());
                        break;

                    case 1:
                        ArrayList<Autor> autores = new ArrayList(new AutorDAO().listarTodos());
                        Autor autor = autores.get(selected);

                        Date date = autor.getDtNasc();
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                        nomeAutorTxtField.setText(autor.getNome());
                        dtNascAutorTxtField.setText(dateFormat.format(date));
                        localNascAutorTxtField.setText(autor.getLocalNasc());
                        autorCodigo = autor.getCodigo();
                        break;

                    case 2:
                        ArrayList<Editora> editoras = new ArrayList(new EditoraDAO().listarTodos());
                        Editora editora = editoras.get(selected);

                        nomeEditoraTxtField.setText(editora.getNome());
                        editoraPre = editora;
                        break;

                    case 3:
                        ArrayList<Genero> generos = new ArrayList(new GeneroDAO().listarTodos());
                        Genero genero = generos.get(selected);

                        nomeGeneroTxtField.setText(genero.getNome());
                        generoAntigo = genero;
                        break;
                }
            }
        }
    }
}

