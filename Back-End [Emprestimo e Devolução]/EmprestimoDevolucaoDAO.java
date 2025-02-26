package DAO;

import DTO.EmprestimoDevolucaoDTO;
import DTO.LivroDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author artur
 */
public class EmprestimoDevolucaoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<EmprestimoDevolucaoDTO> lista = new ArrayList<>();

    public void Emprestimo(EmprestimoDevolucaoDTO objEmprestimoDevolucaoDTO) {

        String sql = "insert into EmprestimoDevolucao (cliente_id, livro_id, dataEmprestimo, situacaoEmprestimo) values (?,?,?,?)";
        String sql2 = "select situacao from livro where id = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql2);
            pstm.setInt(1, objEmprestimoDevolucaoDTO.getLivro_id());
            rs = pstm.executeQuery();

            if (rs.next()) {

                String situacaoLivro = rs.getString("situacao");
                if ("Alugado".equals(situacaoLivro)) {
                    JOptionPane.showMessageDialog(null, "Este livro não está disponível.");

                } else {

                    rs.close();
                    pstm.close();

                    pstm = conn.prepareStatement(sql);

                    pstm.setInt(1, objEmprestimoDevolucaoDTO.getCliente_id());
                    pstm.setInt(2, objEmprestimoDevolucaoDTO.getLivro_id());
                    pstm.setString(3, objEmprestimoDevolucaoDTO.getDataEmprestimo());
                    pstm.setString(4, "Ativo");

                    pstm.execute();
                    pstm.close();

                    String updateSql = "update livro set situacao = ? where id = ?";
                    pstm = conn.prepareStatement(updateSql);
                    pstm.setString(1, "Alugado");
                    pstm.setInt(2, objEmprestimoDevolucaoDTO.getLivro_id());

                    pstm.execute();
                    pstm.close();

                }
            }
            
     
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "EmprestimoDevolucaoDAO Emprestimo: " + e);
        }

    }

    public void Devolucao(EmprestimoDevolucaoDTO objEmprestimoDevolucaoDTO) {

        String sql = "update EmprestimoDevolucao set situacaoEmprestimo = ? where id_emprestimo = ?";
        String sql2 = "select situacaoEmprestimo from EmprestimoDevolucao where id_emprestimo = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql2);
            pstm.setInt(1, objEmprestimoDevolucaoDTO.getId_emprestimo());
            rs = pstm.executeQuery();

            if (rs.next()) {

                String situacaoLivro = rs.getString("situacaoEmprestimo");
                if ("Finalizado".equals(situacaoLivro)) {
                    JOptionPane.showMessageDialog(null, "Este empréstimo já foi finalizado.");

                } else {

                    pstm = conn.prepareStatement(sql);

                    pstm.setString(1, "Finalizado");
                    pstm.setInt(2, objEmprestimoDevolucaoDTO.getId_emprestimo());

                    pstm.execute();
                    pstm.close();

                    String updateSql = "update livro set situacao = ? where id = ?";
                    pstm = conn.prepareStatement(updateSql);
                    pstm.setString(1, "Disponível");
                    pstm.setInt(2, objEmprestimoDevolucaoDTO.getLivro_id());

                    pstm.execute();
                    pstm.close();
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "EmprestimoDevolucaoDAO Devolucao: " + e);
        }

    }

    public ArrayList<EmprestimoDevolucaoDTO> pesquisarEmprestimoDevolucao() {

        String sql = "select * from EmprestimoDevolucao";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                EmprestimoDevolucaoDTO objEmprestimoDevolucaoDTO = new EmprestimoDevolucaoDTO();

                objEmprestimoDevolucaoDTO.setId_emprestimo(rs.getInt("id_emprestimo"));
                objEmprestimoDevolucaoDTO.setCliente_id(rs.getInt("cliente_id"));
                objEmprestimoDevolucaoDTO.setLivro_id(rs.getInt("livro_id"));
                objEmprestimoDevolucaoDTO.setDataEmprestimo(rs.getString("dataEmprestimo"));
                objEmprestimoDevolucaoDTO.setSituacaoEmprestimo(rs.getString("situacaoEmprestimo"));

                lista.add(objEmprestimoDevolucaoDTO);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "objEmprestimoDevolucaoDAO Pesquisar: " + e);
        }

        return lista;
    }

}
