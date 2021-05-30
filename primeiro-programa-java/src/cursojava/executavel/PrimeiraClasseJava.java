package cursojava.executavel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class PrimeiraClasseJava {

	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<Aluno>();

		for (int qt = 1; qt <= 2; qt++) {
			String nome = JOptionPane.showInputDialog("Nome: ");
			/*String dataNascimento = JOptionPane.showInputDialog("dataNascimento: ");
			String idade = JOptionPane.showInputDialog("Idade: ");
			String numeroCpf = JOptionPane.showInputDialog("cpf: ");
			String nomePai = JOptionPane.showInputDialog("Nome do pai: ");*/

			Aluno aluno1 = new Aluno();

			aluno1.setNome(nome);
			/*aluno1.setDataNascimento(dataNascimento);
			aluno1.setIdade(Integer.valueOf(idade));
			aluno1.setNumeroCpf(numeroCpf);
			aluno1.setNomePai(nomePai);*/

			for (int pos = 1; pos <= 4; pos++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Disciplina" + pos + ":");
				String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina" + pos + ":");

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Double.valueOf(notaDisciplina));
				aluno1.getDisciplinas().add(disciplina);
			}

			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover?");

			if (escolha == 0) {
				String removerDisciplina = JOptionPane.showInputDialog("Indice: ");
				aluno1.getDisciplinas().remove(Integer.valueOf(removerDisciplina).intValue() - 1);
			}

			alunos.add(aluno1);
		}
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
			System.out.println(aluno.getMedia());
			System.out.println(aluno.getAlunoAprovado());
		}
	}

}
