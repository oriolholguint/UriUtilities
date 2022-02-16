package com.example.teatroapp.utilities;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker
{
    public final static String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                                               "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public final static String PATTERN_PHONE_NUMBER = "(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}";
    public final static int    PASSWORD_MIN_CHARACTERS = 6;
    public final static int    CREDIT_CARD_MIN_CHARACTERS = 16;


    /**
     * Comprueba que el email sea correcto dado un patron, ambos enviados por parametros.
     * @param email email a comprobar.
     * @param patternEmail patron para comprobar el email.
     * @return TRUE = email correcto, FALSE = email incorrecto
     */
    public static boolean checkEmail(String email, String patternEmail)
    {
        boolean correctEmail = false;

        Pattern pattern = Pattern.compile(patternEmail);

        Matcher matcher = pattern.matcher(email);

        if(matcher.find())
        {
            correctEmail = true;
        }

        return correctEmail;
    }

    /**
     * Comprueba que el numero de movil sea correcto dado un patron, ambos enviados por parametros.
     * @param phoneNumber numero de movil a comprobar.
     * @param patternPhoneNumber patron para comprobar el numero de movil.
     * @return TRUE = numero de movil correcto, FALSE = numero de movil incorrecto
     */
    public static boolean checkPhoneNumber(String phoneNumber, String patternPhoneNumber)
    {
        boolean correctPhoneNumber = false;

        Pattern pattern =  Pattern.compile(patternPhoneNumber);

        Matcher matcher = pattern.matcher(phoneNumber);

        if(matcher.find())
        {
            correctPhoneNumber = true;
        }

        return correctPhoneNumber;
    }

    /**
     * Comprueba que el password enviado por parametros cumpla lo siguiente.
     * - Minimo 6 caracteres
     * - Minimo 1 letra minuscula
     * - Minimo 1 letra mayuscula
     * - Minimo 1 numero
     * - Minimo 1 signo de puntuacion
     * @param password
     * @return
     */
    public static boolean checkPassword(String password)
    {
        boolean correctPassword = true;
        boolean containsLowerCase = false;
        boolean containsCapitalLetter = false;
        boolean containsNumbers = false;
        boolean containsPunctuationMarks = false;
        int counter = 0;

        if((password.length() <= PASSWORD_MIN_CHARACTERS))
        {
            correctPassword = false;
        }

        while(correctPassword && counter < password.length())
        {
            char character = password.charAt(counter);

            if(checkIsNumber(character)) //Comprueba que el caracter sea un numero
            {
                containsNumbers = true;
            }
            else if(checkIsLowerCaseLetter(character)) //Comprueba que el caracter sea una letra minuscula
            {
                containsLowerCase = true;
            }
            else if(checkIsCapitalLetter(character)) //Comprueba que el caracter sea una letra mayuscula
            {
                containsCapitalLetter = true;
            }
            else if(checkIsPunctuationMark(character)) //Comprueba que el caracter sea un signo de puntuacion
            {
                containsPunctuationMarks = true;
            }
            else
            {
                correctPassword = false;
            }
            counter++;
        }

        if(!containsCapitalLetter || !containsLowerCase || !containsNumbers || !containsPunctuationMarks)
        {
            correctPassword = false;
        }

        return correctPassword;
    }

    /**
     * Comprueba que el string enviado por parametro sean numeros de una tarjeta de credito.
     * @param creditCard cadena a comprobar.
     * @return TRUE = si corresponde a numeros de tarjeta de credito, FALSE = no corresponde a numeros de tarjeta de credito
     */
    public static boolean checkCreditCard(String creditCard)
    {
        boolean correctCreditCard = true;

        int counter = 0;

        creditCard = creditCard.replace(" ", "");

        if(creditCard.length() != CREDIT_CARD_MIN_CHARACTERS)
        {
            correctCreditCard = false;
        }

        while(correctCreditCard && counter < creditCard.length())
        {
            char character = creditCard.charAt(counter);

            if(!checkIsNumber(character))
            {
                correctCreditCard = false;
            }

            counter++;
        }

        return correctCreditCard;
    }

    /**
     * Comprueba que el character enviado por parametro es un numero.
     * @param character caracter a comprobar.
     * @return TRUE = es un numero, FALSE = no es un numero.
     */
    public static boolean checkIsNumber(char character)
    {
        return character >= 48 && character <= 57;
    }

    /**
     * Comprueba que el caracter enviado por parametro es una letra minuscula.
     * @param character caracter a comprobar.
     * @return TRUE = es una letra minuscula, FALSE = no es una letra minuscula.
     */
    public static boolean checkIsLowerCaseLetter(char character)
    {
        return character >= 97 && character <= 122;
    }

    /**
     * Comprueba que el caracter enviado por parametro es una letra mayuscula.
     * @param character caracter a comprobar.
     * @return TRUE = es una letra mayuscula, FALSE = no es una letra mayuscula.
     */
    public static boolean checkIsCapitalLetter(char character)
    {
        return character >= 65 && character <= 90;
    }

    /**
     * Comprueba que el caracter enviado por parametros es un signo de puntuacion.
     * @param character caracter a comprobar.
     * @return TRUE = es un signo de puntuacion, FALSE = no es un simbolo de puntuacion.
     */
    public static boolean checkIsPunctuationMark(char character)
    {
        return (character >= 33 && character <= 47) ||
                (character >= 58 && character <= 64) ||
                (character >= 91 && character <= 96) ||
                (character >= 123 && character <= 126);
    }

    /**
     * Comprueba que el string enviado por parametros esta vacio.
     * @param string cadena a comprobar.
     * @return TRUE = cadena vacia, FALSE = cadena no vacia
     */
    public static boolean checkStringIsEmpty(String string)
    {
        return string.isEmpty();
    }

    /**
     * Comprueba que dos strings enviados por parametros son iguales
     * @param string1 primer string a comprobar
     * @param string2 segundo string a comprobar
     * @return TRUE = strings iguales, FALSE = strings diferentes
     */
    public static boolean checkSameString(String string1, String string2)
    {
        return string1.equals(string2);
    }

    /**
     * Comprueba que un fichero existe enviando la ruta del fichero por parametros
     * @param filePath ruta del fichero a comprobar si existe.
     * @return TRUE = fichero existe, FALSE = fichero no existe
     */
    public static boolean checkFileExists(String filePath)
    {
        return new File(filePath).exists();
    }
}