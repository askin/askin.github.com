---
Title: Yasaklı sitelere girme - Open DNS
Date: 2008-01-18T18:52:00+03:00
Author: Aşkın Özgür
Category: Günlük
Tags: ["OpenDNS", "Proxy", "Telekom"]
Slug: yasakli-sitelere-gitme-open-dns
Status: published
---

Yasaklı sitelere girebilmek için çok çeşitli yöntemler kullanabilirsiniz. Ben çok sıklıkla [www.gizlen.net](http://www.gizlen.net "İzlenme Gizlen")'i kullanabilirsiniz. Bu siteye giriyorsunuz ve sayfanın üstündeki kutucuğa gireceğiniz siteyi yazıyorsunuz, oda size gireceğiniz siteyi sunuyor. Eğer daha kalıcı bir çözüm istiyorsanız proxy(vekil sunucu) kullanabilirsiniz. İnternetten ufak bir arama ile onlarca proxy adresine sahip olabilirsiniz. Ancak birçok kişi tarafınfan kullanılan ve tavsiye edilen [Open DNS](http://www.opendns.com/ "Open DNS sitesine gitmek için tıklayın: ") işinizi çok rahatlıkla görebilir. Gerçi Open DNS bir proxy değil. O bir Name Server. Bizim www.bobrektasi.org gibi girmeye çalıştığımız sitelerin ip adreslerini çözümleyip bizi doğru makineye yönlendiriyor. Bu bu yönlenme işini Open DNS üzerinden yaptığımız için TTnet'in bizim girdiğimiz sitelere müdahale etme şansı kalmıyor.  
Adresi: <http://www.opendns.com/>  
<https://www.opendns.com/start> Bu adresten ayarların nasıl yapıldığını öğrenebilirsiniz.

Ubuntu için ayarlar:  
İlk önce Networ Admin Proramını açıyoruz:

-   Sistem -&gt;Yönetim -&gt; Ağ yolunu takip ederekte çabilirsiniz.
-   \[Alt + F2\] yapıp *gksu network-admin* yazarakta açabilirsiniz.
-   konsoldan `$ sudo network-admin` komutunu vererekte açabilirsiniz.

Burda DNS sekmesi altına  
`208.67.222.222 208.67.220.220` iplerini ekliyorsunuz.

Ardından konsolda

```bash
sudo cp /etc/resolv.conf /etc/resolv.conf.auto
sudo gedit /etc/dhcp3/dhclient.conf
```

komutlarını giriyorsunuz.  
Karşınıza çıkan editöre  
`# append the following line to the document prepend domain-name-servers 208.67.222.222,208.67.220.220; # save and exit`  
satırlarını ekliyorsunuz. ve

```bash
$ sudo ifdown eth0 && sudo ifup eth0
```

komutunu veriyorsunuz. Eğer bu komutlarda bi hata verirse, ya da dns değişmemişse bilgisayarı açıp kapatın artık özgürsünüz.Şimdi [www.youtube.com](http://www.youtube.com,)'a girerek deneyebilirsiniz çalışıyormu diye:)

<!--more-->
