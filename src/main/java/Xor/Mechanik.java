package Xor;

import Utility.ObjectPlus4;
import Utility.ObjectPlusPlus;

public class Mechanik extends ObjectPlus4 {
    private String imie;


    public Mechanik(String imie) {
        super();
        setImie(imie);
        addXorRole("warsztat");
        addXorRole("garage");
    }

    public void setWarsztat(Warsztat warsztat) throws Exception {
        if (warsztat == null) {
            throw new IllegalStateException("Garage cannot be null");
        }
        if (warsztat.anyLink("warszrar")){
            throw new IllegalStateException("Warsztat already has a mechanic");
        }
        addLinkXor("warsztat", "mechanik", warsztat);
    }

    public void setGarage(Garage garage) throws Exception {
        if (garage == null) {
            throw new IllegalArgumentException("Garage cannot be null");
        }
        if (garage.anyLink("mechanik")){
            throw new IllegalStateException("Garage already has a mechanic");
        }
        addLinkXor("garage", "mechanik", garage);
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
        } else if(anyLink("garage")) {
            showLinks("garage",System.out);
        } else {
            System.out.println("Nie pwiązany do żadnego warsztatu ani Garage");
        }
    }
    public void remove() throws Exception {
        if (anyLink("warsztat")) {
            for (ObjectPlusPlus warsztat : getLinks("warsztat")) {
                removeLinkXor("warsztat", "mechanik",warsztat);
            }
        }
        if (anyLink("garage")) {
            for (ObjectPlusPlus garage : getLinks("garage")) {
                removeLinkXor("garage", "mechanik",garage);
            }
        }
        removeFromExtent(this);
    }
    public void removeConnections() throws Exception {
        if (anyLink("warsztat")) {
            for (ObjectPlusPlus warsztat : getLinks("warsztat")) {
                removeLinkXor("warsztat", "mechanik", warsztat);
            }
        }
        if (anyLink("garage")) {
            for (ObjectPlusPlus garage : getLinks("garage")) {
                removeLinkXor("garage", "mechanik", garage);
            }
        }

    }

}
