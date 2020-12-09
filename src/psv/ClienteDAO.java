//Classe de acesso aos dados (SQL com Java)
package psv;

import java.sql.*;
import java.util.*;

public class ClienteDAO {

    //Variavel para acesso a conexao (abrir e fechar o bd)
    private Connection con;

    //Criando o construtor da classe
    public ClienteDAO(Connection con) {
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
    public String inserirCliente(ClienteBean cliente) {

        String sql = "insert into tbcliente(nome, telresidencial, telcomercial, telcelular, email) values(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            //Inserir os valores do java no sql
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelResidencial());
            ps.setString(3, cliente.getTelComercial());
            ps.setString(4, cliente.getTelCelular());
            ps.setString(5, cliente.getEmail());


            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir.";
            }

        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }

    //Criar o método update
    public String alterarCliente(ClienteBean cliente) {

        //Alterando os registros inseridos no bd
        String sql = "update tbcliente set nome = ?, telresidencial = ?, telcomercial = ?, telcelular = ?, email = ? where id = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelResidencial());
            ps.setString(3, cliente.getTelComercial());
            ps.setString(4, cliente.getTelCelular());
            ps.setString(5, cliente.getEmail());
            ps.setInt(6, cliente.getId());
            

            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso.";
            } else {
                return "Erro ao alterar.";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }

    }

    //Criar método delete
    public String excluirCliente(ClienteBean cliente) {

        String sql = "delete from tbcliente where id = ?";

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setInt(1, cliente.getId());

            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            } else {
                return "Erro ao excluir.";
            }

        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }

    //Criar o select
    public List<ClienteBean> listarTodos() {

        String sql = "select * from tbcliente";

        //Criando um vetor ou matriz vazia para carregar os valores do bd
        List<ClienteBean> listaClientes = new ArrayList<>();

        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    ClienteBean cb = new ClienteBean();
                    
                    cb.setId(rs.getInt(1));
                    cb.setNome(rs.getString(2));
                    cb.setTelResidencial(rs.getString(3));
                    cb.setTelComercial(rs.getString(4));
                    cb.setTelCelular(rs.getString(5));
                    cb.setEmail(rs.getString(6));
                    

                    listaClientes.add(cb);
                }
                return listaClientes;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            return null;
        }

    }

    /*
    public boolean validarCliente(ClienteBean cliente) {

        String sql = "SELECT * FROM tbcliente WHERE email = ? and senha = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, cliente.getEmail());
            ps.setString(2, cliente.getSenha());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean verificarAdministrador(ClienteBean cliente) {
        
        String sql = "SELECT * FROM tbcliente WHERE email = ? and senha = ? and administrador = ?";

        try {

            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, cliente.getEmail());
            ps.setString(2, cliente.getSenha());
            ps.setBoolean(3, true);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            return false;
        }
    }
    */
    
}
