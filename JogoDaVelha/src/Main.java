import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
    JButton[] bt = new JButton[9];
    JLabel placar = new JLabel("PLACAR");
    JLabel px = new JLabel("X 0");
    JLabel po = new JLabel("O 0");
    JLabel obs = new JLabel("X É o primeiro a jogar");
    JButton novo = new JButton("Novo Jogo");
    JButton zerar = new JButton("Zerar Placar");
    int PX = 0;
    int PO = 0;
    boolean xo = false;
    boolean[] click = new boolean[9];

    public Main() {
        // Layout Da Janela
        setVisible(true);
        setTitle("Jogo Da Velha");
        setDefaultCloseOperation(3);
        setLayout(null);
        setBounds(250, 100, 700, 500);
        // Aviso
        add(obs);
        obs.setBounds(450,220,180,30);
        obs.setFont(new Font("Arial", Font.BOLD, 15));
        // Posição Placar
        add(placar);
        add(px);
        add(po);
        placar.setBounds(490, 50, 100, 30);
        placar.setFont(new Font("Arial", Font.BOLD, 20));
        px.setBounds(490, 75, 100, 30);
        po.setBounds(550, 75, 100, 30);
        // Botão Novo Jogo
        add(novo);
        novo.setBounds(458, 100, 140, 30);
        novo.addActionListener(new java.awt.event.ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent ae) {
                                       limpar();
                                   }
                               }
        );
        //Botão Zerar Placar
        add(zerar);
        zerar.setBounds(458, 140, 140, 30);
        zerar.addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        PO = 0;
                                        PX = 0;
                                        atualizar();
                                    }
                                }
        );
        // Posição Botões

        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bt[cont] = new JButton();
                add(bt[cont]);
                bt[cont].setBounds((100 * i) + 50, (100 * j) + 50, 95, 95);
                bt[cont].setFont(new Font("Arial", Font.BOLD, 40));
                cont++;
            }
        }
        for (int i = 0; i < 9; i++) {
            click[i] = false;
        }
        bt[0].addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        if (click[0] == false) {
                                            click[0] = true;
                                            mudar(bt[0]);
                                        }
                                    }
                                }
        );
        bt[1].addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        if (click[1] == false) {
                                            click[1] = true;
                                            mudar(bt[1]);
                                        }
                                    }
                                }
        );
        bt[2].addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        if (click[2] == false) {
                                            click[2] = true;
                                            mudar(bt[2]);
                                        }
                                    }
                                }
        );
        bt[3].addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        if (click[3] == false) {
                                            click[3] = true;
                                            mudar(bt[3]);
                                        }
                                    }
                                }
        );
        bt[4].addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        if (click[4] == false) {
                                            click[4] = true;
                                            mudar(bt[4]);
                                        }
                                    }
                                }
        );
        bt[5].addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        if (click[5] == false) {
                                            click[5] = true;
                                            mudar(bt[5]);
                                        }
                                    }
                                }
        );
        bt[6].addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        if (click[6] == false) {
                                            click[6] = true;
                                            mudar(bt[6]);
                                        }
                                    }
                                }
        );
        bt[7].addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        if (click[7] == false) {
                                            click[7] = true;
                                            mudar(bt[7]);
                                        }
                                    }
                                }
        );
        bt[8].addActionListener(new java.awt.event.ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        if (click[8] == false) {
                                            click[8] = true;
                                            mudar(bt[8]);
                                        }
                                    }
                                }
        );
    }

    public void mudar(JButton btn) {
        if (xo) {
            btn.setText("O");
            xo = false;
        } else {
            btn.setText("X");
            xo = true;
        }
        ganhou();
    }

    public void atualizar() {
        px.setText("X " + PX);
        po.setText("O " + PO);
    }

    public void ganhou() {
        int cont = 0;
        for (int i = 0; i < 9; i++) {
            if (click[i] == true) {
                cont++;
            }
        }
        if ((bt[0].getText() == "X" && bt[1].getText() == "X" && bt[2].getText() == "X")
                || (bt[3].getText() == "X" && bt[4].getText() == "X" && bt[5].getText() == "X")
                || (bt[6].getText() == "X" && bt[7].getText() == "X" && bt[8].getText() == "X")
                || (bt[0].getText() == "X" && bt[3].getText() == "X" && bt[6].getText() == "X")
                || (bt[1].getText() == "X" && bt[4].getText() == "X" && bt[7].getText() == "X")
                || (bt[2].getText() == "X" && bt[5].getText() == "X" && bt[8].getText() == "X")
                || (bt[0].getText() == "X" && bt[4].getText() == "X" && bt[8].getText() == "X")
                || (bt[6].getText() == "X" && bt[4].getText() == "X" && bt[2].getText() == "X")) {
            JOptionPane.showMessageDialog(null, "X Ganhou!");
            PX++;
            atualizar();
            limpar();
        } else if ((bt[0].getText() == "O" && bt[1].getText() == "O" && bt[2].getText() == "O")
                || (bt[3].getText() == "O" && bt[4].getText() == "O" && bt[5].getText() == "O")
                || (bt[6].getText() == "O" && bt[7].getText() == "O" && bt[8].getText() == "O")
                || (bt[0].getText() == "O" && bt[3].getText() == "O" && bt[6].getText() == "O")
                || (bt[1].getText() == "O" && bt[4].getText() == "O" && bt[7].getText() == "O")
                || (bt[2].getText() == "O" && bt[5].getText() == "O" && bt[8].getText() == "O")
                || (bt[0].getText() == "O" && bt[4].getText() == "O" && bt[8].getText() == "O")
                || (bt[6].getText() == "O" && bt[4].getText() == "O" && bt[2].getText() == "O")) {
            JOptionPane.showMessageDialog(null, "O Ganhou!");
            PO++;
            atualizar();
            limpar();
        } else if (cont == 9) {
            JOptionPane.showMessageDialog(null, "Empate!");
            limpar();
        }
    }

    public void limpar() {
        for (int i = 0; 1 < 10; i++) {
            bt[i].setText("");
            click[i] = false;
            xo = false;
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
