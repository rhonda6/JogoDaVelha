/**
 * 
 */
package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Rafhael Honda da Silva
 *
 */
public class TabuleiroView {

	private JFrame f;
	private JButton[][] buttons;
	private JButton buttonNovoJogo;
	private JLabel labelJogador1;	
	private JLabel labelJogador2;
	private JLabel labelNomeJogador1;
	private JLabel labelNomeJogador2;
	private JLabel labelIconeJogador1;
	private JLabel labelIconeJogador2;
	private JLabel labelAcoesJogo;	

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

	public JButton[][] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}
	
	public JButton getButtonNovoJogo() {
		return buttonNovoJogo;
	}

	public void setButtonNovoJogo(JButton buttonNovoJogo) {
		this.buttonNovoJogo = buttonNovoJogo;
	}
	
	public JLabel getLabelJogador1() {
		return labelJogador1;
	}

	public void setLabelJogador1(JLabel labelJogador1) {
		this.labelJogador1 = labelJogador1;
	}

	public JLabel getLabelJogador2() {
		return labelJogador2;
	}

	public void setLabelJogador2(JLabel labelJogador2) {
		this.labelJogador2 = labelJogador2;
	}

	public JLabel getLabelNomeJogador1() {
		return labelNomeJogador1;
	}

	public void setLabelNomeJogador1(JLabel labelNomeJogador1) {
		this.labelNomeJogador1 = labelNomeJogador1;
	}

	public JLabel getLabelNomeJogador2() {
		return labelNomeJogador2;
	}

	public void setLabelNomeJogador2(JLabel labelNomeJogador2) {
		this.labelNomeJogador2 = labelNomeJogador2;
	}
	
	public JLabel getLabelIconeJogador1() {
		return labelIconeJogador1;
	}

	public void setLabelIconeJogador1(JLabel labelIconeJogador1) {
		this.labelIconeJogador1 = labelIconeJogador1;
	}

	public JLabel getLabelIconeJogador2() {
		return labelIconeJogador2;
	}

	public void setLabelIconeJogador2(JLabel labelIconeJogador2) {
		this.labelIconeJogador2 = labelIconeJogador2;
	}
	
	public JLabel getLabelAcoesJogo() {
		return labelAcoesJogo;
	}

	public void setLabelAcoesJogo(JLabel labelAcoesJogo) {
		this.labelAcoesJogo = labelAcoesJogo;
	}

	/**
	 * 
	 */
	public TabuleiroView() {
		// TODO Auto-generated constructor stub

		buttons = new JButton[3][3];

		f = new JFrame("Jogo da Velha");
		f.setResizable(false);
		f.setSize(465, 470);
		
		int posX = 10;
		int posY = 10;

		for (int linha = 0; linha < buttons.length; linha++) {
			for (int coluna = 0; coluna < buttons.length; coluna++) {

				var b = buttons[linha][coluna] = new JButton();
				b.setBounds(posX, posY, 140, 100);
				b.setName("l" + linha + "c" + coluna);
				
				f.add(b);

				posX += 145;
			}
			posY += 105;
			posX = 10;

		}
		
		buttonNovoJogo = new JButton("Novo Jogo");
		buttonNovoJogo.setBounds(10, 335, 100, 50);
		f.add(buttonNovoJogo);
		
		labelJogador1 = new JLabel("Jogador 1:");
		labelJogador1.setBounds(125, 327, 100, 50);
		f.add(labelJogador1);
		
		labelNomeJogador1 = new JLabel();
		labelNomeJogador1.setBounds(125, 347, 100, 50);
		f.add(labelNomeJogador1);
		
		labelIconeJogador1 = new JLabel();
		labelIconeJogador1.setBounds(205, 327, 100, 50);
		f.add(labelIconeJogador1);
		
		labelJogador2 = new JLabel("Jogador 2:");
		labelJogador2.setBounds(295, 327, 100, 50);
		f.add(labelJogador2);
		
		labelNomeJogador2 = new JLabel();
		labelNomeJogador2.setBounds(295, 347, 100, 50);
		f.add(labelNomeJogador2);
		
		labelIconeJogador2 = new JLabel();
		labelIconeJogador2.setBounds(385, 327, 100, 50);
		f.add(labelIconeJogador2);		
		
		labelAcoesJogo = new JLabel();
		labelAcoesJogo.setBounds(10, 377, 400, 50);
		f.add(labelAcoesJogo);

		f.setLayout(null);
		f.setVisible(true);		
	}

}
