package org.example;

import java.util.ArrayList;
import java.util.List;

public class Produtos {
    private List<List<Object>> ListaMistaMock;

    public Produtos(List<List<Object>> listaMistaMock) {
        ListaMistaMock = listaMistaMock;
    }

    public List<List<Object>> getListaMistaMock() {
        return ListaMistaMock;
    }

    public void setListaMistaMock(List<List<Object>> listaMistaMock) {
        ListaMistaMock = listaMistaMock;
    }
}
