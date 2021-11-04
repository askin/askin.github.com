---
Title: Pardus Ağ Yöneticisi İle Eduroam Ağına Bağlanmak
Date: 2009-12-07T09:45:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["eduroam", "network-manager", "pardus", "pisi", "python", "wireless-tools"]
Slug: pardus-ag-yoneticisi-ile-eduroam-agina-baglanmak
Status: published
---

![Pardus](/uploads/2009/05/pardus.png "Pardus")Bikaç gündür [Pardus](http://www.pardus.org.tr) ve [Eduroam](http://www.eduroam.org/) ile uğraşıyordum. Eduroama bağlanmak için pratik yollar buldum fakat hiç birisi Ağ Yöneticisi kullanarak bağlanmanın zevkini vermiyordu.

2 gün boyunca Ağ Yöneticisinin neresini değiştirmem gerektiğini arayıp durdum. Sonunda wireless-tools adlı paketin aradığım paket olduğunu keşfettim :) wireless tools paketi wpa\_supplicant kullanarak wpa şifreleme kullanan ağlara bağlanmaya yarıyor. Sağolsun Pardus geliştiricileri wpa\_supplicant paketi için dbus kullanan bir python betiği yazmışlar. Bu betik içinde tanımlanan methodlarla wpa\_supplicantı yönetebiliyoruz. Bu betiğe eduroam ağına bağlanmak için gerekli parametreleri alan bir method ekledim.  
Daha sonra wireless-tools paketi içindeki comar betiğine bu methodu kullanmasını sağlayacak birkaç değişiklik yaptım.

Sırf bu işi denemek için bugün okulum olmadığı halde sabahın 8'inde okula gelip deneme yaptım. Ayarlarını evde yaptığım için bilgisayarı açar açmaz internete bağlandı :) Hayatımda ilk kez yazdığım bir kod direk çalıştı :P

Düzenlediğim bu 2 pakete aşağıdaki adreslerden ulaşabilirsiniz.  
<http://github.com/askin/kelebekpisi/tree/master/wpa_supplicant/>  
<http://github.com/askin/kelebekpisi/tree/master/wireless-tools/>

Paketleri kendiniz derlemek için root yetkileriyle

```bash
pisi bi http://github.com/askin/kelebekpisi/raw/master/wpa_supplicant/pspec.xml
pisi bi http://github.com/askin/kelebekpisi/raw/master/wireless-tools/pspec.xml
```

komutlarını vermelisiniz, ardından oluşan pisi paketlerini kurabilirsiniz.

Ya da hazır ikili pisi paketlerini <http://askin.ws/pisi/eduroam/> adresinden bulabilirsiniz.

Paketleri kurduktan sonra ayarları yaparken Güvenlik Türü seçeneğini "WPA & WPA2 Enterprise" olarak seçmelisiniz.

Son olarak wireless-tools paketi Pardus'un temel paketlerinden birisidir, wpa\_supplicant paketi de wpa ağlarına bağlanmak için gerekli temel bir pakettir. Bunları Pardus deposu dışında bir yerden kurmak sisteminize zarar verebilir. Sorumluluk kullanıcıya aittir :)

Benim sistemime hiç bir şey olmadı, %99.99 olasılıkla sizin siteminize de zarar gelmez fakat ben yinede hiç bir sorumluluk almıyorum :)

<!--more-->
