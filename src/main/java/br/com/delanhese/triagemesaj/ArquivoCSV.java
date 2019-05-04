/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.delanhese.triagemesaj;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Rafael Delanhese
 */
public class ArquivoCSV extends JFrame {

    private DefaultTableModel defaultTableModel;
    private JTable jtable;
    private final String colunas[] = {"Núm. Processo", "Foro", "Vara", "Disponibilização", "Prazo processual", "Movimentação", "Teor da intimação", "Classe", "Assunto", "Situação"};
    private final String dados[][] = {
        {"Jack", "19", "Masculino"},
        {"Eddie", "56", "Masculino"},
        {"Gina", "34", "Feminino"},
        {"Klaus", "18", "Masculino"},
        {"Erika", "20", "Feminino"},
        {"Roberto", "29", "Masculino"},
        {"Maria", "30", "Feminino"}};

    public ArquivoCSV() {
        setLayout(new FlowLayout());
        setTitle("Triagem E-SAJ");
        setSize(new Dimension(600, 200));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn(colunas);
        jtable = new JTable(defaultTableModel);
        jtable.setPreferredScrollableViewportSize(new Dimension(500, 100));//barra de rolagem
        jtable.setFillsViewportHeight(true);

        //adicionando a tabela em uma barra de rolagem, ficará envolta , pela mesma 
        JScrollPane scrollPane = new JScrollPane(jtable);

        //adicionando ao JFrame "Formulário" a JTable "Tabela" 
        add(scrollPane);
    }       
}
