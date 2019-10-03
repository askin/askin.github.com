---
Title: Bir GNU/Linux kurulumunu başka bir harddiske/bölüme taşımak
Date: 2009-04-06T22:22:00+03:00
Author: askin
Category: Linux
Tags: ["Linux", "move", "partition", "Shell"]
Slug: bir-gnulinux-kurulumunu-baska-bir-harddiskebolume-tasimak
Status: published
---

![GNU/Linux](/uploads/2009/04/linux-tux.jpg "GNU/Linux") Öncelikle bir çalışan cd ile sistem açılır, benim tercihim gparted live cd. Sizin elinizin altında ne varsa kabuldur. İlla çalışan cd olmasına gerek yok, herhangi bir linux cdside olabilir. Bize mount, cp ve nano komutları lazım. Bunları sağlayan herhangi bir cd kullanılabilir.

Taşınacak kurulumun hangi disk bölümünde olduğu bilinmeli. Ben 2. bölümdeki kurulumu 1. bölüme taşıyacağım. Yani /dev/hdc3 den /dev/hdc1 e taşıma yapacağım(sizdeki disk isimleri muhtemelen farklıdır).

Cd ile sistemi başlattıktan sonra konsola düşmemiz gerekmekte. Ctrl + Alt + F1 tuş kombinasyonu muhtemelen iş görecektir. Ben live cd kullandığım için grafik ekranla karşılaştım, burdan bi terminal açarak işimi göreceğim.

Yapacağımız işlemler için root olmamız gerekiyor. Bu işlemi yapacak cesaretiniz varsa, nasıl root olunur bilginizde vardır diye düşünüyorum :)

Önce diskleri mount ediyoruz

```bash
mkdir /target /source
mount /dev/hdc1 /target
mount /dev/hdc3 -o ro /source
```

Mount işleminden sonra kopyalamaya başlayabiliriz.

```bash
cp -a /source/* /target
```

Bu işlem kopyalanacak verinin boyutuna göre uzunca sürebilir.
Kopyalama tamamlandıktan sonra yeni diskteki /etc/fstab dosyasını ve eski diskteki /boot/grub/menu.lst dosyalarını değiştirmemiz gerekiyor. fstab dosyasında "/" dizininin bağlanacağı yeni bölümü gösteriyoruz. menu.lst dosyasında ise yeni bölümün boot edilebilmesi için gerekli ayarları yapıyoruz.

Eğer eski bölümü silecek veya orayı başka amaç için kullanacaksanız mbr kaydını yenilemeniz gerekmektedir, yani grubu tekrar yeni disk için kurmalısınız.

    grub
     > root (hd0, 0)
     > setup (hd0)

Bende bu şekilde kuruldu, sizde bölüm numaralarına göre değişecektir kurulum.
