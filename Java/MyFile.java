//PUT package here

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Oriol HT <oriolholguint@gmail.com>
 */
public class MyFile 
{
    public static void sendFile(Socket socket, String filePath)
    {
        try
        {
            FileInputStream fis = new FileInputStream(filePath);
                    
            Path path = Paths.get(filePath);
            long sizeFile = Files.size(path);
            
            //Envia cantidad de bytes del fichero
            TransferData.sendLong(socket, sizeFile);
            
            int character = fis.read();
            
            while(character != -1)
            {
                TransferData.sendInteger(socket, character);
                character = fis.read();
            }
            
            System.out.println("Se ha enviado el archivo: " + new File(filePath).getName());
            
            fis.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
    }
    
    public static void getFile(Socket socket, String filePath, boolean showStatus)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(filePath);
                        
            int counter = 1;
            //Recibe numero de bytes del fichero
            long numBytes = TransferData.receiveLong(socket);
                
            int character = TransferData.receiveInteger(socket);
          
            while(character != -1)
            {
                fos.write(character);
                if(counter != numBytes)
                {
                    character = TransferData.receiveInteger(socket);
                }
                else
                {
                    character = -1;
                }
                
                if(showStatus)
                {
                    System.out.println(counter + "/" + numBytes);
                    counter++;
                }
            }
            
            if(new File(filePath).exists())
            {
                System.out.println("Nuevo archivo recibido: " + new File(filePath).getName());
            }
            
            fos.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) 
        {
            System.out.println(ex.toString());
        }
    }    
}
