//Classe para acesso ao objeto
package psv;

public class ClienteBean {
    
    //Atributos da classe
    
    private int id;
    private String nome;
    private String telResidencial;
    private String telComercial;
    private String telCelular;
    private String email;
    
    //Criando o construtores

    public ClienteBean() {
    }

    public ClienteBean(int id, String nome, String telResidencial, String telComercial, String telCelular, String email) {
        this.id = id;
        this.nome = nome;
        this.telResidencial = telResidencial;
        this.telComercial = telComercial;
        this.telCelular = telCelular;
        this.email = email;
    }
       
    //Criar os métodos getters e setters - alt+insert

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelResidencial() {
        return telResidencial;
    }

    public void setTelResidencial(String telResidencial) {
        this.telResidencial = telResidencial;
    }

    public String getTelComercial() {
        return telComercial;
    }

    public void setTelComercial(String telComercial) {
        this.telComercial = telComercial;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
