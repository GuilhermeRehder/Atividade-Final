//Classe de acesso aos dados (SQL com Java)
package psv;

import java.sql.*;

public class EmpresaDAO {

    //Variavel para acesso a conexao (abrir e fechar o bd)
    private Connection con;

    //Criando o construtor da classe
    public EmpresaDAO(Connection con) {
        this.con = con;
    }

    //Criando os métodos de acesso (getters e setters)
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //Criar o método insert 
    public String inserirEmpresa(EmpresaBean empresa) {

        String sql = "insert into tbempresa(nomeEmpresa, cnpj, razaoSocial) values(?, ?, ?)";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            //Inserir os valores do java no sql
            ps.setString(1, empresa.getNomeEmpresa());
            ps.setString(2, empresa.getCnpj());
            ps.setString(3, empresa.getRazaoSocial());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir.";
            }

        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }

    //Criar método delete
    public String excluirEmpresa(EmpresaBean empresa) {

        String sql = "delete from tbempresa where placa = ?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setInt(1, empresa.getCodEmpresa());

            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            } else {
                return "Erro ao excluir.";
            }

        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
}
