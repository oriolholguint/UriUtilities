package com.example.teatroapp.utilities;

import org.mindrot.jbcrypt.BCrypt;

public class Crypt
{
    /**
     * Se encripta un string con algoritmo Blowfish.
     * @param string cadena a encriptar.
     * @return string encriptado con Blowfish.
     */
    public static String encryptString(String string)
    {
        String encryptString;

        encryptString = BCrypt.hashpw(string, BCrypt.gensalt());

        return encryptString;
    }

    /**
     * Se comprueba que una cadena encriptada es igual a una cadena no encriptada enviados por parametro.
     * @param encryptString cadena encriptada.
     * @param string cadena sin encriptar.
     * @return TRUE = cadenas iguales, FALSE = cadenas diferentes.
     */
    public static boolean decryptString(String encryptString, String string)
    {
        return BCrypt.checkpw(string, encryptString);
    }
}
