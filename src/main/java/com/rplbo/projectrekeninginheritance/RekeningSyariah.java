import com.rplbo.projectrekeninginheritance.Nasabah;

public class RekeningSyariah extends Rekening {

    public RekeningSyariah(Nasabah nasabah, double saldo) {
        super(nasabah, saldo);
    }

    @Override
    public void setor(double jumlah) {
        // Tidak mendapatkan bunga
        saldo += jumlah;
    }

    @Override
    public void tarik(double jumlah) {
        double biayaAdmin = 0;

        if (jumlah > 100000) {
            biayaAdmin = 1000;
        }

        double total = jumlah + biayaAdmin;

        if (saldo >= total) {
            saldo -= total;
        } else {
            System.out.println("Saldo tidak mencukupi untuk penarikan.");
        }
    }

    public void sedekah(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
        } else {
            System.out.println("Saldo tidak mencukupi untuk sedekah.");
        }
    }
}