import java.net.*; 
import java.io.*; 

public class Client {
  
    public static void main(String[] args) { 
        if(args.length == 0) { 
            System.out.println("Usage : Client <serverName>"); 
            return; 
        } 
       
        Socket s = null; 
        
        try { 
            s = new Socket(args[0], 11111); 
        }        
        catch(UnknownHostException uhe) { 
            System.out.println("Unknown Host :" + args[0]); 
            s = null; 
        } 
        catch(IOException ioe) { 
            System.out.println("Cant connect to server at 11111. Make sure it is running."); 
            s = null; 
        } 
        
        if(s == null) 
            System.exit(-1); 
        
        BufferedReader in = null; 
        PrintWriter out = null; 
        
        try { 
            in = new BufferedReader(new InputStreamReader(s.getInputStream())); 
            out = new PrintWriter(new OutputStreamWriter(s.getOutputStream())); 
            
            out.println("What is going on Server?"); 
            out.flush(); 
            System.out.println(in.readLine()); 
            
            out.println("Quit"); 
            out.flush(); 
        } 
        catch(IOException ioe) { 
            System.out.println("Exception during communication. Server probably closed connection."); 
        } 
        finally { 
            try { 
                out.close(); 
                in.close(); 
                s.close(); 
            } 
            catch(Exception e) { 
                e.printStackTrace(); 
            }                
        }        
    } 
}
