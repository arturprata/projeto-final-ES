package DTO;

public class EmprestimoDevolucaoDTO {

    private int id_emprestimo;
    private int cliente_id;
    private int livro_id;
    private String dataEmprestimo;
    private String situacaoEmprestimo;
    
    /**
     * @return the id_emprestimo
     */
    public int getId_emprestimo() {
        return id_emprestimo;
    }

    /**
     * @param id_emprestimo the id_emprestimo to set
     */
    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    /**
     * @return the cliente_id
     */
    public int getCliente_id() {
        return cliente_id;
    }

    /**
     * @param cliente_id the cliente_id to set
     */
    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    /**
     * @return the livro_id
     */
    public int getLivro_id() {
        return livro_id;
    }

    /**
     * @param livro_id the livro_id to set
     */
    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    /**
     * @return the dataEmprestimo
     */
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * @param dataEmprestimo the dataEmprestimo to set
     */
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * @return the situacaoEmprestimo
     */
    public String getSituacaoEmprestimo() {
        return situacaoEmprestimo;
    }

    /**
     * @param situacaoEmprestimo the situacaoEmprestimo to set
     */
    public void setSituacaoEmprestimo(String situacaoEmprestimo) {
        this.situacaoEmprestimo = situacaoEmprestimo;
    }
    
    
}
