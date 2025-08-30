package service;

import model.Pessoa;
import java.util.ArrayList;

public class CadastroService {
    private final ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    // Cadastrar pessoa
    public void cadastrar(Pessoa pessoa) {
        listaPessoas.add(pessoa);
    }

    // Listar todas as pessoas
    public ArrayList<Pessoa> listar() {
        return listaPessoas;
    }

    // Buscar por nome
    public Pessoa buscarPorNome(String nome) {
        for (Pessoa p : listaPessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    // Remover por índice
    public boolean remover(int index) {
        if (index >= 0 && index < listaPessoas.size()) {
            listaPessoas.remove(index);
            return true;
        }
        return false;
    }
}
