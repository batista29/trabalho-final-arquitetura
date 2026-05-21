package itens;

import java.util.ArrayList;
import java.util.List;

public class Inventario implements Cloneable {
    private List<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        for (Item existente : itens) {
            if (existente.equals(item)) {
                existente.setQuantidade(existente.getQuantidade() + item.getQuantidade());
                //System.out.println("Somou " + item.getQuantidade() + " unidade(s) de " + item.getNome() + ".");
                return;
            }
        }
        itens.add(item);
        //System.out.println(item.getNome() + " adicionado ao inventário.");
    }

    public void removerItem(String nome) {
        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            if (item.getNome().equalsIgnoreCase(nome)) {
                if (item.getQuantidade() > 1) {
                    item.setQuantidade(item.getQuantidade() - 1);
                    System.out.println("Usou 1 " + nome + ". Restam " + item.getQuantidade() + ".");
                } else {
                    itens.remove(i);
                    System.out.println(nome + " removido do inventário.");
                }
                return;
            }
        }
        //System.out.println(nome + " não encontrado no inventário.");
    }
    public Item  getItem(int indice) {
        return itens.get(indice);
    }
 
    public void transferirItens(Inventario outro) {
    for (Item item : outro.itens) {
        this.adicionarItem(item.clone());
    }
}

    public void limparInventario() {
        itens.clear();
    }


    //construtor de copia
    public Inventario(Inventario modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo de inventário vazio");

        this.itens = new ArrayList<>();
        for (Item item : modelo.itens) {
            this.itens.add(item.clone());
        }
    }

    @Override
    public Inventario clone() {
    
        try {
            return new Inventario(this);
        } catch (Exception erro) {
            throw new RuntimeException(
                "Erro ao clonar inventário",
                erro
            );
        }
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Inventário vazio.");
            return;
        }

        System.out.println("Itens no inventário:");
        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            System.out.println((i + 1) + "- " + item.getNome() + " x" + item.getQuantidade());
        }
    }

    public int qtdItens() {
        return itens.size();
    }

    @Override
    public String toString() {
        if (itens.isEmpty()) {
            return "Inventário vazio.";
        }

        String resultado = "Itens no inventário:\n";
        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            resultado += (i + 1) + "- " + item.getNome() + " x" + item.getQuantidade() + "\n";
        }

        return resultado;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Inventario))
            return false;

        Inventario outro = (Inventario) obj;
        return this.itens.equals(outro.itens);
    }

    @Override
    public int hashCode() {
        int ret = 1;
        for (int i=0; i<itens.size(); i++) {
            ret =ret*2+ itens.get(i).hashCode();
        }
        if(ret<0) ret = -ret;
        return ret;
    }

    //Acredito que não precise fazer compareTo
}