package com.mycompany.calculadora;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora extends JFrame implements ActionListener {

    private double valor1;
    private double valor2;
    private char operacao;

    private JTextField visor = new JTextField();
    private JPanel painel = new JPanel();

    private JButton num1 = new JButton("1");
    private JButton num2 = new JButton("2");
    private JButton num3 = new JButton("3");
    private JButton num4 = new JButton("4");
    private JButton num5 = new JButton("5");
    private JButton num6 = new JButton("6");
    private JButton num7 = new JButton("7");
    private JButton num8 = new JButton("8");
    private JButton num9 = new JButton("9");
    private JButton num0 = new JButton("0");

    private JButton soma = new JButton("+");
    private JButton diferenca = new JButton("-");
    private JButton produto = new JButton("x");
    private JButton divisao = new JButton("/");
    private JButton c = new JButton("C");
    private JButton ce = new JButton("CE");
    private JButton igual = new JButton("=");
    private JButton decimal = new JButton(",");
    private JButton backspace = new JButton("<=");
    private JButton maisMenos = new JButton("+/-");

    private JButton[] botoes = {ce, c, backspace, divisao,
        num7, num8, num9, produto,
        num4, num5, num6, diferenca,
        num1, num2, num3, soma,
        maisMenos, num0, decimal, igual};

    public Calculadora() {
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

        visor.setEditable(false); //Desliga a opção de escrever no JTextField
        visor.setFont(new Font("Arial", Font.PLAIN, 30));
        getContentPane().add(visor, BorderLayout.PAGE_START);

        painel.setLayout(new GridLayout(5, 4, 5, 5));

        for (JButton botao : botoes) {
            painel.add(botao);
            botao.addActionListener(this);
            botao.setFont(new Font("Arial", Font.PLAIN, 20));
        }

        getContentPane().add(painel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == num1) {
            visor.setText(visor.getText() + "1");
        } else if (e.getSource() == num2) {
            visor.setText(visor.getText() + "2");
        } else if (e.getSource() == num3) {
            visor.setText(visor.getText() + "3");
        } else if (e.getSource() == num4) {
            visor.setText(visor.getText() + "4");
        } else if (e.getSource() == num5) {
            visor.setText(visor.getText() + "5");
        } else if (e.getSource() == num6) {
            visor.setText(visor.getText() + "6");
        } else if (e.getSource() == num7) {
            visor.setText(visor.getText() + "7");
        } else if (e.getSource() == num8) {
            visor.setText(visor.getText() + "8");
        } else if (e.getSource() == num9) {
            visor.setText(visor.getText() + "9");
        } else if (e.getSource() == num0) {
            visor.setText(visor.getText() + "0");
            
        } else if (e.getSource() == decimal) {
            if (visor.getText().length() == 0) {
                visor.setText("0");
            }
            visor.setText(visor.getText() + ",");
            
        } else if (e.getSource() == soma) {
            valor1 = Double.parseDouble(visor.getText());
            operacao = '+';
            visor.setText("");
            
        } else if (e.getSource() == diferenca) {
            valor1 = Double.parseDouble(visor.getText());
            operacao = '-';
            visor.setText("");
            
        } else if (e.getSource() == produto) {
            valor1 = Double.parseDouble(visor.getText());
            operacao = '*';
            visor.setText("");
            
        } else if (e.getSource() == divisao) {
            valor1 = Double.parseDouble(visor.getText());
            operacao = '/';
            visor.setText("");
            
        } else if (e.getSource() == igual) {
            valor2 = Double.parseDouble(visor.getText());
            switch (operacao) {
                case '+' -> {
                    valor1 = valor1 + valor2;
                }
                case '-' -> {
                    valor1 = valor1 - valor2;
                }
                case '*' -> {
                    valor1 = valor1 * valor2;
                }
                case '/' -> {
                    valor1 = valor1 / valor2;
                }
            }
            visor.setText(String.valueOf(valor1));
        }
    }
    
    public static void main(String[] args) {
        new Calculadora();
    }
}

