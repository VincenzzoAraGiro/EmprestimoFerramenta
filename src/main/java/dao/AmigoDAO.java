package dao;
import java.util.ArrayList;
import modelo.Amigo;

/**
 * Aqui vamos simular a persistência de dados
 */
public class AmigoDAO {
    
    public static ArrayList<Amigo>minhaLista = new ArrayList<>();
    
    public static ArrayList<Amigo>getMinhaLista(){
        return minhaLista;
    }
    public static void setMinhaLista(ArrayList<Amigo>minhaLista){
        AmigoDAO.minhaLista = minhaLista;
    }
    public static int maioID(){
        int maiorID = 0;
        for(int i = 0; i < minhaLista.size(); i++){
            if(minhaLista.get(i).getID()>maiorID){
                maiorID = minhalista.get(i).getID();
            }
        }
        return maiorID;
    }
}
