package teste;

import entidades.Carro;

import java.util.Optional;

import dao.*;

public class CarroMain {

	private static Dao<Carro> carroDao;

	public static void main(String[] args) {
		carroDao = new CarroDao();

		// Pegando carros adicionados diretamente na CarroDao
		Carro carro1 = getCarro(0);
		Carro carro2 = getCarro(1);

		// Alterando o carro1
		carroDao.atualizar(carro1, new String[] { "Volkswagen", "Gol", "2017", "Hatch" });

		// Adicionando novo carro
		carroDao.salvar(new Carro("Toyota", "Hilux", 2018, "Caminhonete"));

		// Deletar carro
		carroDao.deletar(carro2);

		carroDao.buscarTodos().forEach(carro -> System.out.println("Nome: " + carro.getModelo() + " | Categoria: " + carro.getCategoria()));

	}

	private static Carro getCarro(long id) {
		Optional<Carro> carro = carroDao.buscar(id);

		return carro.orElseGet(() -> new Carro("non-existing", "non-model", 0, "non-category"));
	}

}
