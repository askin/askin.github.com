---
layout: post
title: "MySQL Yedek Alma"
published: true
tags:
- mysql
- yedek
- backup
- mysqldump
type: post
status: publish
---
Yedek almak için mysqldump aracını kullanıyoruz.

    mysqldump -u kullanici_adi -h sunucu_adi db_adi -p > db_adi_yedek.sql

Alınan yedeği tekrar yüklemek için mysql komutunu kullanıyoruz

    mysql -u kullanici_adi -h sunucu_adi db_adi -p < db_adi_yedek.sql
