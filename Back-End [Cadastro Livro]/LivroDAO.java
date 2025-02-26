package DAO;

import DTO.LivroDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LivroDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LivroDTO> lista = new ArrayList<>();

    public void cadastrarLivro(LivroDTO objLivroDto) {

        String sql = "insert into Livro (titulo, autor, editora, dataRecebimento, situacao) values (?,?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, objLivroDto.getTitulo());
            pstm.setString(2, objLivroDto.getAutor());
            pstm.setString(3, objLivroDto.getEditora());
            pstm.setString(4, objLivroDto.getDataRecebimento());
            pstm.setString(5, objLivroDto.getSituacao());

            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "LivroDAO Cadastrar: " + e);
        }

    }

    public ArrayList<LivroDTO> pesquisarLivro() {

        String sql = "select * from livro";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                LivroDTO objLivroDTO = new LivroDTO();

                objLivroDTO.setId_livro(rs.getInt("id"));
                objLivroDTO.setTitulo(rs.getString("titulo"));
                objLivroDTO.setAutor(rs.getString("autor"));
                objLivroDTO.setEditora(rs.getString("editora"));
                objLivroDTO.setDataRecebimento(rs.getString("dataRecebimento"));
                objLivroDTO.setSituacao(rs.getString("situacao"));

                lista.add(objLivroDTO);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "LivroDAO Pesquisar: " + e);
        }

        return lista;
    }

    public void alterarLivro(LivroDTO objLivroDTO) {

        String sql = "update livro set titulo = ?, autor = ?, editora = ?, dataRecebimento = ?, situacao = ? where id = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, objLivroDTO.getTitulo());
            pstm.setString(2, objLivroDTO.getAutor());
            pstm.setString(3, objLivroDTO.getEditora());
            pstm.setString(4, objLivroDTO.getDataRecebimento());
            pstm.setString(5, objLivroDTO.getSituacao());
            pstm.setInt(6, objLivroDTO.getId_livro());

            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "LivroDAO Alterar: " + e);
        }
        
    }
    
    public void excluirLivro(LivroDTO objLivroDTO) {

        String sql = "delete from livro where id = ?";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, objLivroDTO.getId_livro());
            
            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "LivroDAO Excluir: " + e);
        }
        
    }
    
}
