/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;

/**
 *
 * @author student
 */
public class Start {
    public static void main(String[] args) throws IOException {
        ServerProgram serverProgram = new ServerProgram();
        serverProgram.pokreniServer();
    }
}
