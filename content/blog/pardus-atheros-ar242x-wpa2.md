---
Title: Pardus - Atheros AR242x - WPA2
Date: 2009-06-02T21:48:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["ar242x", "atheros", "Linux", "pardus", "wicd"]
Slug: pardus-atheros-ar242x-wpa2
Status: published
---

![Wi-Fi](/uploads/2009/06/wifi.jpeg "Wi-Fi")Pardus 2008 kurulumla beraber Atheros AR242x kablosuz ağ kartını tanıyor, fakat nedense başka ağları görmesine rağmen evimde WPA2 ile kurulu kablosuz ağımı göremiyordu. Bende diğer dağıtımlarda kullandığım ndiswrapper ile sorunumu çözmeyi denedim.  
Öncelikle ndiswrapperı kurduktan sonra windows için yazılmış driverları seçmemiz gerekiyor. Ardından  
`/etc/modules.autoload.d/kernel-2.6`  
dosyasına  
`ndiswrapper`  
satırını ve  
`/etc/modprobe.d/blacklist-compat`  
dosyasına da  
`blacklist ath_pci`  
satırını eklemek gerekiyor. Bunları ekledikten sonra kde'de ağ programcığıyla bağlanabiliyorsunuz.  
Fakat XFCE kullanıyorsanız wicd kullanmanız gerekiyor. Wicd ile doğrudan kullanamıyoruz. Öncelikle birkaç ufak düzenleme yapmak gerekiyor.  
Wicd -&gt; Tercihler yolunu takip ettikten sonra WPA Suplicant Sürücüsü: kısmına *wext*, Kablosuz arabirim kısmına da *wlan0* yazmak gerekiyor.  
Bu ayarlarla kolaylıkla kullanabilirsiniz, kolay gelsin.
