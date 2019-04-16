public class Test 
{
    private static final int ile = 100;
    private static final int rozmiar = 10;
    private static final int m = 100;
    private static final int n = 80;
    
    public static void main(String[] args) 
    {
        Producent[] prod = new Producent[m];
        Konsument[] kons = new Konsument[n];
        Bufor buf = new Bufor(rozmiar);
        Producent.setIle(ile);
        Konsument.setIle(ile);
        Producent.setBuf(buf);
        Konsument.setBuf(buf);
        Konsument.setMN(m,n);

        for (int i = 0; i < m; i++)
        {
            prod[i] = new Producent();
            prod[i].setName("P - " + i);
        }
        for (int i = 0; i < n; i++)
        {
            kons[i] = new Konsument();
            kons[i].setName("K - " + i);
        }

        for (int i = 0; i < m; i++)
        {
            prod[i].start();
        }

        for (int i = 0; i < n; i++)
        {
            kons[i].start();
        }

        try
        {
            for (int i = 0; i < m; i++)
            {
                prod[i].join();
            }
            for (int i = 0; i < n; i++)
            {
                kons[i].join();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
