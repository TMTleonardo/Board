package principal;

public class Tarea {
  private String nombreTarea;
  private String descripcion;
  private int prioridad;
  private String fechaLimite;

  public Tarea (String nombreTarea, String descripcion, int prioridad, String fechaLimite){
    this.nombreTarea = nombreTarea;
    this.descripcion = descripcion;
    this.prioridad = prioridad;
    this.fechaLimite = fechaLimite;
  }
  public String getNombreTarea(){
    return nombreTarea;
  }
   public String getDescripcion(){
    return descripcion;
  }
   public int getPrioridad(){
    return prioridad;
  }
  public String getFechaLimite(){
    return fechaLimite;
  }
  public void completarTarea(){
    System.out.println("Tarea'"+ nombreTarea +"'completada.");
  }
  public void modificarTarea(String nuevaDescripcion){
    this.descripcion= nuevaDescripcion;
    System.out.println("Tarea'"+ nombreTarea +"'modificada.")
  }
}
