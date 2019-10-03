---
Title: Konsoldan Rastgele String Oluşturma
Date: 2013-08-13T12:34:00+03:00
Author: askin
Category: Linux
Tags: ["random", "rastgele", "Shell"]
Slug: konsoldan-rastgele-string-olusturma
Status: published
---

Konsoldan rastgele stringler oluşturmak için bir çok yöntem var, bunların bir çoğu random ve urandom aygıtlarını kullanıyor. Benim şimdi anlatacağım yöntemle urandom aygıtını kullanıyoruz.

```bash
< /dev/urandom tr -dc A-Za-z0-9
```

Burada tr komutuna standart girdi olarak /dev/urandom aygıtını gösteriyoruz. urandom rastgele değerler üretir, bu üretilen değerlerin bazıları yazdırılabilir bazıları da yazdırılamayan karakterlere denk gelir. Biz tr komutu ile bu rastgele üretilen değerlerden alfanümerik olanları ayıklıyoruz. Tabi bu komut sonsuza kadar çıktı üretir, sadece istediğimiz kadarını almak için head komutunu kullanabiliriz.

```bash
< /dev/urandom tr -dc A-Za-z0-9 | head -c32
```

Bu komutla çıktının ilk 32 karakterini alıyoruz.

tr kullanarak yapacaklarımızın limiti hayal gücümüz kadar. Mesela sadece sol elimizi kullanarak girebileceğiniz bir parola üretmek istiyoruz. Aşağıdaki komut bunu üretecektir :)

```bash
< /dev/urandom tr -dc '12345!@#$%qwertQWERTasdfgASDFGzxcvbZXCVB' | head -c8
```

\[1\] adresinde konsoldan rastgele string üretmek için 10 farklı yol gösterilmiş. Ufuk genişletmek için faydalı bir yazı bence.

\[1\] <http://www.howtogeek.com/howto/30184/10-ways-to-generate-a-random-password-from-the-command-line/>
