package pe.edu.upc.kidtd.dtos;

public class ActGoalDurationDTO {
    public int userId;
    public int total_metas_activas;
    public String promedio_duracion_dias;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotal_metas_activas() {
        return total_metas_activas;
    }

    public void setTotal_metas_activas(int total_metas_activas) {
        this.total_metas_activas = total_metas_activas;
    }

    public String getPromedio_duracion_dias() {
        return promedio_duracion_dias;
    }

    public void setPromedio_duracion_dias(String promedio_duracion_dias) {
        this.promedio_duracion_dias = promedio_duracion_dias;
    }
}
