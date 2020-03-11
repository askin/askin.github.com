---
Title: cURL ile GET/POST ve cookie kullanımı
Date: 2013-07-10T17:18:00+03:00
Author: Aşkın Özgür
Category: Günlük, Linux
Tags: ["cookie", "cURL", "get", "post"]
Slug: curl-ile-getpost-ve-cookie-kullanimi
Status: published
---

cURL kullanarak komut satırından istediğimiz bir web sayfasına get/post istekleri yapabiliriz. --data parametresi ile post edilecek verileri gönderebiliryoruz. Url sonuna ekleyeceğimiz parametreler de get olarak gönderilecektir.

    curl --data "param1=value1&param2=value2" http://example.com/index.php

Web sayfasının döndürdüğü sonu doğrudan ekrana basılacaktır, bunu bir dosyaya aktarmak için

    curl --data "param1=value1&param2=value2" http://example.com/index.php > result.html

bir değişkene aktarmak için

    result=$(curl --data "param1=value1&param2=value2" http://example.com/index.php)

kullanabiliriz. Erişmek istediğimiz web sayfası kullanıcı girişi istiyorsa cookie kullanrak bunu yapabiliriz.

    curl --data "username=askin&password=pasw0rd" http://example.com/login.php -c cookie.cook

Bu komutla giriş yapıp, oluşturulan cookie'yi cookie.cook dosyasına kaydettik.  
Tabi burda username ve password parametreleri değişiklik gösterebilir, gönderilen form verisini inceleyerek, gerekli parametreleri bulup uygun formatta göndermek gerekir.

    curl --data "param1=value1&param2=value2" http://example.com/user_info.php -b cookie.cook

Bu şekilde de bir önceki komutla elde ettiğimiz cookie'yi kullanarak bir web sayfasına istekte bulunabiliyoruz.

Eğer https ile istek yapmak istediğinizde sorun yaşıyorsanız "-k" parametresini kullanarak bu sorunu aşabilirsiniz.[Bu adreste](https://gist.github.com/askin/5966708 "Create Asterisk Extension") asterisk sunucu üzerinde extension oluşturan bir shell script var, yazıda anlattıklarım için güzel bir örnek olacaktır.
