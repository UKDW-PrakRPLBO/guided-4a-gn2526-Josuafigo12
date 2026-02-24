package com.rplbo.projectrekeninginheritance;

    public class RekeningTambahan extends RekeningKeluarga {

        private final double BATAS_TARIK = 500000;
        private final double BIAYA_ADMIN = 5000;

        public RekeningTambahan(Nasabah nasabah, double saldo) {
            super(nasabah, saldo);
        }

        @Override
        public void tarik(double jumlah) {

            if (jumlah > BATAS_TARIK) {
                System.out.println("Melebihi batas penarikan Rekening Tambahan.");
                return;
            }

            double total = jumlah + BIAYA_ADMIN;

            if (saldo >= total) {
                saldo -= total;
            } else {
                System.out.println("Saldo tidak mencukupi.");
            }
        }

        @Override
        public void setor(double jumlah) {
            // Bunga 0.5%
            double bunga = jumlah * 0.005;
            saldo += jumlah + bunga;
        }
    }