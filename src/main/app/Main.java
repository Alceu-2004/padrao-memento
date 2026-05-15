package app;

import memento.HistoricoGuardaRoupa;
import model.GuardaRoupa;
import model.Visual;
import service.GuardaRoupaService;
import util.CoresConsole;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        GuardaRoupa guardaRoupa =
                new GuardaRoupa();

        GuardaRoupaService servico =
                new GuardaRoupaService(
                        guardaRoupa
                );

        HistoricoGuardaRoupa historico =
                new HistoricoGuardaRoupa();

        int opcao;

        do {

            System.out.println(
                    CoresConsole.CIANO
            );

            System.out.println(
                    "===== SMART WARDROBE ====="
            );

            System.out.println(
                    "1 - Adicionar roupa"
            );

            System.out.println(
                    "2 - Remover roupa"
            );

            System.out.println(
                    "3 - Criar visual"
            );

            System.out.println(
                    "4 - Exibir guarda-roupa"
            );

            System.out.println(
                    "5 - Salvar estado"
            );

            System.out.println(
                    "6 - Restaurar estado"
            );

            System.out.println(
                    "0 - Sair"
            );

            System.out.println(
                    CoresConsole.RESET
            );

            opcao = scanner.nextInt();

            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print(
                            "Nome da roupa: "
                    );

                    String nome =
                            scanner.nextLine();

                    System.out.print(
                            "Categoria: "
                    );

                    String categoria =
                            scanner.nextLine();

                    System.out.print(
                            "Cor: "
                    );

                    String cor =
                            scanner.nextLine();

                    servico.cadastrarRoupa(
                            nome,
                            categoria,
                            cor
                    );

                    System.out.println(
                            CoresConsole.VERDE +
                                    "Roupa cadastrada com sucesso!"
                                    + CoresConsole.RESET
                    );

                    break;

                case 2:

                    System.out.print(
                            "Nome da roupa: "
                    );

                    String remover =
                            scanner.nextLine();

                    guardaRoupa.removerRoupa(
                            remover
                    );

                    System.out.println(
                            CoresConsole.VERMELHO +
                                    "Roupa removida!"
                                    + CoresConsole.RESET
                    );

                    break;

                case 3:

                    System.out.print(
                            "Nome do visual: "
                    );

                    String nomeVisual =
                            scanner.nextLine();

                    Visual visual =
                            servico.criarVisual(
                                    nomeVisual
                            );

                    guardaRoupa.getRoupas()
                            .forEach(
                                    visual::adicionarRoupa
                            );

                    servico.adicionarVisual(
                            visual
                    );

                    System.out.println(
                            CoresConsole.VERDE +
                                    "Visual criado!"
                                    + CoresConsole.RESET
                    );

                    break;

                case 4:

                    guardaRoupa.exibirGuardaRoupa();

                    break;

                case 5:

                    historico.salvarSnapshot(
                            guardaRoupa.salvarEstado()
                    );

                    System.out.println(
                            CoresConsole.VERDE +
                                    "Estado salvo!"
                                    + CoresConsole.RESET
                    );

                    break;

                case 6:

                    if (
                            historico.quantidadeSnapshots() > 0
                    ) {

                        guardaRoupa.restaurarEstado(
                                historico.desfazer()
                        );

                        System.out.println(
                                CoresConsole.VERDE +
                                        "Estado restaurado!"
                                        + CoresConsole.RESET
                        );

                    } else {

                        System.out.println(
                                CoresConsole.VERMELHO +
                                        "Nenhum snapshot encontrado!"
                                        + CoresConsole.RESET
                        );
                    }

                    break;

                case 0:

                    System.out.println(
                            "Sistema encerrado."
                    );

                    break;

                default:

                    System.out.println(
                            CoresConsole.VERMELHO +
                                    "Opção inválida!"
                                    + CoresConsole.RESET
                    );
            }

        } while (opcao != 0);
    }
}