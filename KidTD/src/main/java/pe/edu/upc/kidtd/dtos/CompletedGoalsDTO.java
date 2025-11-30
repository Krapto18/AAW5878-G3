package pe.edu.upc.kidtd.dtos;

public class CompletedGoalsDTO {
    public int userId;
    public String username;
    public int metas_completadas;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMetas_completadas() {
        return metas_completadas;
    }

    public void setMetas_completadas(int metas_completadas) {
        this.metas_completadas = metas_completadas;
    }
}
