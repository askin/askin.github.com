---
Title: Yine Yasak - Proxy nedir? Nasıl ayarlanır.
Date: 2008-01-25T17:43:00+03:00
Author: askin
Category: Günlük
Tags: ["Proxy", "Telekom"]
Slug: yine-yasak-proxy-nedir-nasil-ayarlanir
Status: published
---

Youtube son haberlere göre arka arkaya 3. kez kapatılacak. Şuan girebiliyorum sorun yok. Ama yakında bişiler olacak:) Geçen kapandığında DNS adresini değiştirmemiz de işe yaramamıştı. Şimdi yapacağımız şey ise proxy kullanmak olacak. Gerçi proxy kullanmak sakat bi yöntem, bütün trafiğimiz başka bir bilgisayar üzerinden geçeceği için verilerimizin dinlenme ihtimali var. Bu nedenle proxy kullanırken dikkatli olmakta fayda var.

Proxy olayında biz isteklerimizi bir vekil sunucuya iletiyoruz. Sunucuda bizim yerimize ilgili sitenin içeriğini alıyor ve bize sunuyor. Kabaca bu şekilde tanımlayabiliriz.

<!--more-->

Proxy ayarlarını yapmak için browserın(tarayıcının) ayarlarını yapmamız gerekiyor.

Firefox için düzen yada araçlar -&gt; seçenekler -&gt; gelişmiş -&gt; ağ -&gt; vekil sunucu ayarlarına geldiğimizde çıkan kutucuğa(sadece ilkine) aşağıdaki ipleri ve port numaralarını gireceğiz.

![Yine Yasak - Proxy nedir? Nasıl ayarlanır Firefox](/uploads/2008/01/ff.jpg)

İnternet explorer için Araçlar &gt; İnternet Seçenekleri &gt; Bağlantılar &gt; Yerel Ağ Lan Ayarları &gt; Proxy Sunucusu Kutucuğunu İşaretle ve kutucuğa aşağıdaki iplerden birini bağlantı noktasınada port numarasını giriniz.

![Yine Yasak - Proxy nedir? Nasıl ayarlanır İnternet explorer](/uploads/2008/01/ie.jpg)

Daha detaylı bir açıklama ve biraz daha üst seviye işler için [Bu Dökümana](/uploads/2008/01/ssh_tunneling_over_cf.pdf "ssh tunelling") bi göz atın.

Proxy Listesi

  ----------------- ----------
  **IP**            **PORT**
  200.65.127.161    3128
  165.228.128.11    80
  165.228.132.11    80
  203.144.144.163   80
  203.144.144.164   80
  203.144.144.163   8080
  ----------------- ----------

Bu adresler siz denediğiniz zaman aktif olmamayabilir. Gugıldan aktif proxy listesi ve ya proxy list tarzında bi araştırma yaparsanız karşınıza onlarca proxy çıkacaktır. Birkaç denemeyle amacınıza ulaşabilirsiniz.

Resimler ve ip numaraları için <http://www.eno7.org/>'a teşekürler.
