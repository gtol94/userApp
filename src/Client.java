import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    public static void connect(PackageData pd) {
        try{
            Socket socket = new Socket("127.0.0.1", 1212);
            ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            if(pd.operationType.equals("ADD")){
                toServer.writeObject(pd);

            }else if(pd.operationType.equals("LIST")){
                toServer.writeObject(pd);
                PackageData from = (PackageData) inputStream.readObject();
                ArrayList<Student> students = from.students;
                String s = "";
                for(int i=0; i < students.size(); i++){
                    s += students.get(i) + "\n";
                }
                ListStudent.text.append(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
