package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import constantes.StatusAluno;
import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class PrimeiraClasseJava {

	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
		
		for (int qt = 1; qt <= 4; qt++) {
			String nome = JOptionPane.showInputDialog("Nome: ");
			/*
			 * String dataNascimento = JOptionPane.showInputDialog("dataNascimento: ");
			 * String idade = JOptionPane.showInputDialog("Idade: "); String numeroCpf =
			 * JOptionPane.showInputDialog("cpf: ");
			 */

			Aluno aluno1 = new Aluno();

			aluno1.setNome(nome);
			/*
			 * aluno1.setDataNascimento(dataNascimento);
			 * aluno1.setIdade(Integer.valueOf(idade)); aluno1.setNumeroCpf(numeroCpf);
			 */

			for (int pos = 1; pos <= 1; pos++) {
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
		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERAÇÃO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
		
		
		
		for (Aluno aluno : alunos) {
			if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
				maps.get(StatusAluno.APROVADO).add(aluno);
			} else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERAÇÃO)) {
				maps.get(StatusAluno.RECUPERAÇÃO).add(aluno);
			} else {
				maps.get(StatusAluno.REPROVADO).add(aluno);
			}
		}
		System.out.println("-----APROVADOS-----");
		for(Aluno alunoAp : maps.get(StatusAluno.APROVADO)) {
			System.out.println("Aluno = "+alunoAp.getNome() +", Resultado = " + alunoAp.getAlunoAprovado() + ", média = "+alunoAp.getMedia());
		}
		
		System.out.println("-----RECUPERAÇÃO-----");
		for(Aluno alunoRec : maps.get(StatusAluno.RECUPERAÇÃO)) {
			System.out.println("Aluno = "+alunoRec.getNome() +", Resultado = " + alunoRec.getAlunoAprovado() + ", média = "+alunoRec.getMedia());
		}
		
		System.out.println("-----REPROVADOS-----");
		for(Aluno alunoRep : maps.get(StatusAluno.REPROVADO)) {
			System.out.println("Aluno = "+alunoRep.getNome() +", Resultado = " + alunoRep.getAlunoAprovado() + ", média = "+alunoRep.getMedia());
		}
	}
}
