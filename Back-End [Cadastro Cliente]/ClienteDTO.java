package DTO;

public class ClienteDTO {
    
    private String nome_cliente, cpf_cliente, email_cliente, telefone_cliente;
    private int id_cliente;

    /**
     * @return the nome_cliente
     */
    public String getNome_cliente() {
        return nome_cliente;
    }

    /**
     * @param nome_cliente the nome_cliente to set
     */
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    /**
     * @return the cpf_cliente
     */
    public String getCpf_cliente() {
        return cpf_cliente;
    }

    /**
     * @param cpf_cliente the cpf_cliente to set
     */
    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    /**
     * @return the email_cliente
     */
    public String getEmail_cliente() {
        return email_cliente;
    }

    /**
     * @param email_cliente the email_cliente to set
     */
    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    /**
     * @return the telefone_cliente
     */
    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    /**
     * @param telefone_cliente the telefone_cliente to set
     */
    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_cliente
     */   
}
