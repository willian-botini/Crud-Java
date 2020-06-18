package dao;

import java.util.*;

public interface Dao<T> {

	Optional<T> buscar(long id);

	List<T> buscarTodos();

	void salvar(T t);

	void atualizar(T t, String[] params);

	void deletar(T t);

}
