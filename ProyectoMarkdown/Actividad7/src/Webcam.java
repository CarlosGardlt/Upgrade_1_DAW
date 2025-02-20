public class Webcam {
    private String resolucion;
    private int fps;
    private boolean esEncendido;
    private double tamanioArchivo;

    public Webcam(String resolucion, int fps) {
        this.resolucion = resolucion;
        this.fps = fps;
        esEncendido = false;
    }

    public void encender() {
        System.out.println("Has encendido la webcam");
        esEncendido = true;
    }

    public void apagar() {
        System.out.println("Has apagado la webcam");
        esEncendido = false;
    }


    public void tomarFoto() {
        if (esEncendido) {
            var alto = 0;
            var ancho = 0;
            try {
                alto = Integer.parseInt(resolucion.substring(0, resolucion.indexOf("x")));
                ancho = Integer.parseInt(resolucion.substring(resolucion.indexOf("x") + 1));
            } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Error al tomar foto, la resolucion no es correcta");
                return;
            }
            tamanioArchivo = (ancho * alto * fps) / 1000000.0;
            System.out.println("Tomando foto con la resolucion " + resolucion + " y el tamaño estimado es " + tamanioArchivo);
        } else {
            System.out.println("Debes encender la webcam antes de tomar una foto");
        }
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public boolean isEsEncendido() {
        return esEncendido;
    }

    public void setEsEncendido(boolean esEncendido) {
        this.esEncendido = esEncendido;
    }

    public double isTamanioArchivo() {
        return tamanioArchivo;
    }

    public void setTamanioArchivo(double tamanioArchivo) {
        this.tamanioArchivo = tamanioArchivo;
    }
}
