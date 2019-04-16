import java.util.Random;

public class Konsument extends Thread
{
    private static int ile;
    private static Bufor buf;
    private static Random r = new Random();
    private static int m;
    private static int n;

    public void run()
    {
        for (int i = 0; i < (ile * m) / n; i++)
        {
            try
            {
                buf.zajete.acquire();
                buf.chron_k.acquire();
                String elem = buf.pobierz();
                buf.chron_k.release();
                buf.wolne.release();
                konsumuj(elem);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    private void konsumuj(String elem)
    {
        try{sleep(r.nextInt(4) + 2);}
        catch(Exception e) {System.out.println(e.getMessage());}
        System.out.println("[" + this.getName() + "]" + " => [" + elem + "]");
    }

    public static void setIle(int ile)
    {
        Konsument.ile = ile;
    }

    public static void setBuf(Bufor buf) {
        Konsument.buf = buf;
    }

    public static void setMN(int m, int n)
    {
        Konsument.m = m;
        Konsument.n = n;
    }
}
