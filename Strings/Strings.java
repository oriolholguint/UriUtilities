package com.example.teatroapp.utilities;

public class Strings
{

    /**
     * Elimina los espacios en blanco de una cadena enviada por parametro.
     * @param string cadena a eliminar los espacios en blanco.
     * @return cadena sin espacios en blanco.
     */
    public static String deleteBlankSpace(String string)
    {
        return string.replace(" ", "");
    }
}
