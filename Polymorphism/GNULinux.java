public class GNULinux extends OperatingSystem {
 
    protected float versionKernel;
 
    public GNULinux(String name, float version, String platform, float versionKernel) {
        super(name,version,platform);
        this.versionKernel = versionKernel;
    }
 
    protected void compileKernel(float versionKernel) {
        if(versionKernel <= this.versionKernel) {
            System.out.println("\n\t\tLa versión del Kernel debe ser más actualizada!!!");
        } else {
            this.versionKernel = versionKernel;
            System.out.println("El kernel ha sido compilado con éxito!");
        }
    }
 
    public void updateOS() {
        if(version == 3.0) {
            version += 0.1;
        }
        if(version == 3.1) {
            version += 0.1;
        }
        if(version == 3.2) {
            version += 0.1;
        }
        if(version == 3.3) {
            version += 0.1;
        }
        if(version == 3.4) {
            version += 0.1;
        }
        if(version == 3.5) {
            version += 0.1;
        }
        if(version == 3.6) {
            version += 0.1;
        }
        if(version == 3.7) {
            version += 0.1;
        }
        if(version == 3.8) {
            version += 0.1;
        }
        if(version == 3.9) {
            version += 0.1;
        }
    }
}
