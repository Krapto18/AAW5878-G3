package pe.edu.upc.kidtd.dtos;

public class CumplimientoMetasDTO {
    private boolean status;
    private int total_metas;
    private double porcentaje;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal_metas() {
        return total_metas;
    }

    public void setTotal_metas(int total_metas) {
        this.total_metas = total_metas;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
