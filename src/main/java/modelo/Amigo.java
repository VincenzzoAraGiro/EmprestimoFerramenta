package modelo;

import java.util.ArrayList;
import dao.AmigoDAO;

public class Amigo extends Ferramenta{
    
    private String curso;
    private int fase;
    // Construtor de Objeto Vazio
    public Amigo(){
        this(0,"",0,"",0);
    }
    // Construtor com parâmetro
    public Amigo(int id,String nome, int idade, String curso, int fase){
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
    }
    // Métodos GET e SET
    public String getCurso(){
        return curso;
    }
    public void setCurso(String curso){
        this.curso = curso;
    }
    public int getFase(){
        return fase;
    }
    public void setFase(int fase){
        this.fase = fase;
    }
    
    @Override
    public String toString(){
        return super.toString() + "curso=" + curso + ",fase=" + fase;
    }
    
    /* ABAIXO OS MÉTODOS PARA USO JUNTO COM O DAO SIMULANDO A ESTRUTURA EM 
    CAMADAS PARA USAR COM BANCOS DE DADOS. */
    // Retorna a lista de Alunos(objetos)
    public ArrayList<Amigo> getMinhaLista() {
        return AmigoDAO.getMinhaLista();
    }

    
    // Cadastra novo aluno
    public boolean insertAmigoBD(String nome, int idade, String curso, int fase) {
        int id = this.maiorID() + 1;
        Amigo objeto = new Amigo(id, nome, idade,curso, fase);
        getMinhaLista().add(objeto);
    return true;
    }
    
    // Deleta um aluno específico pelo seu campo ID
    public boolean deleteAmigoBD(int id){
        int indice = this.procuraIndice(id);
        getMinhaLista().remove(indice);
        return true;
    }
    
    // Edita um aluno específico pelo seu campo ID
    public boolean updateAmigoBD(int id, String nome, int idade, String curso, int fase){
        Amigo objeto = new Amigo(id, nome, idade, curso, fase);
        int indice = this.procuraIndice(id);
        getMinhaLista().set(indice, objeto);
        return true;
    }
    // Procura o INDICE de objeto da minhaLista que contem o ID enviado
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < getMinhaLista().size(); i++) {
        if (getMinhaLista().get(i).getId() == id) {
            indice = i;
        }
    }
return indice;
}
    // Carrega dados de um amigo especifico pelo seu ID
    public Amigo carregaAmigo(int id){
        int indice = this.procuraIndice(id);
        return getMinhaLista().get(indice);
    }
    // Retorna o maior ID da nossa base de dados
    public int maiorID(){
        return AmigoDAO.maiorID();
    }
        

    
   
    
        
        
}
