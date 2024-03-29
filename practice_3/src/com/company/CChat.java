package com.company;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CChat {
    public static void main(String[] args) throws Exception {

        try (var socket = new Socket("localhost", 59898)) {
            System.out.println("Введите строки текста, затем Ctrl + D или Ctrl + C, чтобы выйти");
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println(in.nextLine());
            }
        }
        if (args.length != 1) {
            System.err.println("Передайте IP-адрес сервера в качестве единственного аргумента командной строки");
            return;
        }
    }
}
