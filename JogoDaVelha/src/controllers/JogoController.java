/**
 * 
 */
package controllers;

import javax.swing.JButton;

import models.Jogo;
import views.TabuleiroView;

/**
 * @author Rafhael Honda da Silva
 *
 */
public class JogoController {

	private TabuleiroView tabuleiroView;
	private Jogo jogo;

	/**
	 * @param args
	 */
	public JogoController(TabuleiroView tabuleiroView, Jogo jogo) {
		this.tabuleiroView = tabuleiroView;
		this.jogo = jogo;

	}

	public void initController() {

		var buttons = this.tabuleiroView.getButtons();
		for (int linha = 0; linha < buttons.length; linha++) {
			int l = linha;
			for (int coluna = 0; coluna < buttons.length; coluna++) {
				int c = coluna;
				var b = buttons[linha][coluna];
				b.addActionListener(e -> buttonTabuleiroListener(b, l, c));
			}
		}
		var buttonNovoJogo = this.tabuleiroView.getButtonNovoJogo();
		buttonNovoJogo.addActionListener(e -> buttonNovoJogoListener());
	}

	public void buttonTabuleiroListener(JButton b, int linha, int coluna) {		

		if ((this.jogo.jogador1.nome == null) || (this.jogo.jogador2.nome == null))
			return;

		var labelAcoesJogo = this.tabuleiroView.getLabelAcoesJogo();

		if (this.jogo.verificarGanhador() == 0) {
			var jogada = b.getIcon();
			if (jogada == null) {
				if (this.jogo.vez() == 1) {
					this.jogo.tabuleiro[linha][coluna] = -1;
					b.setIcon(this.jogo.jogador1.icone);
				} else {
					this.jogo.tabuleiro[linha][coluna] = 1;
					b.setIcon(this.jogo.jogador2.icone);
				}			
			}

			if (this.jogo.tabuleiroCompleto()) {
				labelAcoesJogo.setText("O Jogo empatou.");
			}

		}
		if (this.jogo.verificarGanhador() == -1) {
			labelAcoesJogo.setText("Jogador " + this.jogo.jogador1.nome + " ganhou!");
			return;
		} else if (this.jogo.verificarGanhador() == 1) {
			labelAcoesJogo.setText("Jogador " + this.jogo.jogador2.nome + " ganhou!");
			return;
		}
	}

	public void limparJogo() {

		var buttons = this.tabuleiroView.getButtons();
		for (int linha = 0; linha < buttons.length; linha++) {
			for (int coluna = 0; coluna < buttons.length; coluna++) {
				buttons[linha][coluna].setIcon(null);
			}
		}

		var labelNomeJogador1 = this.tabuleiroView.getLabelNomeJogador1();
		labelNomeJogador1.setText("");

		var labelIconeJogador1 = this.tabuleiroView.getLabelIconeJogador1();
		labelIconeJogador1.setIcon(null);

		var labelNomeJogador2 = this.tabuleiroView.getLabelNomeJogador2();
		labelNomeJogador2.setText("");

		var labelIconeJogador2 = this.tabuleiroView.getLabelIconeJogador2();
		labelIconeJogador2.setIcon(null);

		var labelAcoesJogo = this.tabuleiroView.getLabelAcoesJogo();
		labelAcoesJogo.setText("");

	}

	public void buttonNovoJogoListener() {
		limparJogo();

		this.jogo.iniciarPartida();

		var labelNomeJogador1 = this.tabuleiroView.getLabelNomeJogador1();
		labelNomeJogador1.setText(this.jogo.jogador1.nome);

		var labelIconeJogador1 = this.tabuleiroView.getLabelIconeJogador1();
		labelIconeJogador1.setIcon(this.jogo.jogador1.icone);

		var labelNomeJogador2 = this.tabuleiroView.getLabelNomeJogador2();
		labelNomeJogador2.setText(this.jogo.jogador2.nome);

		var labelIconeJogador2 = this.tabuleiroView.getLabelIconeJogador2();
		labelIconeJogador2.setIcon(this.jogo.jogador2.icone);

		var labelAcoesJogo = this.tabuleiroView.getLabelAcoesJogo();
		int inciaPartida = this.jogo.jogador1.inciaPartida ? 1 : 2;
		switch (inciaPartida) {
		case 1:
			labelAcoesJogo.setText("O Jogador " + this.jogo.jogador1.nome + " inicia a partida.");
			break;
		case 2:
			labelAcoesJogo.setText("O Jogador " + this.jogo.jogador2.nome + " inicia a partida.");
			break;
		}
	}

}
