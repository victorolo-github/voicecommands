/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rspi.voicecommands.socket;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author ulabvrl
 */
public class Cliente extends Conexion
{
    public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion

    public void startClient(String[] args) //Método para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());

            //Se enviarán dos mensajes
            for (int i = 0; i < args.length; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
                //salidaServidor.writeUTF(args[0].trim());
              //  salidaServidor.write(args[0].trim());
                salidaServidor.writeBytes(args[0].trim());
            }

            cs.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
