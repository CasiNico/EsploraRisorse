import java.io.File;

public class EsploraRisorse {
    private File cartellaCorrente;

    public EsploraRisorse(String cartellaCorrente){
        this.cartellaCorrente = new File(cartellaCorrente);
    }

    public String getAbsolutePath(){
        return cartellaCorrente.getAbsolutePath();
    }

    public String stampaPercorso(){
        String s = "";
        File[] lista = null;
        if(cartellaCorrente.exists()){
            lista = cartellaCorrente.listFiles();
            for(File file : lista){
                s +=  "   ";
                if(file.isDirectory()){
                    s += "[DIR]\n";
                }else{
                    s += "[FILE]";
                }
            }
        }
        s += "percorso non valido";
        return s;
    }

    public boolean entraInSottodirectory(String sottoCartella){
        File[] listaFile = cartellaCorrente.listFiles();
        for(File file : listaFile){
            if(file.getName().equalsIgnoreCase(sottoCartella) && file.isDirectory()){
                cartellaCorrente = file;
                return true;
            }
        }
        return false;
    }

    public void tornaACartellaPrecedente(){
        cartellaCorrente = cartellaCorrente.getParentFile();
    }
    public void creaNuovoFile(String nomeFile){
        new File(cartellaCorrente, nomeFile);
    }
    public void creaNuovaCartella(String nomeCartella){
        File cartella = new File(nomeCartella);
        cartella.mkdir();
    }
    public boolean eliminaFile(String nomeFile){
        File[] listaFile = cartellaCorrente.listFiles();
        for(File file : listaFile){
            if(file.getName() == nomeFile && !file.isDirectory());
            file.delete();
            return true;
        }
        return false;
    }
    public boolean eliminaCartella(String nomeCartella){
        File[] listaFile = cartellaCorrente.listFiles();
        for(File file : listaFile){
            if(file.getName() == nomeCartella && file.isDirectory());
            file.delete();
            return true;
        }
        return false;
    }
}
