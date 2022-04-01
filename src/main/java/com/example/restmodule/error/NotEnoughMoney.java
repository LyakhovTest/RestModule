package com.example.restmodule.error;

public class NotEnoughMoney extends RuntimeException{
    public NotEnoughMoney() {
        super("There are not enough funds on your account to purchase a ticket.");
    }
}
