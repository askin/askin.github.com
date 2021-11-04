---
Title: Mysql Data Dizinini Değiştirme
Date: 2009-07-14T02:11:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["data", "Linux", "mysql", "pardus"]
Slug: mysql-data-dizinini-degistirme
Status: published
---

![Mysql](/uploads/2009/07/mysql.png "Mysql")Mysql data dizini ön tanımlı **/var/lib/mysql** olarak belirlenmiştir. Çeşitli ihtiyaçlardan dolayı bunun yerini değiştirmemiz gerekebilir. Mesela ben ayrı bir bölümde tuttuğum **/home** dizini altına taşımak istiyorum. Tüm işlemleri *root* yetkisiyle yapıyoruz. Öncelikle mysql servisini durduralım.
Ben pardus kullandığım için

```bash
$ service mysql-server stop
```

Diğer dağıtımlarda farklı olabilir.
Ardından ilgili dizini yeni yerine kopyalayalım.

```bash
$ cp -a /var/lib/mysql /home
```

Daha sonra mysql sunucusuna yeni dizinimizi haber verelim. **/etc/mysql/my.cnf** dosyasında
`datadir = /var/lib/mysql` olan satırı
`datadir = /home/mysql` olarak değiştirelim.
Şimdi servisi yeniden başlatabiliriz.

```bash
$ service mysql-server start
```

Eğer düzgün bir şekilde çalışıyorsa **/var/lib/mysql** dizinini silebiliriz. Ama ismini değiştirip birkaç gün her ihtimale karşı saklamak çok mantıklı.

<!--more-->
