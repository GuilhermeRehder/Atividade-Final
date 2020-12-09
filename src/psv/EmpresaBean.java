//Classe para acesso ao objeto
package psv;

public class EmpresaBean {
    
    //Atributos da classe
    
    private int codEmpresa;
    private String NomeEmpresa;
    private String cnpj;
    private String razaoSocial;
   
    //Criando o construtores

    public EmpresaBean() {
    }
       
    //Criar os métodos getters e setters - alt+insert

    public EmpresaBean(int codEmpresa, String NomeEmpresa, String cnpj, String razaoSocial) {
        this.codEmpresa = codEmpresa;
        this.NomeEmpresa = NomeEmpresa;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public int getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNomeEmpresa() {
        return NomeEmpresa;
    }

    public void setNomeEmpresa(String NomeEmpresa) {
        this.NomeEmpresa = NomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

   
     
}
