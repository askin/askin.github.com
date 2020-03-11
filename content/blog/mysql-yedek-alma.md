---
Title: MySQL Yedek Alma
Date: 2013-03-11T16:42:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["backup", "mysql", "mysqldum"]
Slug: mysql-yedek-alma
Status: published
---

Yedek almak için mysqldump aracını kullanıyoruz.

    mysqldump -u kullanici_adi -h sunucu_adi db_adi -p > db_adi_yedek.sql

Alınan yedeği tekrar yüklemek için mysql komutunu kullanıyoruz

    mysql -u kullanici_adi -h sunucu_adi db_adi -p < db_adi_yedek.sql
