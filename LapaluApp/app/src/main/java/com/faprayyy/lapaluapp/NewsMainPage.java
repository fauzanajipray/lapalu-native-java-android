package com.faprayyy.lapaluapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class NewsMainPage extends AppCompatActivity {

    List<News> firstNews1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main_page);

        firstNews1 = new ArrayList<>();
        firstNews1.add(new News("BPBD BATANG: SELAIN BANJIR, SATU RUMAH ROBOH DAN JEMBATAN PENGHUBUNG ANTAR DESA PUTUS","Categorie Novel","Batang - Ketua Pelaksana BPBD Kabupaten Batang, Ulul Azmi, mengatakan ada empat titik lokasi banjir di Kota Batang  yaitu Kelurahan Karangasem utara, Desa Karanganyar, Desa Kalipucang Wetan dan Desa Klidang Lor.\n" +
                "“Dukuh Kutosari Kelurahan Karangasem Utara menjadi titik banjir paling parah, sampai saat ini ketinggian air 40 cm dan di Klidang Lor 30 cm,” kata Kepala BPBD Kabupaten Batang Ulul Azmi usai meninjau banjir di Dukuh Kutosari, Kecamatan Batang, Kabupaten Batang, Selasa (19/1/2021).\n" +
                "Dijelaskannya, sejak tadi malam relawan BPBD sudah melakukan evakuasi warga ke tempat yang lebih aman.\n" +
                "“Warga ada yang divakuasi ketempat saudaranya dan ada yang di Masjid Al Ikhlas, kita lakukan evakuasi sampai pukul 04.00 WIB dengan menggunakan perahu karet yang ada di Kelurahan Karangasem Utara sebanyak 3 buah dan  perahu karet milik BPBD mengevakuasi warga  di  desa Klidang Lor,” jelasnya.\n" +
                "Tidak hanya itu, bencana banjir juga mengakibatkan putusnya jembatan penghubung antar Desa Wonodadi Pesalakan Kecamatan Bandar.\n",R.drawable.banjirkompor));

        firstNews1.add(new News("DIRENDAM BANJIR, PEMKAB BATANG HADIR MEMBANTU DENGAN LAYANAN KESEHATAN DAN DAPUR UMUM","Categorie Novel","Pada musim hujan kali ini membuat beberapa wilayah Indonesia Banjir termasuk di Kabupaten Batang di Dukuh Kutosari Kelurahan Karangasem Utara, Kecamatan Batang.\n" +
                "“Hujan mulai dini hari Senin tanggal 18 Januari 2021 sampai sore, menjelang malam sudah agak reda, tetapi malamnya kembali diguyur deras sampai tengah malam. Keadaan semalam cukup parah karena air sampai pinggang dewasa,” kata Ketua RT Dukuh Kutosari Eko Prayoto saat ditemui di  Dukuh Kutosari, Kecamatan Batang, Kabupaten Batang, Selasa (19/1/2021).\n" +
                "“Tindakan dari pengurus RT semalam adalah memidahkan warga yang rumahnya cukup rendah ke warga yang rumahnya yang mempunyai lantai dua atau yang lebih tinggi,” jelasnya.\n" +
                "Sementara, Bupati Batang Wihaji mengatakan, hari ini ada empat titik banjir hasil laporan dari BPBD Kabupaten Batang. Kondisi yang masih lumayan parah pada dukuh Kutosari.\n" +
                "“Pemerintah Kabupaten Batang hadir membantu di tengah warga yang mengalami musibah, maka harus segera dilakukan layanan kesehatan pada warga terdampak banjir dan BPBD Kabupaten Batang segera membuka dapur umum agar warga dapat bisa makan,” terangnya.\n",R.drawable.banjirbatang));

        firstNews1.add(new News("BUPATI BATANG, BERIKAN BANTUAN RTLH KEPADA WARGA TIDAK MAMPU","Categorie Novel","Pemerintah Kabupaten Batang mengalokasikan anggaran untuk program Rumah Tidak Layak Huni (RTLH) di tahun 2021 sebesar Rp3,5 miliar.\n" +
                "Dari anggaran sebesar itu, rencananya ada sekitar 280 unit rumah yang akan mendapatkan program RTLH dengan besaran bantuan per unit Rp12,5 juta.\n" +
                "Hal tersebut disampaikan Bupati Batang Wihaji saat tilik warga di Desa Karangtengah, Kecamatan Subah, Kabupaten Batang, Senin (18/1/2021).\n" +
                "“Di tahun ini, pasangan suami istri Wayan Sugiman (50) dan Minarti (50) warga Desa Karangtengah, kita prioritaskan mendapatkan  bantuan RTLH,” katanya.\n" +
                "Seminggu sekali memang ada program tilik warga, kebetulan ada laporan dari media sosial, salah satu warga Desa Karangtengah butuh bantuan RTLH.\n" +
                "“Dari hasil cek di lapangan memang pantas kita bantu RTLH, rumahnya mau ambruk dan pekerjaannya juga tidak jelas. Maka kita pastikan untuk mendapatkan bantuan tahun ini,” ungkapnya.\n" +
                "Walaupun nanti saat pembongkaran  rumah di bantu Pemerintah Kabupaten Batang, tetapi harus ada partisipasi warga untuk ikut membantu membangun rumahnya.\n" +
                "“Tadi kata Pak Kepala desa, warganya siap dilibatkan untuk gotong royong karena bantuan Pemkab hanya Rp12,5 juta. Rp10 juta untuk bangun rumahnya, lalu Rp2,5 juta boleh untuk bayar tenaga kerjanya. Semoga saja  tenaga dari warga ikhlas semuanya, lagian sudah ada bata dan batu,” terangnya.\n",R.drawable.membantu));

        firstNews1.add(new News("VAKSINASI NAKES KABUPATEN BATANG DIRENCANAKAN FEBRUARI 2021","Categorie Novel","Para Tenaga Kesehatan (Nakes) Kabupaten Batang tampaknya harus lebih bersabar dalam menerima vaksinasi. Pasalnya, ada sedikit perubahan jadwal dari semula 14 Januari, kini mengalami pergeseran penjadwalan.\n" +
                "Hal itu disebabkan Kabupaten Batang bukan merupakan daerah penyangga, sedangkan Pemerintah Pusat saat ini lebih mengedepankan wilayah penyangga seperti Kabupaten Semarang, Kota Semarang, Kota Surakarta dan Kota Magelang.\n" +
                "Kepala Bidang Pengendalian dan Pemberantasan Penyakit (P2P) Dinas Kesehatan Batang, Yuli Suryandaru mengemukakan, bagi para Nakes yang telah terdaftar tetap bersabar dan menunggu pendistribusian dari pusat, karena semua keputusan ditentukan oleh Komite Penanggulangan Covid dan Pemulihan Ekonomi Nasional (KPC PEN).\n" +
                "“Tunggu saja informasi selanjutnya dari pusat, kita belum tahu, kemungkinan bulan Februari,” katanya saat ditemui di Kantor Dinas Kesehatan Kabupaten Batang, Selasa (12/1/2021).\n" +
                "Ia menegaskan, Kabupaten/Kota lain pun mengalami hal serupa, yaitu tetap menunggu keputusan dan waktu pendistribusian dari pusat.\n" +
                "“Penjadwalan ulang bagi para Nakes ini dapat diambil hikmah. Justru dengan melihat keempat wilayah tersebut, mereka bisa menjadikannya referensi,” imbaunya.\n",R.drawable.vaksin));

        firstNews1.add(new News("DINKES BATANG TARGETKAN VAKSINASI HINGGA 2022","Categorie Novel","Pekan depan direncanakan Vaksin Sinovac buatan Republik Rakyat Tiongkok (RRT) akan tiba ke Dinas Kesehatan (Dinkes) Kabupaten Batang, dan akan segera mulai digelar vaksinasi perdana pada 14 Januari mendatang.\n" +
                "Untuk memaksimalkan vaksinasi Dinkes menyiapkan 26 Fasilitas Pelayanan Kesehatan (Fasyankes). Di antaranya RSUD Batang, RSUD Limpung, RS QIM, 21 Puskesmas, Klinik Pratama Kartika-36 dan Klinik Dokkes Polres Batang.\n" +
                "Kepala Bidang Pengendalian dan Pemberantasan Penyakit (P2P) Dinkes Batang, Yuli Suryandaru memaparkan beberapa pihak yang akan diprioritaskan memperoleh vaksin tahap pertama.\n" +
                "“Sasarannya Januari - April untuk 2.554 tenaga kesehatan, 90.638 lansia dan 23.913 tenaga pelayanan publik (ASN/TNI/Polri), April 2021 Maret 2022 untuk 284.025 masyarakat rentan dan 92.891 masyarakat umum,” katanya saat ditemui di Kantor Dinkes Kabupaten Batang, Jumat (8/1/2021).\n" +
                "Yuli mengharapkan, proses vaksinasi akan selesai hingga pertengahan tahun 2022. Untuk tahap pertama data para tenaga medis telah diperoleh dari Kememkes RI yang dapat dicek melalui laman https://pedulilindungi.id.\n",R.drawable.vaksinasi_2022));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recycleview_id);
        NewsAdapter myAdapter = new NewsAdapter(this, firstNews1);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);
    }
}