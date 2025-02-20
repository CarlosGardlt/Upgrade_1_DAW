public class Webcam {

        private String resolucion;
        private int fps;
        private boolean encendida;
        private double tamanioArchivo;

        public Webcam(String resolucion, int fps, boolean encendida, double tamanioArchivo) {
            this.resolucion = resolucion;
            this.fps = fps;
            this.encendida = encendida;
            this.tamanioArchivo = tamanioArchivo;
        }

        public void encender() {
            encendida = true;
        }

        public void apagar() {
            encendida = false;
        }

        public void tomarFoto() {
            if (encendida) {
                var alto = 0;
                var ancho = 0;   
                try {
                    alto = Integer.parseInt(resolucion.split("x")[0]);
                    ancho = Integer.parseInt(resolucion.split("x")[1]);
                } catch (Exception e) {
                    System.out.println("Error al obtener la resolución de la cámara");
                }
                tamanioArchivo = (ancho * alto * fps) / 1000000.0;
                System.out.println("Foto tomada con una resolución de "+ resolucion +  "y un tamaño de archivo de " + tamanioArchivo);
            } else {
                System.out.println("La cámara no está encendida");
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

        public boolean isEncendida() {
            return encendida;
        }

        public void setEncendida (boolean encendida) {
            this.encendida = encendida;
        }

        public double getTamanioArchivo() {
            return tamanioArchivo;
        }

        public void setTamanioArchivo(double tamanioArchivo) {
            this.tamanioArchivo = tamanioArchivo;
        }
}