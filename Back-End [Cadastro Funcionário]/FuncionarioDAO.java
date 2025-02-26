package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class FuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO> lista = new ArrayList<>();
    
    public ResultSet autenticacaoUsuario(FuncionarioDTO objFuncionarioDTO){
    
        conn = new ConexaoDAO().conectaBD();
        
        try {
        
            String sql = "select * from funcionario where cpf_funcionario = ? and senha_funcionario = ?";
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, objFuncionarioDTO.getCpf_funcionario());
            pstm.setString(2, objFuncionarioDTO.getSenha_funcionario());
            
            ResultSet rs = pstm.executeQuery();
            
            return rs;
        } 
        
        catch (SQLException e) {
        
            JOptionPane.showMessageDialog(null, "AutenticacaoDAO" + e);
            return null;
        }
    
    }
    
    public void cadastrarFuncionario(FuncionarioDTO objFuncionarioDto){
    
        String sql = "insert into Funcionario (nome_funcionario, cpf_funcionario, email_funcionario, telefone_funcionario, cargo, senha_funcionario) values (?,?,?,?,?,?)";
        
        conn = new ConexaoDAO().conectaBD();
        
        try{
        
                pstm = conn.prepareStatement(sql);
                
                pstm.setString(1, objFuncionarioDto.getNome_funcionario());
                pstm.setString(2, objFuncionarioDto.getCpf_funcionario());
                pstm.setString(3, objFuncionarioDto.getEmail_funcionario());
                pstm.setString(4, objFuncionarioDto.getTelefone_funcionario());
                pstm.setString(5, objFuncionarioDto.getCargo());
                pstm.setString(6, objFuncionarioDto.getSenha_funcionario());
                
                pstm.execute();
                pstm.close();
            
        }
        
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Cadastrar: " + e);
        }
    
    }
    
    public ArrayList<FuncionarioDTO> pesquisarFuncionario() {

        String sql = "select * from funcionario";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();

                objFuncionarioDTO.setId_funcionario(rs.getInt("id_funcionario"));
                objFuncionarioDTO.setNome_funcionario(rs.getString("nome_funcionario"));
                objFuncionarioDTO.setCpf_funcionario(rs.getString("cpf_funcionario"));
                objFuncionarioDTO.setEmail_funcionario(rs.getString("email_funcionario"));
                objFuncionarioDTO.setTelefone_funcionario(rs.getString("telefone_funcionario"));
                objFuncionarioDTO.setCargo(rs.getString("cargo"));
                objFuncionarioDTO.setSenha_funcionario(rs.getString("senha_funcionario"));

                lista.add(objFuncionarioDTO);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Pesquisar: " + e);
        }

        return lista;
    }

    public void alterarFuncionario(FuncionarioDTO objFuncionarioDTO) {

        String sql = "update funcionario set nome_funcionario = ?, cpf_funcionario = ?, email_funcionario = ?, telefone_funcionario = ?, cargo = ?, senha_funcionario = ? where id_funcionario = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, objFuncionarioDTO.getNome_funcionario());
            pstm.setString(2, objFuncionarioDTO.getCpf_funcionario());
            pstm.setString(3, objFuncionarioDTO.getEmail_funcionario());
            pstm.setString(4, objFuncionarioDTO.getTelefone_funcionario());
            pstm.setString(5, objFuncionarioDTO.getCargo());
            pstm.setString(6, objFuncionarioDTO.getSenha_funcionario());
            pstm.setInt(7, objFuncionarioDTO.getId_funcionario());

            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Alterar: " + e);
        }
        
    }
    
    public void excluirFuncionario(FuncionarioDTO objFuncionarioDTO) {

        String sql = "delete from funcionario where id_funcionario = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, objFuncionarioDTO.getId_funcionario());
            
            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Excluir: " + e);
        }
        
    }
    
    
}
