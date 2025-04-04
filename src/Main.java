import java.io.File;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Working directory: ");
        EsploraRisorse e = new EsploraRisorse(in.next());
        while(true){
            System.out.print(e.getAbsolutePath() + " > ");
            String azione = in.next();
            switch(azione){
                case "dir":
                    System.out.println(e.stampaPercorso());
                    break;
                case "cd":
                    if(!e.entraInSottodirectory(in.next()))
                        System.out.println("Errore");
                    break;
                case "cd..":
                    e.tornaACartellaPrecedente();
                    break;
                case "echo > ":
                    e.creaNuovoFile(in.next());
                    break;
                case "mkdir ":
                    e.creaNuovaCartella(in.next());
                    break;
                case "rm ":
                    if(!e.eliminaFile(in.next()))
                        System.out.println("Errore");
                    break;
                case "rmdir ":
                    if(!e.eliminaCartella(in.next()))
                        System.out.println("Errore");
                    break;
                case "?":
                    System.out.println("dir: mostra contenuto cartella\n" +
                            "cd: entra in sotto-directory\n" +
                            "cd..: torna a cartella padre\n" +
                            "echo > : crea file\n" +
                            "mkdir : crea directory\n" +
                            "rm : elimina file\n" +
                            "rmdir : elimina directory");
                    break;
                default:
                    System.out.println("Premi ? per conoscere i comandi");
            }
        }
    }
}