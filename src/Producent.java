import java.util.Random;

public class Producent extends Thread
{
    private static int ile;
    private static Random r = new Random();
    private static Bufor buf;

    public void run()
    {
        for (int i = 0; i < ile; i++)
            {
                String elem = produkuj(i);
                try
                {
                    buf.wolne.acquire();
                    buf.chron_j.acquire();
                    buf.wstaw(elem);
                    buf.chron_j.release();
                    buf.zajete.release();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void setBuf(Bufor buf) {
        Producent.buf = buf;
    }

    public static void setIle(int ile)
    {
        Producent.ile = ile;
    }

    private String produkuj(int i)
    {
        try{sleep(r.nextInt(5) + 1);}
        catch(Exception e) {System.out.println(e.getMessage());}
        return new String(this.getName() + " : " + i + " : " + r.nextInt(100));
    }
}
