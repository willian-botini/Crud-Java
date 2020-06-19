package teste;

import entidades.Carro;

import java.util.Optional;
import java.util.Scanner;

import dao.*;

public class CarroMain {

	private static Dao<Carro> carroDao;

	public static void main(String[] args) {
		carroDao = new CarroDao();

		while (true) {
			System.out.println("|______________________________|");
			System.out.println("| Opção | Entidade | Ação      |");
			System.out.println("|______________________________|");
			System.out.println("| 1     | Carro    | Cadastrar |");
			System.out.println("| 2     | Carro    | Alterar   |");
			System.out.println("| 3     | Carro    | Remover   |");
			System.out.println("| 4     | Carro    | Listar    |");
			System.out.println("| 5     | Finalizar            |");
			System.out.println("|______________________________|");
			System.out.println("| * Qual opção você deseja ?   |");

			int opcao = 0;

			Scanner in = new Scanner(System.in);

			try {
				opcao = in.nextInt();
			} catch (Exception e) {
				System.out.println("Valor inesperado, tente novamente");
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Digite o número identificador do carro:");
				int id = in.nextInt();

				System.out.println("Digite a marca do carro:");
				String marca = in.next();

				System.out.println("Digite o modelo do carro:");
				String modelo = in.next();

				System.out.println("Digite o ano do carro:");
				int ano = in.nextInt();

				System.out.println("Digite a categoria do carro:");
				String categoria = in.next();

				carroDao.salvar(new Carro(id, marca, modelo, ano, categoria));
				break;

			case 2:
				System.out.println("Qual carro você deseja alterar ?");

				long i = in.nextLong();
				getCarro(i);

				System.out.println("Digite a marca do carro:");
				String marca2 = in.next();

				System.out.println("Digite o modelo do carro:");
				String modelo2 = in.next();

				System.out.println("Digite o ano do carro:");
				int ano2 = in.nextInt();

				System.out.println("Digite a categoria do carro:");
				String categoria2 = in.next();

				carroDao.atualizar(getCarro(i), new String[] { marca2, modelo2, String.valueOf(ano2), categoria2 });
				break;

			case 3:
				System.out.println("Qual carro você deseja deletar ?");

				long i2 = in.nextLong();
				getCarro(i2);

				carroDao.deletar(getCarro(i2));
				break;

			case 4:
				carroDao.buscarTodos().forEach(item -> System.out
						.println("Nome: " + item.getModelo() + " | Categoria: " + item.getCategoria()));
				break;

			case 5:
				System.out.println("Sistema finalizado");
				System.exit(0);
				break;

			default:
				System.out.println("Opção inválida");

			}

			System.out.println("Deseja continuar ? [S]/[N]");
			String opcao2 = in.next();

			if (opcao2.equals("N") || opcao2.equals("n")) {
				System.out.println("Sistema finalizado");
				System.exit(0);
			}

		}

	}

	private static Carro getCarro(long id) {
		Optional<Carro> carro = carroDao.buscar(id);

		return carro.orElseGet(() -> new Carro(0, "non-existing", "non-model", 0, "non-category"));
	}

}
