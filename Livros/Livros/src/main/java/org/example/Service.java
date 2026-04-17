package org.example;

import java.lang.classfile.instruction.LocalVariable;
import java.util.ArrayList;
import java.util.List;

public class Service {
    Livo livro=new Livo();
    LivroRepository repo=new LivroRepository();

    public void criatable(){
        repo.createTableLivo();
    }

    public List<Livo> encontrarNome(String nome){
        List<Livo> livros=new ArrayList<>();
        livros=repo.findByName(nome);
        return livros;
    }
    public void inserir(Livo incluir ){
        repo.inserir(incluir);
    }
}
