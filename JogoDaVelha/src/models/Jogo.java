/**
 * 
 */
package models;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Rafhael Honda da Silva
 *
 */
public class Jogo {
	public Jogador jogador1 = new Jogador();
	public Jogador jogador2 = new Jogador();
	public int[][] tabuleiro = new int[3][3];
	public int contadorVez = 1;

	/**
	 * 
	 */
	public Jogo() {
		// TODO Auto-generated constructor stub

	}

	public int vez() {
		int retorno;

		if (jogador1.inciaPartida) {
			if (this.contadorVez % 2 == 1)
				retorno = 1;
			else
				retorno = 2;
		} else {
			if (this.contadorVez % 2 == 1)
				retorno = 2;
			else
				retorno = 1;
		}

		this.contadorVez++;
		return retorno;
	}

	private void limparJogo() {

		this.contadorVez = 1;

		for (int linha = 0; linha < tabuleiro.length; linha++) {
			for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
				tabuleiro[linha][coluna] = 0;
			}
		}
	}

	public int verificarGanhador() {
		int resultado = 0;

		resultado = this.verificaLinhas();
		if (resultado == 1 || resultado == -1) {
			return resultado;
		}

		resultado = this.verificaColunas();
		if (resultado == 1 || resultado == -1) {
			return resultado;
		}

		resultado = this.verificaDiagonais();
		if (resultado == 1 || resultado == -1) {
			return resultado;
		}
		
		return resultado;
	}

	public void iniciarPartida() {

		limparJogo();

		do {
			jogador1.nome = JOptionPane.showInputDialog(null, "Digite o nome do jogador 1:", "Jogo da Velha",
					JOptionPane.INFORMATION_MESSAGE);

		} while (jogador1.nome == null || jogador1.nome.equals(""));

		do {
			jogador2.nome = JOptionPane.showInputDialog(null, "Digite o nome do jogador 2:", "Jogo da Velha",
					JOptionPane.INFORMATION_MESSAGE);

		} while (jogador2.nome == null || jogador2.nome.equals(""));

		int resultado = quemComeca();
		switch (resultado) {
		case 1:
			jogador1.inciaPartida = true;
			jogador1.icone = carregaImagemIcon("tic-tac-toe-o.png", 50, 50);
			jogador2.inciaPartida = false;
			jogador2.icone = carregaImagemIcon("tic-tac-toe-x.png", 50, 50);
			break;
		case 2:
			jogador2.inciaPartida = true;
			jogador2.icone = carregaImagemIcon("tic-tac-toe-o.png", 50, 50);
			jogador1.inciaPartida = false;
			jogador1.icone = carregaImagemIcon("tic-tac-toe-x.png", 50, 50);
			break;
		}

	}

	private int numeroAleatorio(int min, int max) {
		var random = new Random();
		return random.ints(min, max).findFirst().getAsInt();
	}

	private int quemComeca() {
		int numero = numeroAleatorio(1, 1000);
		if ((numero % 2) == 0)
			return 1;

		return 2;
	}

	public ImageIcon carregaImagemIcon(String nomeImagem, int altura, int largura) {
		var t = new ImageIcon(getClass().getResource("/images/" + nomeImagem)).getImage();
		var i = t.getScaledInstance(altura, largura, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(i);
	}

	public int verificaLinhas() {
		for (int linha = 0; linha < tabuleiro.length; linha++) {

			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3) {
				return -1;
			}

			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3) {				
				return 1;
			}
		}

		return 0;
	}

	public int verificaColunas() {
		for (int coluna = 0; coluna < tabuleiro.length; coluna++) {			

			if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3) {
				// System.out.println("verificaColunas -1");
				return -1;
			}

			if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3) {
				 //System.out.println("verificaColunas 1");
				return 1;
			}
		}

		return 0;

	}

	public int verificaDiagonais() {
		if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3) {
			// System.out.println("verificaDiagonais -1");
			return -1;
		}

		if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3) {
			// System.out.println("verificaDiagonais 1");
			return 1;
		}

		if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3) {
			// System.out.println("verificaDiagonais -1");
			return -1;
		}

		if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3) {
			// System.out.println("verificaDiagonais 1");
			return 1;
		}

		return 0;
	}

	public boolean tabuleiroCompleto() {
		for (int linha = 0; linha < tabuleiro.length; linha++)
			for (int coluna = 0; coluna < tabuleiro.length; coluna++)
				if (tabuleiro[linha][coluna] == 0)
					return false;
		return true;
	}

}
