package com.api.projeto.util;

public class Formatters {
    public static String cpfFormatado(String cpf) {
        StringBuilder sb = new StringBuilder(cpf);

        sb.insert(3, '.');
        sb.insert(7, '.');

        sb.insert(11, '-');

        return sb.toString();
    }
}
