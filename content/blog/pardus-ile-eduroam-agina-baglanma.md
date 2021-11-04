---
Title: Pardus ile Eduroam ağına bağlanma
Date: 2009-12-05T02:02:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["dhcpcd", "eduroam", "Linux", "network", "network-manager", "pardus", "pem", "wpa"]
Slug: pardus-ile-eduroam-agina-baglanma
Status: published
---

![Eduroam](/uploads/2009/12/eduroam_logo_trans.gif "Eduroam")[Pardus](http://www.pardus.org.tr/)un ağ yöneticisi gayet şık bir arayüze sahip, fakat bize [Eduroam](http://www.eduroam.org/) ağına bağlanma özelliği sunmuyor.  
Ancak Pardus kurulumu ile birlikte gelen 2 araç bizim bu ağa bağlanmamız için yeterli. Bu araçlar [wpa\_supplicant](http://hostap.epitest.fi/wpa_supplicant/) ve [dhcpcd](http://roy.marples.name/projects/dhcpcd). Wpa\_supplicant ağda kimlik denetimini sağlamak için, dhcpcd ise ağdan ip almamız için gerekli.

Öncelikle wpa\_supplicant için ayar dosyası oluşturmamız gerekiyor.

```conf
network={
        ssid="eduroam"
        key_mgmt=WPA-EAP
        pairwise=TKIP
        group=TKIP
        eap=TTLS
        phase2="auth=PAP"
        anonymous_identity="anonymous@ogr.deu.edu.tr"
        identity="ogrencinumarasi@ogr.deu.edu.tr"
        password="sifre"
}
```

Bu ayarlar Dokuz Eylül Üniversitesi için. Kendi okulunuza göre düzenlemeniz gerekiyor. Sadece ogr.deu.edu.tr adresi yerine kendi okulunuzun adresini yazmalısınız.

Bu dosyayı /etc/wpa\_supplicant.con adıyla kaydediyoruz.

Sıra geldi wpa\_supplicantı çalıştırmaya.

```bash
wpa_supplicant -Dwext -iwlan0 -c/etc/wpa_supplicant.conf
```

-D parametresi hangi sürücüyü kullanacağımızı belirtiyor. Wpa\_supplicantın man dosyalarına bakarak kendinize uygun bir sürücü seçebilirsiniz.  
-i hangi arayüzü kullanacağınızı belirtiyor. Genellikle wlan0 dır. iwconfig komutunun çıktısı size kablosuz ağ kartlarını gösterecektir.  
-c ile ayar dosyamızın yerini belirtiyoruz.

Eğer bu komut başarılı olursa artık ip alabiliriz.

```bash
dhcpcd wlan0
```

Eğer bu komutta başarılı olduysa artık internete bağlanabilirsiniz hayırlı olsun :)

Bu işlemi kolaylaştırmak için pem adında bi script yazdım.

```bash
git clone git://github.com/askin/pem.git
```

Bu komutla pem'e ulaşabilirsiniz.  
Bu aracı daha fazla geliştirecektim fakat ağ yöneticisiyle bu işleri nasıl yapabileceğimi öğrendim. Bugün oturup biraz network-managerın kodlarıyla uğraştım. Sanırım pazartesi günü bu işi ağ yöneticisiyle kolayca yapılabilecek bir hale getirebilirim. Şimdilik en güzel yöntem bu gibi :)

Ayrıca sevgili dostum [Mete](http://blog.metebilgin.com/) bu işin wicd kullanarak nasıl yapıldığını daha önce yazmış [buradan](http://blog.metebilgin.com/2009/10/pardus-2009-da-eduroam-kafay-yemeden.html) o yazıya ulaşabilirsiniz.

<!--more-->
