package dao;

import java.util.*;

import entidades.Carro;

public class CarroDao implements Dao<Carro> {

	public CarroDao() {
		carros.add(new Carro("Chevrolet", "Onix", 2014, "Hatch"));
		carros.add(new Carro("Hyundai", "Hb-20", 2020, "Sedan"));
	}

	public List<Carro> carros = new ArrayList<>();

	public Optional<Carro> buscar(long id) {
		return Optional.ofNullable(carros.get((int) id));
	}

	public List<Carro> buscarTodos() {
		return carros;
	}

	public void salvar(Carro carro) {
		carros.add(carro);
	}

	public void atualizar(Carro carro, String[] params) {
		carro.setMarca(Objects.requireNonNull(params[0], "A marca não pode estar vazio"));
		carro.setModelo(Objects.requireNonNull(params[1], "O modelo não pode estar vazio"));
		carro.setAno(Objects.requireNonNull(Integer.parseInt(params[2]), "O ano não pode estar vazio"));
		carro.setCategoria(Objects.requireNonNull(params[3], "O categoria não pode estar vazio"));

		carros.add(carro);
	}

	public void deletar(Carro carro) {
		carros.remove(carro);
	}

}
