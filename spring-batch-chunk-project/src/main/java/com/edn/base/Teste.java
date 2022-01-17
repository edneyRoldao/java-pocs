package com.edn.base;

public class Teste {


    public static void main(String[] args) {

        String gerex = "\\d{44}";
        String valor = "12345123451234512345123451234512345123451234";

        System.out.println(valor.matches(gerex));
    }


}
