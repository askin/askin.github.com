---
Title: Screen ile Irssi Kullanım Kılavuzu
Date: 2013-11-15T17:17:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["irc", "irssi", "Linux", "screen"]
Slug: screen-ile-irssi-kullanim-kilavuzu
Status: published
---

irssi~[\[1\]](#irssiwebsite "Irssi Web Sistesi" id="hohoho")~ komut satırından çalışan ve bir çok geliştirici için popüler olan bir IRC istemcisidir. Irssi GNU Screen~[\[2\]](#screen "Screen Wiki Sayfası")~ programı ile birlikte kullanılarak çıkış yapmadan bir veya birden fazla kabuk yaratabilirsiniz. Sürekli biligisayar değiltirip fakat irssi'a kaldığınız yerden devam etmek istediğinizde çok kullanılışılır.

Avantajları:

-   Kişiler size mesaj bırakabilir.
-   Siz dışardayken yapılan görüşmeleri sonradan yakalayabilirsiniz (genellikle "scroolback" olarak adlandırılır).

Yönergeler:

-   Bir adet linux VPS edinin ya da sık sık yeniden başlatılmayacak, ihtiyacınız olan yerden bağlanabileceğiniz \*nix makina üzerinde ssh hesabı edinin.
-   Bu hesaba bağlanmak için ssh kullanın. Windowsta PuTTY~[\[3\]](#putty "PuTTY Web Sayfası")~ gibi bir istemci kullanın. Eğer Linux yada Unix temelli bir işletim sistemi kullanıyorsanız zaten ssh kuruludur.
-   Ssh hesabına bağlandığınızda, irssi'yı screen oturumu içinde başlatın. Aşağıdaki şekilde yapabilirsiniz.


```sh
screen
# screen will flash and go back to the default prompt.  You are now inside screen
irssi
```


-   Irc uygulaması IRSSI'yı başlatmak yeni komut satırına "irssi" yazın. Bir not olarak, eğer bir screen oturumundan çıkmak istiyorsanız komut satırından "exit" yazmanız sizin screen oturumunu açtığınız ilk noktaya dönmenizi sağlayacaktır.
-   IRSSI komut satırı içinde bir sunucuya bağlanmak:

        /connect irc.mozilla.org

    yada

        /connect irc.freenode.net

-   Bir kez bağlandıktan sonra

        /join #hadron

-   /connect ve /join komutlarını tekrarlayarak birden fazla sunucuya katılabilirsiniz.
-   Screen yazılımı sizin irssi yazılımından çıkmanıza ve tekrar bağlanmanıza izin verir.
    -   IRSSI'dan çıkmadan komut satırına geri dönmek istersen önce "ctrl+a" sonrada "ctrl+d" komninasyonuna bas
    -   Eğer IRSSI'a tekrar bağlanmak istiyorsanız "screen -raAd" komutunu çalıştırın.
    -   Eğer çalışan screen süreçlerini görmek istiyorsanız "screen -ls" komutunu kullanabilirsiniz.
    -   Eğer screen sürecine bir isim vermek istiyorsanız "screen -S irc" komutunu kullanabilirsiniz. Bu şekilde screen komutuna irc adını vermiş oluruz. Buna tekrar bağlanmak için "screen -r irc" komutunu kullanabilirsiniz.

Sıkça Sorulan Sorular:

1. Ön tanımlı takma ismi(nick) nasıl değiştirebiliriz?
  - Irssi içinde, "/set nick takmaisim" ya da "/nick<takmaisim>", iki yöntemde çalışacaktır.</takmaisim>

2. Açık kanallarımı, özel mesajlarımı ve sunucu pencerelerini görebilmek için nasıl pencereler arasında geçiş yapabilirim?

  - Alt tuşuyla birlikte o pencerenin numarasını kullanarak geçiş yapabilirsiniz. Mesala Alt+1 sucunu penceresine gidecekti.
  - Eğer bu çalışmıyorsa, Alt tuşu yerine Esc kullanın. Bunun her zaman çalışması gerek.&gt;/li&gt;

3. Mevcut kanaldaki tüm kullanıcıları nasıl listelerim?

  - /names yada /who yazabilirsiniz.

4. Irssi ekranında 'Act: 3' ne anlama geliyor?

  -  Irssi ekranınızda, \[2:\#hadron\] \[Act:3,4\] göreceksiniz. Bu numaralar ne anlama geliyor? 2'nin anlamı bulunduğunuz sohbet ekranı. 3 ve 4 diğer açık sohbetler.
  -  Eğer 3 mavi renkteyse, bunun anlamı birilerin durumu değişti (giriş - çıkış yapıldı).
  -  Eğer 3 beyaz ise, o sohbette muhabbet devam ediyor.
  -  Eğer 3 pembe ise, özellikle sizin ilginizi çekecek bir nedenden dolayı size ekstra bir mesaj yollandı.
  -  Eğer bir sohbetten diğerine geçiş yapmak istiyorsanız, alt+screen\# kombinastonunu kullanın(screen\# =&gt; geçmek istediğiniz ekranın numarası).

5. Açık bir pencereyi nasıl kapatabilirim?

  - Kapatmak istediğiniz pencereye geçin, ve /window close (yada /wc) yazıp enter'a basın.

6. İkinci seferde hesabıma nasıl giriş yapabilirim.

  - "screen -r" komutunu terminale yazarak.

7. Birden fazla screen oturumum var fakat şuan kullandığım screen oturumunu açmak istiyorun. Nasıl yapabilirim?

  - Komut satırına "screen -x" yazın.

8. Ekranı aşağı yukarı nasıl kaydırabilirim.

  - Page Up & Page Down

9. Birisiyle irc üzerinde nasıl özel sohbet yapabilirim?

  - Birisiyle özel sohber başlatmak için konuşacağınız kişinin ismini bilmelisiniz. "/names" komutunu yazarak odadaki kişileri listeleyip konuşacağınız kişiyi belirleyebilirsiniz ve "/query takmaad" ya da "/q takmaad" yazarak özel sohbeti başlatabilirsiniz.
  - Özel sohbeti kapatmak için "/query" ya da "/q" yazın.

10. Irssi'ı bir bilgisayardan kapatıp diğerinden ulaşmak istiyorum, bu sırada bağlantılarım açık kalsın ve mesajları almaya devam edeyim istiyorum. Nasıl yapabilirim?

  - Ctrl+A tuşlarına bastıktan sonra D tuşuna basmalısınız. (Bu sizi screen oturumundan çıkartacaktır)
  - O bilgisayardan ssh bağlantısını kapatın ve diğer bilgisayara geçin. Irssi'ın kurulu olduğu bilgisayara ssh ile bağlanıp "screen -arAd" komutunu verin.
  - Duyuru: Birdaha bağlanmak zorunda değilsiniz. Irssi'ın çalıştığı bilgisayar kapatılmadığı sürece sunucularla bağlantınız kopmayacaktır.

Bu yazı <http://zenit.senecac.on.ca/wiki/index.php/Irssi_Tutorial> adresindeki dökümanın bir nevi çevirisidir. Bir kısmını kendi kafama göre düzenledim. Bir kısmı pek anlaşılır değil, fazla zaman kaybetmek istemedim. Yorumlarla katkı verirseniz daha anlaşılır bir döküman haline getirebilirim.

- <a id="irssiwebsite"></a>[\[1\] http://www.irssi.org/](http://www.irssi.org/ "irssi web sitesi")
- <a id="screen"></a>[\[2\] http://en.wikipedia.org/wiki/GNU\_Screen](http://en.wikipedia.org/wiki/GNU\_Screen)
- <a id="putty"></a>[\[3\] http://cdot.senecac.on.ca/software/putty/](http://cdot.senecac.on.ca/software/putty/)
