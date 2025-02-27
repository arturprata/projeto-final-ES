package DAO;

import DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ClienteDTO> lista = new ArrayList<>();

    public void cadastrarCliente(ClienteDTO objClienteDTO) {

        String sql = "insert into Cliente (nome_cliente, cpf_cliente, email_cliente, telefone_cliente) values (?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, objClienteDTO.getNome_cliente());
            pstm.setString(2, objClienteDTO.getCpf_cliente());
            pstm.setString(3, objClienteDTO.getEmail_cliente());
            pstm.setString(4, objClienteDTO.getTelefone_cliente());

            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ClienteDAO Cadastrar: " + e);
        }

    }

    public ArrayList<ClienteDTO> pesquisarCliente() {

        String sql = "select * from cliente";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ClienteDTO objClienteDTO = new ClienteDTO();

                objClienteDTO.setId_cliente(rs.getInt("id_cliente"));
                objClienteDTO.setNome_cliente(rs.getString("nome_cliente"));
                objClienteDTO.setCpf_cliente(rs.getString("cpf_cliente"));
                objClienteDTO.setEmail_cliente(rs.getString("email_cliente"));
                objClienteDTO.setTelefone_cliente(rs.getString("telefone_cliente"));

                lista.add(objClienteDTO);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ClienteDAO Pesquisar: " + e);
        }

        return lista;
    }

    public void alterarCliente(ClienteDTO objClienteDTO) {

        String sql = "update cliente set nome_cliente = ?, cpf_cliente = ?, email_cliente = ?, telefone_cliente = ? where id_cliente = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, objClienteDTO.getNome_cliente());
            pstm.setString(2, objClienteDTO.getCpf_cliente());
            pstm.setString(3, objClienteDTO.getEmail_cliente());
            pstm.setString(4, objClienteDTO.getTelefone_cliente());
            pstm.setInt(5, objClienteDTO.getId_cliente());

            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ClienteDAO Alterar: " + e);
        }
        
    }
    
    public void excluirCliente(ClienteDTO objClienteDTO) {

        String sql = "delete from cliente where id_cliente = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, objClienteDTO.getId_cliente());
            
            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ClienteDAO Excluir: " + e);
        }
        
    }

}
