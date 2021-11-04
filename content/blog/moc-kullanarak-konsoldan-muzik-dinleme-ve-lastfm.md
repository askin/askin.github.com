---
Title: Moc kullanarak konsoldan müzik dinleme ve lastfm
Date: 2008-06-12T16:25:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["konsol", "lastfm", "lastfmsubmitd", "moc"]
Slug: moc-kullanarak-konsoldan-muzik-dinleme-ve-lastfm
Status: published
---

[Moc](http://moc.daper.net/) player konsolda çalışan bir müzik çalıcı. Açılımı Music on Console. Mocun en çok sevdiğim özelliği x ortamı yeniden başlasa, kapansa, göçse bile hiç sorun çıkarmadan çalmaya devam ediyor. Yani depremde, selde ve yangında 7\*24 hizmet:)  
**Kurulum**  
\* debian - ubuntu - vs.  
`sudo apt-get install moc`

\* pardus  
`sudo pisi it moc`

Şimdi konsoldan  
`mocp`  
komutunu verelim. Gerçekten renkli şık bi tasarımı var. Grafik ekranı hiç aratmıyor:). Eğer renkleri beğenmezseniz **\[Shift\] + \[T\]** kombinasyonu ile farklı renkler seçebilirsiniz. Bunun bi kötü yanı var moc temayı bir sonraki açılışında hatırlamayacak. Hatırlaması için *\~/.moc/config* dosyasını oluşturup içeriğini düzenlemeniz gerekiyor. Ben düzenlemedim tam olarak nasıl yapılıyor bilmiyorum. Bunun için [burayı](http://dreamore.wordpress.com/2007/07/01/konsol-fantazyasi-3/) biraz zorlasanız fena olmaz.

<div class="dikkat">

Tamamdır olay çözüldü. [Burdan](/uploads/2008/06/config.example) benim config dosyamı indirebilirsiniz. Yapmanız gereken bu dosyayı *\~/.moc/* dizinine *config* adı ile kaydetmek.  
Aşağıda config dosyasına bi satır daha eklemeniz gerekiyor. bu örnek dosyada o satır eklenmiş durumda. Eğer Bu örnek dosyadı kullanırsanız o adımı atlayabilirsiniz.

</div>

Şimdi gelelim moc ile dinlediğimiz parçaların last.fm'e gönderilmesine.  
Bunun için lastfmsubmitd adında bir program kullanacağız. Bu program deamon olarak çalışarak göndermesini istediğimiz bilgileri last.fm'e yollamayı kendine amaç edinmiş bir servis.

**Kurulum:**:  
\* debian - ubuntu - vs.  
`sudo apt-get install lastfmsubmitd`

\* pardus (varlığından emin değilim)  
`sudo pisi it lastfmsubmitd`

kurulum sırasında sizden lastfmde kullandığınız kullanıcı adı ve şifresi isteniyor. Eğer bu sırada yanlış girdiyseniz */etc/lastfmsubmitd.conf* dosyasını düzenleyebilirsiniz. Kurulum sırasında *lastfm* adında bir kullanıcı ve grup yaratılacak. Güvenlik açısından bu dosyanın sahibinin *lastfm* olduğunu ve iznininde 0600 olduğuna emin olun. Yoksa herhangi birisi  
`cat /etc/lastfmsubmitd.conf `  
komutu ile lastfm kullanıcı adınızı ve şifrenizi elegeçirebilir.

`sudo addgroup kullanici_adi lastfm`  
komutu ile kullanıcı adınızı *lastfm* grubuna ekleyin.

<div class="dikkat">

ubuntuda kullanıcı adının gruba eklenmesi için sistemi yeniden başlatmam gerekiyor. sanırım benim eksik yaptığım birşeyler var:( bu nedenle eğer last.fm e şarkıları yollayamıyorsanız sistemi yeniden başlatmayı deneyin(ama şimdi değil daha yapacaklarımız var).

</div>

Bir metin düzenleyici ile *\~/.moc/config* dosyasını açın ve içine

`OnSongChange = "/usr/lib/lastfmsubmitd/lastfmsubmit --artist %a --title %t --length %d --album %b"`

satırını ekleyin.

**Lastfmsubmitd servisini başlatın.**  
\* debian - ubuntu - vs.  
`sudo /etc/init.d/lastfmsubmitd start`

\* pardus  
`service lastfmsubmitd start`

Eğer sorunlarınız olursa yazıyı baştan birdaha okuyun. Hala sorunlarınız devam ediyorsa aşağıdaki kaynaklara bir göz atın, ve hala sorunları çözemediyseniz yorum yazın:)

**Kaynaklar**:

-   [Dreamore](http://dreamore.wordpress.com/2007/07/01/konsol-fantazyasi-3/)
-   [/home/plb](http://devnulll.blogspot.com/2007/08/how-to-submit-songs-to-lastfm-whilst_03.html)
-   [Lapis Wiki](http://wiki.linux-sevenler.org/index.php/Mpd)

<!--more-->
