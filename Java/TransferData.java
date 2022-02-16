//PUT package here

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Oriol HT <oriolholguint@gmail.com>
 */
public class TransferData 
{
    private static void sendObject(Socket socket, Object object) throws IOException
    {
        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(object);
    }

    public static void sendByte(Socket socket, byte data) throws IOException
    {
        sendObject(socket, data);
    }

    public static void sendShort(Socket socket, short data) throws IOException
    {
        sendObject(socket, data);
    }

    public static void sendInteger(Socket socket, int data) throws IOException
    {
        sendObject(socket, data);
    }

    public static void sendLong(Socket socket, long data) throws IOException
    {
        sendObject(socket, data);
    }

    public static void sendFloat(Socket socket, float data) throws IOException
    {
        sendObject(socket, data);
    }

    public static void sendDouble(Socket socket, double data) throws IOException
    { 
        sendObject(socket, data);
    }

    public static void sendBoolean(Socket socket, boolean data) throws IOException
    {
        sendObject(socket, data);
    }

    public static void sendChar(Socket socket, char data) throws IOException
    {
        sendObject(socket, data);
    }
    
    public static void sendString(Socket socket, String data) throws IOException
    {
        sendObject(socket, data);
    }

    private static Object receiveObject(Socket socket) throws IOException, ClassNotFoundException
    {
        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        return ois.readObject();
    }

    public static byte receiveByte(Socket socket) throws IOException, ClassNotFoundException
    {
        return (byte) receiveObject(socket);
    }

    public static short receiveShort(Socket socket) throws IOException, ClassNotFoundException
    {
        return (short) receiveObject(socket);
    }

    public static int receiveInteger(Socket socket) throws IOException, ClassNotFoundException
    {
        return (int) receiveObject(socket);
    }
    
    public static long receiveLong(Socket socket) throws IOException, ClassNotFoundException
    {
        return (long) receiveObject(socket);
    }

    public static float receiveFloat(Socket socket) throws IOException, ClassNotFoundException
    {
        return (float) receiveObject(socket);
    }

    public static double receiveDouble(Socket socket) throws IOException, ClassNotFoundException
    {
        return (double) receiveObject(socket);
    }

    public static boolean receiveBoolean(Socket socket) throws IOException, ClassNotFoundException
    {
        return (boolean) receiveObject(socket);
    }

    public static char receiveChar(Socket socket) throws IOException, ClassNotFoundException
    {
        return (char) receiveObject(socket);
    }

    public static String receiveString(Socket socket) throws IOException, ClassNotFoundException
    {
        return (String) receiveObject(socket);
    }
}
