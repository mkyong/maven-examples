package com.mkyong.examples;

public class StockService {

    private int qtyOnHand;

    public StockService(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    private void isValidQty(int qty) {
        if (qty < 0) {
            throw new IllegalArgumentException("Quality should be positive!");
        }
    }

    public int add(int qty) {

        isValidQty(qty);
        qtyOnHand = qtyOnHand + qty;
        return qtyOnHand;

    }

    public int deduct(int qty) {

        isValidQty(qty);

        int newQty = qtyOnHand - qty;
        if (newQty < 0) {
            throw new IllegalArgumentException("Out of Stock!");
        } else {
            qtyOnHand = newQty;
        }
        return qtyOnHand;

    }

}
