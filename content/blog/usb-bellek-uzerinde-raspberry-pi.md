---
Title: Usb bellek üzerinde Raspberry PI 
Date: 2013-03-24T20:39:00+03:00
Author: askin
Category: Linux
Tags: ["boot", "Linux", "raspberry pi", "raspbian", "sd"]
Slug: usb-bellek-uzerinde-raspberry-pi
Status: published
---

Malesef sd kart olmadan raspberry pi'yı boot etmemiz mümkün olmuyor. Benim elimde 1GB'lık bir sd kart vardı ve 2GB dan daha ufak imaj dosyaları bulamadım. Bu nedenle usb bellek ile boot etme ihtiyacı duydum.  
Benim sistemimde usb bellek ve sd kart aşağıdaki şekilde tanındı:  
- usb: /dev/sdd  
- sd: /dev/sde

Öncelikle indirdiğimiz imaj dosyasını usb belleğimize kopyalıyoruz

    dd if=2013-02-09-wheezy-raspbian.img of=/dev/sdd

Elimizde bulunan sd karta 1 adet fat32 bölüm oluşturuyoruz (oluşturduğunuz bölüm hem ilk sırada hem de birincil bir bölüm olmalı). Bunu ister Gparted gibi bir araçla yapın isterseniz fdisk kullanın. Bölümleme işlemlerini yaptıktan sonra aşağıdaki komutları uygulayın.

    mkdir /tmp/mnt_sd /tmp/mnt_usb
    mount /dev/sdd1 /tmp/mnt_usb
    mount /dev/sde1 /tmp/mnt_sd

    cp /tmp/mnt_usb/* /tmp/mnt_sd

Bu işlemleri yaptıktan sonra /tmp/mnt\_sd/cmdline.txt dosyasını düzenlememiz gerekmekte. Bu dosyada *root=/dev/mmcblk0p2* olan kısmı *root=/dev/sda2* olarak değiştirin.

[Kaynak](http://www.networkinghowtos.com/howto/raspbian-on-raspberry-pi-using-sd-card-usb-memory-stick/)
