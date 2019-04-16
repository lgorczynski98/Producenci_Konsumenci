import java.util.concurrent.Semaphore;

public class Bufor
{
    private String[] buf;
    private int j;
    private int k;
    public Semaphore wolne;
    public Semaphore zajete;
    public Semaphore chron_j;
    public Semaphore chron_k;

    public Bufor(int rozmiar)
    {
        buf = new String[rozmiar];
        wolne = new Semaphore(buf.length);
        zajete = new Semaphore(0);
        chron_j = new Semaphore(1);
        chron_k = new Semaphore(1);
        j = 1;
        k = 1;
    }

    public void wstaw(String elem)
    {
        buf[j] = elem;
        j = (j + 1) % buf.length;
    }

    public String pobierz()
    {
        String elem = buf[k];
        k = (k  +1) % buf.length;
        return elem;
    }
}
