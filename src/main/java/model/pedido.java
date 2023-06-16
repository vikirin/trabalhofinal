package model;

public class pedido {
    private String tamanho;
    private String sabor;
    private Float valortotal;
    private Long idPedido;
    private String bebida;
    private String nomeCliente;

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Float getValortotal() {
        return valortotal;
    }

    public void setValortotal(Float valortotal) {
        this.valortotal = valortotal;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getBebida() {return bebida;}

    public void setBebida(String bebida) {this.bebida = bebida;}

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public pedido(String tamanho, String sabor, Float valortotal, Long idPedido, String bebida, String nomeCliente) {
        this.tamanho = tamanho;
        this.sabor = sabor;
        this.valortotal = valortotal;
        this.idPedido = idPedido;
        this.bebida = bebida;
        this.nomeCliente = nomeCliente;
    }

    public pedido() {
    }
}
