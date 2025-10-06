package pe.edu.upc.kidtd.dtos;

public class DiagnosticoProfesionalvsSistemaDTO {
    private int CantidadDiagnosticoProfesional;
    private int  CantidadPrediccionSistema;

    public int getCantidadDiagnosticoProfesional() {
        return CantidadDiagnosticoProfesional;
    }

    public void setCantidadDiagnosticoProfesional(int cantidadDiagnosticoProfesional) {
        CantidadDiagnosticoProfesional = cantidadDiagnosticoProfesional;
    }

    public int getCantidadPrediccionSistema() {
        return CantidadPrediccionSistema;
    }

    public void setCantidadPrediccionSistema(int cantidadPrediccionSistema) {
        CantidadPrediccionSistema = cantidadPrediccionSistema;
    }
}
