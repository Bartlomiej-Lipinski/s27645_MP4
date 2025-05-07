package Xor;

import Utility.ObjectPlus4;
import Utility.ObjectPlusPlus;

import java.util.ArrayList;

public class Mechanik extends ObjectPlus4 {
    private String imie;


    public Mechanik(String imie) {
        super();
        setImie(imie);
        addXorRole("warsztat");
        addXorRole("projekt");
    }

    public void setWarsztat(Warsztat warsztat) throws Exception {
        if (warsztat == null) {
            throw new IllegalStateException("Projekt cannot be null");
        }
        if (warsztat.anyLink("warszrar")){
            throw new IllegalStateException("Warsztat already has a mechanic");
        }
        addLinkXor("warsztat", "mechanik", warsztat);
    }

    public void setProjekt(Projekt projekt) throws Exception {
        if (projekt == null) {
            throw new IllegalArgumentException("Projekt cannot be null");
        }
        if (projekt.anyLink("mechanik")){
            throw new IllegalStateException("Projekt already has a mechanic");
        }
        addLinkXor("projekt", "mechanik", projekt);
    }

    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        if (imie == null || imie.isEmpty()) {
            throw new IllegalArgumentException("Imie cannot be null or empty");
        }
        this.imie = imie;
    }
    public void getConnections() throws Exception {
        if (anyLink("warsztat")) {
            showLinks("warsztat",System.out);
        } else if(anyLink("projekt")) {
            showLinks("projekt",System.out);
        } else {
            System.out.println("Nie pwiązany do żadnego warsztatu ani projektu");
        }
    }
    public void remove() throws Exception {
        if (anyLink("warsztat")) {
            for (ObjectPlusPlus warsztat : getLinks("warsztat")) {
                removeFromExtent(warsztat);
            }
        }
        if (anyLink("projekt")) {
            for (ObjectPlusPlus projekt : getLinks("projekt")) {
                removeFromExtent(projekt);
            }
        }
        removeFromExtent(this);
    }


}
