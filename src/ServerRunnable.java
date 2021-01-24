
import java.net.*;
import java.io.*;
import java.util.*;

public class ServerRunnable extends Thread{

    private Socket socket;
    ////////////////////////////////

    ////////////////////////////////
    public ServerRunnable(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            DBManager manager = new DBManager();
            manager.connect();
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream toClient =  new ObjectOutputStream(socket.getOutputStream());


            PackageData pd = null;
            while((pd = (PackageData) inStream.readObject())!=null) {
                String s = "";

                if(pd.operationType.equals("ADD")){
                    Student serverList = pd.student;
                    manager.addStudent(serverList);

                }
                else if(pd.operationType.equals("LIST")){
                    PackageData client = null;
                    System.out.println(pd.operationType);
                    ArrayList<Student> students = manager.getStudents();
                    client = new PackageData(students);
                    String st ="";
                    for(int i=0;i<students.size();i++){
                        st+=students.get(i).toString()+"\n";
                    }
                    System.out.println(st);
                    toClient.writeObject(client);
                }
            }


            inStream.close();
            toClient.close();
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}

