package pe.edu.upc.kidtd.dtos;

public class CumplimientoRegistroSintomasDTO {
    private String mood_entry;
    private int cantidad;
    private double porcentaje;

    public String getMood_entry() {
        return mood_entry;
    }

    public void setMood_entry(String mood_entry) {
        this.mood_entry = mood_entry;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
