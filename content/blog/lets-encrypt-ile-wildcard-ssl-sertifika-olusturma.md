---
Title: Let's Encrypt ile Wildcard SSL Sertifika Oluşturma
Date: 2021-03-10T22:00:00+03:00
Author: Aşkın Özgür
Category: Günlük
Slug: lets-encrypt-ile-wildcard-ssl-sertifika-olusturma
draft: false
---

Let's Encrypt kullanarak **wildcard** sertifika oluşturabiliyoruz. Normal şartlarda sertifika oluştururken `http://domain.com/.well-known` altında bir dosya oluşturularak o alan adının sahibi doğrulanıyor. Fakat wildcard sertifika icin işler değişiyor. Bazı **dns** kayıtları girmemiz gerekiyor. Bunu kendimiz yapabileceğimiz gibi bu işi otomatize eden scriptler de kullanabiliyoruz. 
<!--more-->
Ben dns kayıtlarını kendim gireceğim şekilde sertifikayı oluşturacağım.

Sertifikayı oluşturmak için `certbot` kullanıyorum. Aşağıdaki gibi bir komut kullanarak sertifikayı oluşturabiliriz.

```bash
certbot-auto certonly \
    --manual \
    --preferred-challenges=dns \
    --agree-tos \
    -d *.domain.com -d domain.com
```

`domain.com`: kullanacağımız domain için  
`*.domain.com`: 1. seviye wildcard sertifika için  

Ben ilk denememde parametre olarak sadece `*.domain.com` vermemin yeterli olacağını düşünmüştüm, fakat bu durumda `domain.com` sertifika içine eklenmiyor. Bu nedenle `sub.domain.com` için sertifika geçerli olurken `domain.com` için hala sertifikamız olmuyor. Aynı şekilde sertifika `sub.sub.domain.com` için de geçerli olsun istiyorsak `*.sub.domain.com`u da eklememiz gerekmekte.

Sertifika oluşturmak için komutu çalıştırdımızda kaç adet domain girmişsek bizden okadar `TXT` kaydı girmemiz istenecek. Zaten interaktif olarak `certbot` bizi yönlendirecektir.

```dns
_acme-challenge.domain.com. IN TXT some-hash
_acme-challenge.sub.domain.com. IN TXT some-hash
```

Bu yöntemin kötü yani her 3 ayda bir benzer işlemleri tekrar tekrar yapmamız gerekmesi. Eğer dns kayıtlarınızı bir API yada script ile değiştirebiliyorsanız bunu otomatize edebilirsiniz. Mesela [bu yazıda](https://www.digitalocean.com/community/tutorials/how-to-acquire-a-let-s-encrypt-certificate-using-dns-validation-with-acme-dns-certbot-on-ubuntu-18-04) bunu nasıl yapabileceğiniz anlatılıyor. Siz de benzer birşey kullanabilirsiniz. Benim böyle bir ihtiyacım kalmadığı için kullanmadım.

