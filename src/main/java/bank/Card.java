package bank;

public class Card {



    private final long CARD_NUMBER;
    private int pinCode;

    public Card (long CARD_NUMBER){
        this.CARD_NUMBER=CARD_NUMBER;
        generatePinCode();
    }

    private void generatePinCode() {
        StringBuilder generatingPin = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            generatingPin.append(rnd(0, 9));

        }
        pinCode = Integer.parseInt(generatingPin.toString());
    }
    public long getCARD_NUMBER() {
        return CARD_NUMBER;
    }

    public int getPinCode(){
        return pinCode;

    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public static void main (String[] args){
        bank.Card firstCard = new bank.Card( 1234567897777777L);
        System.out.println("Номер карты:" + firstCard.getCARD_NUMBER());
        System.out.println("ПИН " +firstCard.getPinCode());

    }
    public static int rnd (int min,int max){
        max-= min;
        return (int) (Math.random() *++ max) + min;

    }



}


