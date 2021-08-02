package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserDaoJava;
import model.UserPosJava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		UserDaoJava userDaoJava = new UserDaoJava();
		UserPosJava userPosJava = new UserPosJava();

		userPosJava.setNome("M M M ");
		userPosJava.setEmail("MMM@hotmail.com");

		userDaoJava.salvar(userPosJava);
	}

	@Test
	public void listar() {
		UserDaoJava dao = new UserDaoJava();
		try {
			List<UserPosJava> list = dao.listar();
			for (UserPosJava userPosJava : list) {
				System.out.println(userPosJava);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void listarPorId() {
		UserDaoJava dao = new UserDaoJava();
		try {
			UserPosJava userPosJava = dao.buscaPorId(1L);
			System.out.println(userPosJava);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void atualizar() {
		try {
			UserDaoJava dao = new UserDaoJava();
			UserPosJava userPosJava = dao.buscaPorId(3L);

			userPosJava.setNome("Nome alterado com sucesso!");
			dao.atualizar(userPosJava);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deletar() {
		try {
			UserDaoJava dao = new UserDaoJava();
			dao.deletar(7L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
