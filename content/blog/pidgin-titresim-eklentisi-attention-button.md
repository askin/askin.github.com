---
Title: Pidgin Titreşim Eklentisi - Attention Button
Date: 2009-06-07T21:20:00+03:00
Author: askin
Category: Linux
Tags: ["attention button", "gnome", "im", "Linux", "pidgin"]
Slug: pidgin-titresim-eklentisi-attention-button
Status: published
---

![Pidgin](/uploads/2009/06/pidgin.png "Pidgin")Pidginin en sevdiğim özelliklerinden bir tanesi, sohbet ettiğiniz kişi size tireşim gönderdiğinde ekrana sadece **"... size uyarı gönderdi"** yazması. Bu özelliğer sahip olmasının birde dezavantajı var tabiki, siz de başkalarına titreşim yollayamıyorsunuz. Bugün bu eksikliği fazlasıyla hissedince ufak çaplı bir araştırma yaptım ve [Attention Button](http://code.google.com/p/pidgin-attentionbutton/) eklentisiyle karşılaştım.  
Kurulumu çok basit. [Burdan](http://code.google.com/p/pidgin-attentionbutton/downloads/list) en güncel sürümünü indiriyorsunuz (şimdilik [0.3](http://pidgin-attentionbutton.googlecode.com/files/attentionbutton-0.3.tar.gz)), arşivden çıkartıp *.so* uzantılı dosyayı ev dizininiz altında *.purple/plugins/* dizinine kopyalıyorsunuz. Ardından pidgine gidip eklentiler(plugins) kısmından aktif ediyorsunuz.  
Konsoldan halletmek isterseniz:

```bash
$ wget http://pidgin-attentionbutton.googlecode.com/files/attentionbutton-0.3.tar.gz
$ tar -xvzf attentionbutton-0.3.tar.gz
$ mkdir $HOME/.purple/plugins
$ mv attentionbutton.so $HOME/.purple/plugins/
$ rm attentionbutton-0.3.tar.gz attentionbutton.c 
```

Bu eklentinin birkaç güzel özelliğide var. Mesela karşı tarafa sınırsız sayıda titreşim yollayabilirsiniz. Ve karşı taraf çevrim dışı bile görünse titretebilirsiniz. Tabi aşırı kullanım sağlığa zararlı :)
