package pt.isep.tp9.listatelefonica.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaTelefonica implements Serializable {
    private List<ContactoTelefonico> listaTelefonica;

    public ListaTelefonica() {
        listaTelefonica = new ArrayList<>();
    }

    @Override
    public String toString() {
        List<ContactoTelefonico> copia = new ArrayList<>(listaTelefonica);
        Collections.sort(copia);
        
        StringBuilder s = new StringBuilder();
        for (ContactoTelefonico telefone : copia) {
            s.append(telefone);
            s.append("\n");
        }
        
        return s.toString().trim();
    }

    public boolean isVazia() {
        return listaTelefonica.isEmpty();
    }

    public int adicionarListaTelefonica(ListaTelefonica outraListaTelefonica) {
        int totalContactosAdicionados = 0;
        for (ContactoTelefonico contacto : outraListaTelefonica.listaTelefonica) {
            boolean contactoAdicionado = adicionarContactoTelefonico(contacto);
            if (contactoAdicionado) {
                totalContactosAdicionados++;
            }
        }
        return totalContactosAdicionados;
    }

    public boolean adicionarContactoTelefonico(String titular, int numero) {
        return adicionarContactoTelefonico(new ContactoTelefonico(titular, numero));
    }

    private boolean adicionarContactoTelefonico(ContactoTelefonico contacto) {
        return listaTelefonica.contains(contacto) ? false : listaTelefonica.add(contacto);
    }
}